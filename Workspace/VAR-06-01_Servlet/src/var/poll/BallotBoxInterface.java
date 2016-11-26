package var.poll;

import java.util.Set;

public interface BallotBoxInterface {
	
	public void vote(String choice);

	public int countVotes();

	public int getNumberOfVotes(String choice);

	public Set<String> getChoices();

}
