package webobjectsexamples.businesslogic.movies.common;

import org.apache.log4j.Logger;

public class Voting extends _Voting {
  private static Logger log = Logger.getLogger(Voting.class);
  
	private static final long	serialVersionUID	= 7584225995972371006L;

	public static final String	MovieKey			= "movie";

	public static final String	NumberOfVotesKey	= "numberOfVotes";

	public static final String	RunningAverageKey	= "runningAverage";

	public Voting() {
		super();
	}

	public Number getNumberOfVotes() {
		Number numberOfVotes = (Number) (storedValueForKey(NumberOfVotesKey));
		return (numberOfVotes != null) ? numberOfVotes : new Integer(0);
	}

	public void setNumberOfVotes(Number value) {
		takeStoredValueForKey(value, NumberOfVotesKey);
	}

	public Number getRunningAverage() {
		Number runningAverage = (Number) (storedValueForKey(RunningAverageKey));
		return (runningAverage != null) ? runningAverage : new Double(0.0);
	}

	public void setRunningAverage(Number value) {
		takeStoredValueForKey(value, RunningAverageKey);
	}

	public void addVote(int vote) {
		if ((vote >= 0) && (vote <= 10)) {
			int numberOfVotes = getNumberOfVotes().intValue();
			double total = getRunningAverage().doubleValue() * numberOfVotes + vote;
			++numberOfVotes;

			setNumberOfVotes(new Integer(numberOfVotes));
			setRunningAverage(new Double(total / numberOfVotes));
		}
	}

}
