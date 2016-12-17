package var.poll;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.websocket.EncodeException;

public class BallotBox {
	private Map<String, Integer> mVotes = Collections.synchronizedMap(new HashMap<String, Integer>(30, 1.0f));
	private Set<ElectionService> observers = Collections.synchronizedSet(new HashSet<ElectionService>());
	private static BallotBox instance = new BallotBox();

	private BallotBox() {
	}

	public static BallotBox getInstance() {
		return instance;
	}

	public void addObserver(ElectionService observer) {
		observers.add(observer);
	}

	public void removeObserver(ElectionService observer) {
		observers.remove(observer);
	}

	public synchronized void vote(String choice) throws IOException {
		Integer votes = mVotes.get(choice);
		if (votes == null)
			votes = 0;
		mVotes.put(choice, votes + 1);
		for (ElectionService observer : observers) {
			try {
				observer.notify(this);
			} catch (EncodeException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized int countVotes() {
		int sum = 0;
		for (Map.Entry<String, Integer> choice : mVotes.entrySet()) {
			sum += choice.getValue();
		}
		return sum;
	}

	public synchronized int getNumberOfVotes(String choice) {
		Integer votes = mVotes.get(choice);
		if (votes == null)
			votes = 0;
		return votes;
	}

	public Set<String> getChoices() {
		return mVotes.keySet();
	}
}