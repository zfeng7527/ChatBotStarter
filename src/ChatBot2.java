import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */

 // Zhi Feng (Nigerian Prince).
public class ChatBot2
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 10;


	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());
        //System.out.println("This letter is not intended to to cause any embarrassment but just to contact your esteem self-following the knowledge of your high repute and trustworthiness.");
        //System.out.println("I am Mohammed Abacha,the son of the late Nigerian Head of State who died on the 8th of June 1998.If you are conversant with world news,you would understand better,while I got your contacts through my personal research.Please,I need your assistance to make this happen and please; do not undermine it because it will also be a source of upliftment to you also.You have absolutely nothing to loose in assisting us instead, you have so much to gain.");
        //System.out.println("The then head of state General Sani Abacha,transferred the money through a Lebanese businessman,Chagoury and a Jewish business man,Mark Rissar to bank accounts overseas,Instead,he used PERSONAL IDENTIFICATION NUMBERS (PIN) and declared the contents as Bearer Bonds and Treasury Bills. Also the firm issued him with a certificate of deposit of the consignments notes, which I have these information in my custody now.");
        //System.out.println("You must have heard over the media reports and the Internet on the recovery of various huge sums of money deposited by my late father in different Banks and security firms abroad. Some of these banks and security firms willingly gave-/divulge their banking secrets and disclosed to the present civilian administration of Chief Olusegun Obasanjo,about my family's cash lodgement and monetary transactions with them.");
        //System.out.println("Please my dear,I repose great confidence in you and I hope you will not betray my confidence in you.I have secretly deposited the sum of $30,000,000.00 with a security firm abroad whose name is withheld for now until we open communications.The money is contained in a metal box consignment with Security Deposit Number 009GM.");
        //System.out.println("I shall be grateful if you could receive this fund into your Bank account for safekeeping. This arrangement is known to you and my junior brother (Abbas) only. So I will deal directly with you.I am proposing a 20% share of the fund to you for your kind assistance.I shall provide for you all the documents of the fund deposit with the security firm, and raise a power of attorney to enable you claim and receive this fund into your bank account.I have done a thorough homework and fine-tuned the best way to create you as the beneficiary to the funds and effect the transfer accordingly.Is rest assured that the modalities I have resolved to finalize the entire project guarantees our safety and the successful transfer of the funds.So, you will be absolutely right when you say that this project is risk free and viable.If you are capable and willing to assist, contact me at once via email with following details:");
        //System.out.println("1. YOUR NAME\n" + "2. POSTAL ADDRESS\n" +   "3. PHONE AND FAX NUMBERS");
        //System.out.println("Also this transaction demands absolute confidentiality.On no condition must you disclose it to anybody irrespective of your relation with the person.Remember,Loose lips sinks ship.I am looking forward to your urgent and positive response via my email address above.");
        //System.out.println("Best Regards,");
        //System.out.println("A prince in need");
        System.out.println("Dear Sir/Madam\n" +
                "\n" +
                "This letter is not intended to to cause any embarrassment but just to contact your esteem self-following the knowledge of your high repute and trustworthiness.\n" +
                "\n" +
                "I am Mohammed Abacha,the son of the late Nigerian Head of State who died on the 8th of June 1998.If you are conversant with world news,you would understand better,while I got your contacts through my personal research.Please,I need your assistance to make this happen and please; do not undermine it because it will also be a source of upliftment to you also.You have absolutely nothing to loose in assisting us instead, you have so much to gain.\n" +
                "\n" +
                "The then head of state General Sani Abacha,transferred the money through a Lebanese businessman,Chagoury and a Jewish business man,Mark Rissar to bank accounts overseas,Instead,he used PERSONAL IDENTIFICATION NUMBERS (PIN) and declared the contents as Bearer Bonds and Treasury Bills. Also the firm issued him with a certificate of deposit of the consignments notes, which I have these information in my custody now.\n" +
                "\n" +
                "You must have heard over the media reports and the Internet on the recovery of various huge sums of money deposited by my late father in different Banks and security firms abroad. Some of these banks and security firms willingly gave-/divulge their banking secrets and disclosed to the present civilian administration of Chief Olusegun Obasanjo,about my family's cash lodgement and monetary transactions with them.\n" +
                "\n" +
                "Please my dear,I repose great confidence in you and I hope you will not betray my confidence in you.I have secretly deposited the sum of $30,000,000.00 with a security firm abroad whose name is withheld for now until we open communications.The money is contained in a metal box consignment with Security Deposit Number 009GM.\n" +
                "\n" +
                "I shall be grateful if you could receive this fund into your Bank account for safekeeping. This arrangement is known to you and my junior brother (Abbas) only. So I will deal directly with you.I am proposing a 20% share of the fund to you for your kind assistance.I shall provide for you all the documents of the fund deposit with the security firm, and raise a power of attorney to enable you claim and receive this fund into your bank account.I have done a thorough homework and fine-tuned the best way to create you as the beneficiary to the funds and effect the transfer accordingly.Is rest assured that the modalities I have resolved to finalize the entire project guarantees our safety and the successful transfer of the funds.So, you will be absolutely right when you say that this project is risk free and viable.If you are capable and willing to assist, contact me at once via email with following details:\n" +
                "\n" +
                "1. YOUR NAME\n" +
                "2. POSTAL ADDRESS\n" +
                "3. PHONE AND FAX NUMBERS\n" +
                "\n" +
                "Also this transaction demands absolute confidentiality.On no condition must you disclose it to anybody irrespective of your relation with the person.Remember,Loose lips sinks ship.I am looking forward to your urgent and positive response via my email address above.\n" +
                "\n" +
                "Best Regards,\n" +
                "\n" +
                "Mohammed Abacha.");
		while (!statement.equals("Bye"))
		{


			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(getResponse(statement));


		}

	}
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "Dear Good Sir of America,";
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
			response = "Hello? You there sir?";
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Please, I am in deep need of help!";
                	emotion--;
		}
		
		else if (findKeyword(statement, "money") >= 0)
		{
			response = "Yes, I need money.";
			emotion++;
		}
		else if (findKeyword(statement,"Prince")){
			response = "I am the REAL prince of Nigeria."
		}
		else if (findKeyword(statement, ""))

		// Response transforming I want to statement
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
		else if (findKeyword(statement, "believe",0)>=0){
            response = "You must beleive me, I am the REAL nigerain prince.";
		}
		else
		{
			response = getRandomResponse();
		}
		
		return response;
	}
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + "?";
	}

	
	/**
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
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
		if (emotion == 10)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 10)
		{	
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
			if (emotion == 0){
			    System.out.println("Good bye.");
            }
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"Interesting, tell me more",
			"Interesting but, do you have any money on you?",
			"Quickly I need your help.",
			"I do not understand.",
			"Please stop.",
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};
	private String [] randomAngryResponses = {"I hope you have a bad day.", "My family will starve to death.", "Do you want your money or not?!"};
	private String [] randomHappyResponses = {"My Family will be very happy.", "Wakanda Forever", "You make me feel like a brand new pair of shoes."};
	
}
