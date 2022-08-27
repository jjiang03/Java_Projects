//Justin Jiang
//May 25, 2022
//This code uses Caesar Cipher to encrypt and decrypt single digit and ten digit ciphers
import java.util.Scanner;
import java.util.Arrays;
public class Encryption 
{
	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Encrypt or Decrypt? (Type your answer): ");
		String encOrDec = input.nextLine();
	
		
		while(!encOrDec.equals("No"))
		{
			if(encOrDec.equals("Encrypt"))
			{
				System.out.println("Single Digit Encryption or Ten Digit Encryption? (Type Single or Ten): ");
				String typeOfEncryption = input.nextLine();
				if(typeOfEncryption.equals( "Single"))
				{
					System.out.println("Type the word you want to encrypt: ");
					String singleWord = input.nextLine();
					System.out.println("Type the number of steps you want to move the words: ");
					String singleStep = input.nextLine();
					System.out.println(Cipher(singleWord, Integer.parseInt(singleStep)));
				
				}
				else if(typeOfEncryption.equals("Ten"))
				{
						System.out.println("Type the word you want to encrypt: ");
						String tenWord = input.nextLine();
						System.out.println("Type the number of steps you want to move for each letter (include a space after each key): ");
						String tenStep = input.nextLine();
						System.out.println(tenCipher(tenWord, tenStep));	
				}
				
				System.out.println("Try again? (Type Encrypt or Decrypt to try again. Type No to quit. )");
				encOrDec = input.nextLine();
			
				
				
				
				
			}
			else if(encOrDec.equals("Decrypt"))
			{
				System.out.println("Single Digit Decryption or Ten Digit Decryption? (Type Single or Ten): ");
				String typeOfEncryption = input.nextLine();
				if(typeOfEncryption.equals( "Single"))
				{
					System.out.println("Type the word you want to Decrypt: ");
					String singleWord = input.nextLine();
					System.out.println("Type the number of steps the word was moved: ");
					String singleStep = input.nextLine();
					System.out.println(decryptCipher(singleWord, Integer.parseInt(singleStep)));
				}
				else if(typeOfEncryption.equals("Ten"))
				{
						System.out.println("Type the word you want to decrypt: ");
						String tenWord = input.nextLine();
						System.out.println("Type the number of steps  the word was moved for each letter (include a space after each key): ");
						String tenStep = input.nextLine();
						System.out.println(decryptTenCipher(tenWord, tenStep));
				}
				
				System.out.println("Try again? (Type Encrypt or Decrypt to try again. Type No to quit. )");
				encOrDec = input.nextLine();
			
				
			}
			
		
		}
		input.close();
		
		
	}
	
	public static String Cipher(String word, int key)
	{
		String result = "";
		for(int i = 0; i < word.length(); i++)
		{
			if(Character.isLetter(word.charAt(i)) == true)
			{
				int asci = (int)word.charAt(i);
				if(asci + key > 122)
				{
					asci = (asci + key) - 122 + 97;
				}
				else
				{
					asci = (asci + key);
				}
				result += (char)asci + "";
			}
			else
			{
				result += word.charAt(i);
			}
			
		}
		return result;
				
	}
	
	public static String decryptCipher(String word, int key)
	{
		String result = "";
		for(int i = 0; i < word.length(); i++)
		{
			if(Character.isLetter(word.charAt(i)) == true)
			{
				int asci = (int)word.charAt(i);
				if((asci - key) < 97)
				{
					asci = (asci - key) - 97 + 122;
				}
				else
				{
					asci = (asci - key);
				}
				result += (char)asci + "";
			}
			else
			{
				result += word.charAt(i);
			}
			
		}
		return result;
				
	}
	
	public static String tenCipher(String word, String key)
	{
		String result = "";
		char[] wordHold = new char[word.length()];
		String[] stringKeyHold = new String[key.length()];
		stringKeyHold = key.split(" ");
		int resetKey = 0;
		
		for(int i = 0; i < word.length(); i++)
		{
			if(resetKey > 9)
			{
				resetKey = 0;
			}
			if(Character.isLetter(word.charAt(i)) == true)
			{
				wordHold[i] = word.charAt(i);
				result += Cipher(Character.toString(wordHold[i]), Integer.parseInt(stringKeyHold[resetKey]));
				resetKey++;
			}
			else
			{
				result += word.charAt(i);
			}
			
		}

		return result;
		
	}
	
	public static String decryptTenCipher(String word, String key)
	{
		String result = "";
		char[] wordHold = new char[word.length()];
		String[] stringKeyHold = new String[key.length()];
		stringKeyHold = key.split(" ");
		int resetKey = 0;
		
		for(int i = 0; i < word.length(); i++)
		{
			if(resetKey > 9)
			{
				resetKey = 0;
			}
			if(Character.isLetter(word.charAt(i)) == true)
			{
				wordHold[i] = word.charAt(i);
				result += decryptCipher(Character.toString(wordHold[i]), Integer.parseInt(stringKeyHold[resetKey]));
				resetKey++;
			}
			else
			{
				result += word.charAt(i);
			}
			
			
		}

		return result;
	}
}
