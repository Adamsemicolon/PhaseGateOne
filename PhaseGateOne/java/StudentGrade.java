import java.util.Scanner;
import java.util.Arrays;

public class StudentGrade{
public static void main(String[]args){
Scanner inputReceiver = new Scanner(System.in);

System.out.println("Input number of students ");
int userInput = inputReceiver.nextInt();

System.out.println("Input number of subjects ");
int subjectInput = inputReceiver.nextInt();

int [][] grades = new int[userInput][subjectInput];
int [][] array = new int[subjectInput][subjectInput];
for(int count = 0; count < grades.length;count++){
	for(int counter = 0; counter < grades[count].length;counter++){
		System.out.println("Entering score for student " + (count +1));
		System.out.println("Enter score for subject " + (counter+1));
		int input = inputReceiver.nextInt();
		while(input < 0 || input > 100){
			System.out.println("Score must be in range of 0 to 100");
			input = inputReceiver.nextInt();
		}
	grades[count][counter] = input;
	}
}		
String addSubject = "";
for(int count = 0; count < subjectInput;count++){
	addSubject += "SUB" + (count+1) + "\t"; 
}
for(int count = 0; count < grades.length;count++){
	for(int counter = 0; counter < grades[count].length;counter++){
	array[count][counter] = grades[count][counter];
	}
}		

int sum = 0;
int [] sumStr = new int [subjectInput];
for(int counter = 0;counter < subjectInput;counter++){
	for(int count = 0; count < subjectInput;count++){
		sum += grades[counter][count];
	}	
	sumStr[counter] = sum;
	sum = 0;
}
String subjectSum = java.util.Arrays.toString(sumStr);
String arraySum = java.util.Arrays.deepToString(array);
System.out.println("STUDENT\t" + "\t" + addSubject + "TOT\tAVE\tPOS");
System.out.println("Student 1\t" + subjectSum + arraySum + "\t" );










}
}