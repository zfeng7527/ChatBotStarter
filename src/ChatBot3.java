
import java.util.Random;
import java.util.Scanner;

public class ChatBot3
{
   //emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
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
   /**
    * Get a default greeting
    * @return a greeting
    */
   public String getGreeting() {
     return "Hello, this is the FBI. How may we be of service to you?";
  }

   /**
    * Gives a response to a user statement
    *
    * @param statement
    *            the user statement
    * @return a response based on the rules given
    */
  public String getResponse(String statement) {
     String response = "";
     if (statement.length() == 0) {
        response = "Sir, say something. We don't have much time to waste.";
     }
     else if (findKeyword(statement, "no") >= 0) {
        response = "Suit yourself, it's just your personal information being risked here.";
     }
     else if (findKeyword(statement, "nigerian prince") >=0) {
        response = "A Nigerian prince? What about the Nigerian prince?";
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

   /**
    * Take a statement with "I want to <something>." and transform it into
    * "Why do you want to <something>?"
    * @param statement the user statement, assumed to contain "I want to"
    * @return the transformed statement
    */
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

   /**
    * Search for one word in phrase.  The search is not case sensitive.
    * This method will check that the given goal is not a substring of a longer string
    * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.
    * @param statement the string to search
    * @param goal the string to search for
    * @return the index of the first occurrence of goal in statement or -1 if it's not found
    */
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

  /**
   * Pick a default response to use if nothing else fits.
   * @return a non-committal string
   */
  private String [] randomNeutralResponses = {"Interesting, tell me more",
        "Hmmm.",
        "Do you really think so?",
        "You don't say.",
        "So, what seems to be the issue?",
        "Could you say that again?",
        "Your credit card information seems to be being used right now."
  };
  private String [] randomAngryResponses = {"Sir, stop wasting our time.", "Hurry up, we don't have much time.", "If this is a prank, we are going to arrest you."};
  private String [] randomHappyResponses = {"So, how was your day.", "Are you sure your credit information is fine, sir?", "We are trying our best to help you out sir."};

}



