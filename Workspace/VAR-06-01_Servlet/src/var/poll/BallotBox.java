package var.poll;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BallotBox implements BallotBoxInterface {

	private Map<String, Integer> mVotes = new HashMap<String, Integer>(30, 1.0f);

	public synchronized void vote(String choice) {
		Integer votes = mVotes.get(choice);
		if (votes == null)
			votes = 0;
		mVotes.put(choice, votes + 1);
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

	public synchronized Set<String> getChoices() {
		return mVotes.keySet();
	}

}