import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysis {

	public static void main(String [] args) throws FileNotFoundException
	{
		File file = new File("dataLog.txt");
		Scanner input = new Scanner(file);
		String email;
		String getLine = input.nextLine();
		ArrayList<User> userList = new ArrayList<User>();
		int n = 0;
		
		while(!getLine.equals("end"))
		{
			int timeOfSession = 0;
			email = getLine;
		
			String sessionNumber = input.nextLine();
			int sessionCount = Integer.parseInt(sessionNumber);
			int [] count = new int[sessionCount];
			
			for(int i =1; i <= sessionCount; i++)
			{
				String time = input.nextLine();
				timeOfSession = Integer.parseInt(time) + timeOfSession;
				count[i-1] = Integer.parseInt(time);
			}
			
			
			String getPass = input.nextLine();
			String pass = getPass.substring(4);
			
			User data = new User(email, count, pass);
			userList.add(data);
			
			getLine = input.nextLine();
			
		}
		Scanner nInput = new Scanner(System.in);
		int ses = 0;
		String nEmail = "";
		System.out.println("Add a new user? Type yes to add or no to decline.");
		String userChoice = nInput.nextLine();
		
		if(userChoice.equals("yes"))
		{
			System.out.println("Email: ");
			nEmail = nInput.nextLine();
			System.out.println("Session Time: ");
			ses = nInput.nextInt();
			addUser(userList, nEmail, ses);
		}
		
	
		System.out.println(printUserData(userList));
		System.out.println("The most experienced user is " + mostExperiencedUser(userList));
		nInput.close();	
	}
	
	public static void removeInactiveUser(ArrayList<User> userList)
	{
		for(int i = 0; i < userList.size(); i++)
		{
			if(userList.get(i).getTotalTimeSpent()<10)
			{
				userList.remove(i);
				--i;
			}
		}
	}
	
	public static String printUserData(ArrayList<User> userInfo)
	{
		
		String result = "";
		
		
		for(int n = 0; n < userInfo.size(); n++)
		{
			result += userInfo.get(n);
		}
		return result;
	}
	
	public static String mostExperiencedUser(ArrayList<User> array)
	{
		int totalTime = 0;
		String greatestName = "";
		for(int i = 0; i < array.size(); i++)
		{
			if(array.get(i) != null && array.get(i).getTotalTimeSpent() > totalTime)
			{
				totalTime = array.get(i).getTotalTimeSpent();
				greatestName = array.get(i).getUsername();
			}
		}
		return greatestName;
	}
	
	public static void addUser(ArrayList<User> users, String email, int timeInFirstSession)
	{
		int[] sesh = new int[] {timeInFirstSession};
		
		User nUser = new User(email, sesh);
		
		users.add(nUser);

		
	}
	
}
