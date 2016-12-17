package var.poll;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/election", encoders = DataEncoder.class)
public class ElectionService {

	private Session session;

	/**
	 * Updates WebSocket clients with updated BallotBox data.
	 * 
	 * @param zwischenstand
	 * @throws IOException
	 * @throws EncodeException
	 */
	public void notify(BallotBox zwischenstand) throws IOException, EncodeException {
		if (session.isOpen()) {
			session.getBasicRemote().sendObject(zwischenstand);
		}
	}
	
	/**
	 * WebSocket session opened event handler.
	 * 
	 * @param session - Session that has been opened
	 */
	@OnOpen
	public void open(Session session) {
		this.session = session;
		
		System.out.println("Session opened with ID: " + session.getId());

		BallotBox ballotBox = BallotBox.getInstance();
		ballotBox.addObserver(this);
		session.getUserProperties().put("ballotbox", ballotBox);

		try {
			notify(ballotBox);
		} catch (IOException | EncodeException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * WebSocket session closed event handler.
	 * 
	 * @param session - Session that is about to be closed
	 */
	@OnClose
	public void close(Session session) {
		System.out.println("Session closed with ID: " + session.getId());
		
		BallotBox ballotBox = (BallotBox) session.getUserProperties().get("ballotbox");
		ballotBox.removeObserver(this);
	}

}
