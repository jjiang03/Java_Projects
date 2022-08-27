//denise dreyer
//December 6, 2021
//Class to represent a user and all it's login data


public class User {
	private String email;
	private int[] sessionTimes;
	private String password;
	
	public User(String em, int[] sesh, String pass)
	{
		email = em;
		sessionTimes = sesh;
		password = pass;
		
	}
	
	public double average(int[] arr)
	{
		double totalTime = 0;
		double averageTime;
		for(int i = 0; i < arr.length; i++)
		{
			totalTime += arr[i];
		}
		averageTime = totalTime/arr.length;
		return averageTime;
	}
	
	public String emailToUsername(String email)
	{
		/*
		 * 22dirksenj79@stu.smuhsd.org
		 */
		String [] name = email.split("@stu.smuhsd.org");
		String wholeName = name[0];
		wholeName = wholeName.substring(2,wholeName.length() - 2);
		char firstLetter = wholeName.charAt(wholeName.length() - 1);
		
		String finalName = firstLetter + wholeName.substring(0, wholeName.length()-1);
		return finalName;
	}
	
	
	public String getEmail()
	{
		return email;
	}
	
	public String getUsername()
	{
		return emailToUsername(email);
	}
	public String getPassword()
	{
		return password;
	}
	
	public int[] getSessionTimes()
	{
		return sessionTimes;
	}
	
	public String toString()
	{
		String result = "";
		result += emailToUsername(email) + "\nPassword: " + password + "\nLogged in: " + sessionTimes.length + " times"
				+ "\nTotal time spent: " + getTotalTimeSpent() + "\nAverage session length: " + average(sessionTimes) + "\n\n";
		
		return result;
	}
	
	public void changePassword(String newPass)
	{
	}
	
	public int getTotalTimeSpent()
	{
		int total = 0;
		for(int i = 0; i < sessionTimes.length; i++)
		{
			total += sessionTimes[i];
		}
		return total;
	}
	
	public void addNewSession(int newTime)
	{
		int [] newArray = new int [sessionTimes.length +1];
		for(int i = 0; i < sessionTimes.length; i++)
		{
			newArray [i] = sessionTimes[i];
		}
		
		newArray[sessionTimes.length] = newTime;
		newArray = sessionTimes;
	}
	
	 private void setDefaultPassword()
	 {
		 String changeName = getUsername();
		 String newPass = "";
		 if(changeName.length()<5)
		 {
			 newPass += changeName.substring(1) + "_" + changeName.charAt(0) + "_2021";
		 }
		 else
		 {
			 newPass += changeName.substring(1, 5) + "_" + changeName.charAt(0) + "_2021";;
		 }
		 password = newPass;


	 }
	 public User(String email, int[] sessionTimes)
	 {
		 this.email = email;
		 this.sessionTimes = sessionTimes;
		 setDefaultPassword();
	 }


}

