import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBot1
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;

	public void chatLoop()
	{
		System.out.println();
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());
		String statement = in.nextLine();

		while (!(statement.contains(" no ") || statement.contains(" money ") || statement.contains("Bye")))
		{

			System.out.println(getResponse(statement));
			statement = in.nextLine();


		}
		System.out.println(" Sir, you don't understand-- \n\n");

	}
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "Hello, I'm a very important royal administrator of Nigeria.\n" +
				"His royal highness: Prince Nigeria is interested in a highly profitable business investment, " +
				"that requires a small initial fund from investors.  " +
				"If you front a payment of at least $500, he can garentee returns of up to 5 million dollars.\n\n" +
				"Do you accept?";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}
		String[] questions = {"owe", "You have to help me, I need an immediate cash widthdrawal.",
				"believe", "Please sir, you have to believe me, I am the real prince of Nigeria.",
				"I don't owe you anything", "You owe it to the good men and women of Nigeria",
				"scam", "How dare you accuse me of such a heinous crime!",
				"scammer", "I am NOT a scammer!",
				"scamming", "How dare you insult the royal prince of Nigeria"};
		for(int i = 0; i < questions.length-1; i += 2){
			String trigger = questions[i];
			String question = questions[i+1];
			if(statement.contains(trigger)){
			    return transformStatement(statement, trigger, question);
            }

		}
		return getRandomResponse();
	}
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformStatement(String statement, String triggerphrase, String questionphrase) {
        if (findKeyword(statement, triggerphrase) >= 0) {

            statement = statement.trim();
            String lastChar = statement.substring(statement.length() - 1);

            if (lastChar.equals(".")) statement = statement.substring(0, statement.length() - 1);

            int psn = findKeyword(statement, triggerphrase, 0);

            String restOfStatement = statement.substring(psn + triggerphrase.length()).trim();
            if (statement.substring(statement.length() - 1).contains(".")) {
                return (questionphrase + restOfStatement);
            } else {
                return (questionphrase + "?");
            }
        }
        return "Trigger not found";
    }

	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse ()
	{
		Random r = new Random ();
		return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"I am the real prince of Nigeria",
			"If you back out now, you'll be missing out on 5 million dollars!",
			"As a show of good faith, I can reduce your initial investment to 300 dollars.",
			"I can pay you in untraceable gold bricks which are very gold and very untraceable.",
			"Without your help, thousands of children in...\nUm...\nNigeria, will starve!",
			"This is not a scam.",
			"I'm going to need that deposit by April 17th.",
			"You're invited to the royal banquet in Nigeria, but I'll need an additional payment of $700 to cover travel expenses."
	};
}
