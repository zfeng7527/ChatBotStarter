import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotRunner
{

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args)
	{
		ChatBot1 chatbot1 = new ChatBot1();//Felix wilking's chat bot
		ChatBot2 chatbot2 = new ChatBot2();//Zhi feng's chatbot
		ChatBot3 chatbot3 = new ChatBot3();// Ryan wu's chat bot
		WesternUnion WesternUnion = new WesternUnion();//Mohammed Uddins Chat bot

		chatbot1.chatLoop();
		chatbot2.chatLoop();
		chatbot3.chatLoop();
		WesternUnion.chatLoop();
	}
}

