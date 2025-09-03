import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class VotingSystemApp{
public static void main(String[]args){
Scanner userInput = new Scanner(System.in);

System.out.println("What elective position is the election for (presidential, governorship or national assembly) ");
String input = userInput.nextLine();
System.out.println("IT IS ELECTION DAY, LET'S TROOP OUT IN OUR MAJORITY TO KEEP DEMOCRACY INTACT");
System.out.println("Input numbers of candidates for the " + input + " election");
String numberOfCandidates = userInput.nextLine().toLowerCase();
int number = Integer.valueOf(numberOfCandidates);

String [] candidates = new String[number];

for(int counter = 0; counter < number;counter++){
System.out.println("Input candidate name to be registered for the " + input + " election");
candidates[counter] = userInput.nextLine().toLowerCase();
}

System.out.println("Input number of voters to be registered for the " + input + " election");
String registeredCandidates = userInput.nextLine().toLowerCase();
int numberCand = Integer.valueOf(registeredCandidates);

String [] voters = new String[numberCand];

for(int count = 0; count < numberCand;count++){
System.out.println("Input voter's name to register");
voters[count] = userInput.nextLine().toLowerCase();
}

System.out.println("These are candidates name to be voted for" + Arrays.toString(candidates));

List<String> spareList1 = Arrays.asList(voters);
List<String> spareList2 = Arrays.asList(candidates);

String[] myList = new String[numberCand];
List<String> spareList3 = Arrays.asList(myList);

int count = 0;
int [] countList = new int[number];
while(count < numberCand){
	System.out.println("Enter your registered name");
	String registeredVoters = userInput.nextLine().toLowerCase();
	if(spareList3.contains(registeredVoters)){
		System.out.println("You already voted");
	}
	else if(spareList1.contains(registeredVoters)){
		while(true){
			myList[count] = registeredVoters;
			System.out.println("Choose your preferred candidate" + Arrays.toString(candidates) );
			String votersCandidateChoice = userInput.nextLine().toLowerCase();
				if(spareList2.contains(votersCandidateChoice)){
					System.out.println("Voted Successfully");count++;
					for(int counter = 0;counter < number;counter++){
						int value = 0;
						if(votersCandidateChoice.equals(candidates[counter])){
							value++;
							countList[counter] += value;
						}
						value = 0;
					}
					break;
				}
				else{
					System.out.println("Wrong candidate");
				}
		}
	}else{
		System.out.println("Your name is not a registered voter");
	}
}


for(int counter = 0; counter < number;counter++){
System.out.println("The result of the electoral process resulted in " + candidates[counter] + " having " + countList[counter] + " votes");
}
System.out.println("Your next election happens in four years, make do with the seat!!!");
}
}