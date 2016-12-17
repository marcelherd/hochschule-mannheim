package var.poll;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class DataEncoder implements Encoder.Text<BallotBox> {
	
	/**
	 * Encodes ballotBox as JSON String.
	 * 
	 * @param ballotBox - ballotBox that is being encoded
	 * @return the ballotBox, encoded as JSON String
	 */
	@Override
	public String encode(BallotBox ballotBox) throws EncodeException {
		return "{\"votes\": " + ballotBox.countVotes() + "}";
	}

	@Override
	public void destroy() { }

	@Override
	public void init(EndpointConfig cfg) { }

}
