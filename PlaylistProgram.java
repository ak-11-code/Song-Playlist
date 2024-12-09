import java.util.Scanner;
public class PlaylistProgram {
	static Scanner input = new Scanner (System.in);
	//Purpose: To have a Spotify playlist that the user can play and choose any song based off the queue number
	
	//Initialize global variable
	static int userInput = 0;
	
	public static void main(String[] args)throws InterruptedException {
		//Declare, Allocate Memory and Load arrays
		int[]queueNum = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		String[] songName = {"As it was", "Shinunoga E-Wa", "Like I Need You", "Baby Shark", "God's Plan", "Streets", "Die for You", "hair tie", "Bad Guy", "I Like You"};
		
		String[] artistName = {"Harry Styles", "Fuji Kaze", "Keshi   ", "Pink Fong", "Drake   ", "\tDoja Cat", "The Weekend", "Ozi     ", "\tBillie Eilish", "Post Malone"};
		
		double[] songTime = {2.47, 3.05, 3.02, 2.17, 3.18, 3.46, 4.20, 2.54, 4.58, 3.12};
		
		//Introduce Program to user and display the full playlist by calling the methods: welcomeStatement, and printPlayList
		welcomeStatement();
		printPlayList(queueNum, songName, artistName, songTime);
		
		/*Ask user if they want to play the playlist
		 * if yes, call the method getInputAndValidity
		 * if no, Call the method: printThankUser
		 */
		System.out.println("\nDo you want to play the playlist? Yes or no?");
		String repeatPlayList = input.next();
		/*Ask user if they want to play another song
		 * if yes, Repeat Program until user user enters anything but yes
		 * if no, Call the method: printThankUser
		 */
		if (repeatPlayList.equalsIgnoreCase("Yes")){
			System.out.println("\n---------------------------------------------");
			while (repeatPlayList.equalsIgnoreCase("Yes")){
				getInputAndValidity();
				
				System.out.println("\n----------------------------------------------------");
				System.out.println("\nQueue Number:\tSong Name:\tSong Artist:\tSong Time:");
				System.out.println(queueNum[userInput]+"\t\t"+songName[userInput]+"\t"+artistName[userInput]+"\t"+songTime[userInput]);
				
				Thread.sleep(5000);//Inserts pause for 5 seconds
				
				System.out.println("\nDo you want to play another song? Yes or no?");
				repeatPlayList = input.next();
				System.out.println("\n---------------------------------------------");
				
			}//while repeatPlayList = yes
			
			printThankUser();
		}//if yes
		
		else{
			System.out.println("\n---------------------------------- ");
			printThankUser();
		}//else

	}//main
	
							//Methods
	
	
	public static void printPlayList(int []queueNum,String []songName,String []artistName, double []songTime){
		//prints the elements of its one dimensional array parameters
		for (int index = 0; index<artistName.length; index++){
			System.out.println(queueNum[index]+"\t\t"+songName[index] +"\t"+artistName[index]+"\t"+songTime[index]);
		}//for
	}//printPlayList
	
	public static void printThankUser(){
		//Thanks user for using the program
		System.out.println("\nThank you for using Spotify Today!");
	}//printPlayList
	
	public static boolean checkInputValidity(int userInput){
		//Checks validity of the user's input
		if (userInput>=0 && userInput <= 9){
			return true;
		}//if return true
		return false;
	}//checkInputValidity
	
	public static void getInputAndValidity(){
		//Gets the input of the user and checks the validity of the input; if invalid: it will ask the user for another input until they enter a valid input
		do{
			System.out.println("\nPlease enter the queue number of the song you wish to play\n");
			userInput = input.nextInt();
		}while(!checkInputValidity(userInput));
	}//getInputValidity
	
	public static void welcomeStatement(){
		//Introduce Program to user and display the full playlist
				System.out.println("Welcome to your Spotify playlist");
				System.out.println("\nThe playlist is as follows");
				System.out.println("\n--------------------------------------------------");
				System.out.println("Queue Number:\tSong Name:\tSong Artist:\tSong Time:");
	}//welcomeStatement
	
}//PlaylistProgram
