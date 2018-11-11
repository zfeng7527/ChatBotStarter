import java.util.Random;
import java.util.Scanner;


public class WesternUnion {
    //emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
    int emotion = 10;


    /**
     * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
     * the statement typed by the user
     */
    public void chatLoop()
    {
        Scanner in = new Scanner (System.in);
        System.out.println (getGreeting());
        String statement = in.nextLine();
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
        return "Hello! This is Western Union . How may I help you!";
    }


    public String getResponse(String statement)
    {
        String responsemem="";
        String response = "";
        if(((findKeyword(statement,"real")>=0)||(findKeyword(statement,"fake")>=0))&&(responsemem.equals("I mean that you're falling victim to a scam")))  //This is a memory if else statement if the previous response was
        {
          response ="Sir I would like to warn you that you are getting scammed by a nigerian prince. These types of scams are very regular please try your best to ignore them";
        }

        else if (statement.length() == 0)
        {
            response = "Hello? Are you there sir, I'm ready to assist you!";
        }

        else if (findKeyword(statement, "no") >= 0)
        {
            response = "I need this information in order to authorize the transaction!";
            emotion--;// emotion is kept in track when the user gives negative response the bot subtracts 1 from emotion
        }

        else if (findKeyword(statement, "yes") >= 0)
        {
            response = "Thank you sir for that info!";
            emotion++;//// emotion is kept in track when the user gives negative response the bot adds 1 from emotion
        }
        else if (findKeyword(statement,"Prince")>=0){
            response = "Sir I think there's a misunderstanding";
            responsemem="Sir I think there's a misunderstanding";
        }

        else if (findKeyword(statement, "Fraud")>=0){
            response = "Yes sir what I am is that it is a fraud";
        }
        else if (findKeyword(statement, "mean", 0) >= 0)
        {
            response = "I mean that you're falling victim to a scam";
            responsemem="I mean that you're falling victim to a scam";
        }

        else if (findKeyword(statement, "I need to", 0) >= 0)
        {
            response = transformIneedToStatement(statement); 
        }
        else if (findKeyword(statement, "I was told",0) >= 0)
        {
            response = transformIwasToldStatement(statement);
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
    private String transformIneedToStatement(String statement)
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
        int psn = findKeyword (statement, "I need to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "May I ask why you need to " + restOfStatement + "?";
    }


    /**
     * Take a statement with "I want <something>." and transform it into
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    private String transformIwasToldStatement(String statement)
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
        int psn = findKeyword (statement, "I was told", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Who told you " + restOfStatement + "?";
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
        }
        return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
    }

    private String [] randomNeutralResponses = {"Interesting, tell me more",
            "Don't worry I have your back",
            "I do not understand.",
            "Please wait a moment",
            "So, would you like to confirm this?",
            "Could you say that again?"
    };
    private String [] randomAngryResponses = {"Good riddance sir!", "Do you want to make the transaction or not!", "Time is money hurry up!"};
    private String [] randomHappyResponses = {"I'm very happy to assist you today!",  "Have a nice day sir",""};

}
