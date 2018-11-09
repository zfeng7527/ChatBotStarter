import java.util.Random;
import java.util.Scanner;

public class ChatBot3
{
	int emotion = 0;
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());
		while (!statement.equals("Bye"))
		{
			statement = in.nextLine();
			System.out.println(getResponse(statement));
		}

	}

	public String getGreeting() {
		return "Hello, this is the FBI. How may we be of service to you?";
	}

	public String getResponse(String statement) {
		String response = "";
		if (statement.length() == 0) {
			response = "Sir, say something. We don't have much time to waste.";
		}
		else if (findKeyword(statement, "no") >= 0) {
			response = "Suit yourself, it's just your personal information being risked here.";
		}
		else if (findKeyword(statement, "nigerian prince") >=0) {
			response = "A Nigerian prince? What about the nigerian prince?";
		}
		else if (findKeyword(statement, "help me") >=0 ) {
			response = "What do you need help with?";
		}
		else if (findKeyword(statement, "nigerian prince scam") >=0) {
			response = "Nigerian prince scam? That sounds silly? ";
		}
		else if (findKeyword(statement, "credit card information") >=0 ) {
			response = "What about your credit card information?";
		}
		else if (findKeyword(statement, "He is", 0) >= 0) {
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I think",0) >= 0) {
			response = transformIWantStatement(statement);
		}
		else {
			response = getRandomResponse();
		}
		return response;
	}

	private String transformIWantToStatement(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword (statement, "He is", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do he is " + restOfStatement + "?";
	}

	private String transformIWantStatement(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword (statement, "I think", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Do you really think that " + restOfStatement + "?";
	}

	private String transformIYouStatement(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}

	private int findKeyword(String statement, String goal,
							int startPos) {
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();
		int psn = phrase.indexOf(goal, startPos);
		while (psn >= 0) {
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
				return psn;
			}
			psn = phrase.indexOf(goal, psn + 1);
		}
		return -1;
	}

	private int findKeyword(String statement, String goal) {
		return findKeyword (statement, goal, 0);
	}

	private String getRandomResponse () {
		Random r = new Random ();
		if (emotion == 0) {
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0) {
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}

	private String [] randomNeutralResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"It's all boolean to me.",
			"So, would you like to go for a walk?",
			"Could you say that again?"
	};
	private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!"};
	private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};

}

