package com.marcelherd.var;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FileClient {
	private static final String DESTINATION = "files";
	private Connection mConnection;
	private Session mSession;
	private MessageConsumer mMessageConsumer;
	private MessageProducer mMessageProducer;

	public FileClient(String filename) throws NamingException, JMSException {
		Context ctx = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
		Destination requestQueue = (Destination) ctx.lookup(DESTINATION);
		mConnection = factory.createConnection();
		mConnection.start();
		mSession = mConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		mMessageProducer = mSession.createProducer(requestQueue);
		TemporaryQueue replyQueue = null;
		replyQueue = mSession.createTemporaryQueue();
		mMessageConsumer = mSession.createConsumer(replyQueue);
		TextMessage request = mSession.createTextMessage();
		request.setText(filename);
		request.setJMSReplyTo(replyQueue);
		mMessageProducer.send(request);
	}

	public void receiveMessage(String filename) throws JMSException, IOException {
		String outfilename = new java.io.File( "." ).getCanonicalPath() + "/" + filename + ".received";
		System.out.println("warte auf Antwort...");
		Message message = mMessageConsumer.receive();
		
		System.out.println("Nachricht empfangen.");
		if (message != null && message instanceof BytesMessage) {
			System.out.println("Nachricht ist BytesMessage.");
			if (message.propertyExists("status")) {
				boolean status = message.getBooleanProperty("status");
				System.out.println("Status ist " + status + ".");
				if (status) {
					OutputStream out = new FileOutputStream(outfilename);
					long length = ((BytesMessage) message).getBodyLength();
					byte b;
					long i;
					for (i = 0; i < length; i++) {
						b = ((BytesMessage) message).readByte();
						out.write(b);
					}
					out.flush();
					out.close();
					System.out.println("Datei " + filename + " mit " + ((BytesMessage) message).getBodyLength()
							+ " Bytes empfangen und " + i + " Bytes in " + outfilename + ".received geschrieben.");
				} else {
					System.out.println("BooleanProperty status ist false.");
				}
			} else {
				System.err.println("Fehler: Kein Property status.");
			}
		} else {
			System.err.println("Fehler: Keine BytesMessage empfangen.");
		}
	}

	public void close() {
		try {
			if (mMessageConsumer != null)
				mMessageConsumer.close();
			if (mMessageProducer != null)
				mMessageProducer.close();
			if (mSession != null)
				mSession.close();
			if (mConnection != null)
				mConnection.close();
		} catch (JMSException e) {
			System.err.println(e);
		}
	}

	public static void main(String[] args) {
		FileClient client = null;
		try {
			client = new FileClient(args[0]);
			client.receiveMessage(args[0]);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (client != null)
				client.close();
		}
	}
}