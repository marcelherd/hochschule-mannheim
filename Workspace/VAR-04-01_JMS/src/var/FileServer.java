package var;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FileServer implements MessageListener, AutoCloseable {
	
	private static Logger logger = Logger.getLogger("var.FileServer");
	private static String FILES = "files";
	
	private String pathToRoot;
	
	private Session session;
	private Connection connection;
	private MessageProducer messageProducer;
	private MessageConsumer messageConsumer;
	
	/**
	 * Creates a new FileServer.
	 * 
	 * @param pathToRoot - path to the root directory of queried files
	 * @throws NamingException
	 * @throws JMSException
	 */
	public FileServer(String pathToRoot) throws NamingException, JMSException {
		this.pathToRoot = pathToRoot;
		Context context = new InitialContext();
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Destination destination = (Destination) context.lookup(FILES);
		connection = connectionFactory.createConnection();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		messageConsumer = session.createConsumer(destination);
		messageConsumer.setMessageListener(this);
		connection.start();
		
		logger.info("Server started with " + connection.getClientID());
	}
	
	/**
	 * Handles incoming JMS text messages.
	 */
	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				logger.info("File query received: \"" + textMessage.getText() + "\"");
				Destination replyQueue = (Destination) message.getJMSReplyTo();
				reply(textMessage.getText(), replyQueue);
			}
		} catch (JMSException e) {
			System.err.println(e);
		}
	}
	
	/**
	 * Replies to JMS client file query.
	 * Sends the queried file if it is valid.
	 * 
	 * @param filename - File to be sent
	 * @param replyQueue
	 * @throws JMSException
	 */
	public void reply(String filename, Destination replyQueue) throws JMSException {
		messageProducer = session.createProducer(replyQueue);
		
		BytesMessage bytesMessage = session.createBytesMessage();
		
		boolean status = isValidFile(filename);
		bytesMessage.setBooleanProperty("status", status);
		
		if (status) {
			logger.info("Sending file: " + filename);
			
			try (InputStream inputStream = new FileInputStream(pathToRoot + "/" + filename)) {
				int c;
				while ((c = inputStream.read()) != -1) {
					bytesMessage.writeByte((byte) c);
				}
				messageProducer.send(bytesMessage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.warning("File not found or invalid: " + filename);
		}
		
		messageProducer.send(bytesMessage);
	}
	
	@Override
	public void close() throws JMSException {
		if (messageProducer != null) messageProducer.close();
		if (session != null) session.close();
		if (connection != null) connection.close();
	}
	
	/**
	 * Checks whether the specified file is valid.
	 * A valid file must be existing, readable, and be a normal file.
	 * 
	 * @param filename - File to be checked
	 * @return true if the file is valid
	 */
	private boolean isValidFile(String filename) {
		File file = new File(pathToRoot + "/" + filename);
		return (file.isFile() && file.canRead());
	}
	
	/**
	 * Launches the server.
	 * 
	 * @param args - must contain root directory as first argument
	 */
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Usage: java -jar FileServer.jar /path/to/server/root");
			System.exit(-1);
		} else {
			logger.setLevel(Level.ALL);
			
			try (FileServer fileServer = new FileServer(args[0])) {
				for(;;){} // just keep the server running
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
