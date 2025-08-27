import java.util.Scanner;

public class PersonalityTest{
public static void main(String[]args){

Scanner inputReceiver = new Scanner(System.in);

System.out.println("What is your name");
String name = inputReceiver.nextLine();
String result = isPersonalityTest(name);
System.out.println(name + " ,Your personality type is " + result);
}

public static String isPersonalityTest(String name){
String [] questions = {
"A. expend energy, enjoy groups		B. conserve energy, one-on-one",
"A. Interpret literally		B. look for meaning and possibilities",
"A. logical, thinking, questioning	B. empathetic, feeling, accomodating",
"A. organized, orderly		B. flexible, adaptable",
"A. more outgoing, think out loud	B. more reserved, think to yourself",
"A. practical, realistic, experiential		B. imaginative, innovative, theoretical",
"A. candid, straight forward, frank	B. tatcful, kind, encouraging",
"A. plan, schedule	B. unplanned, spontaneous",
"A. seek many tasks, public activities, interaction with others		B. seek private, solitary activities with quiet to concentrate",
"A. standard, usual, conventional		B. different, novel, unique",
"A. firm, tend to criticize, hold the line	B. gentle, tend to appreciate, conciliate",
"A. regulated, structured	B. easy-going, live and let live",
"A. external, communicative, express yourself		B. internal, reticent, keep to yourself",
"A. focus on here and now		B. look to the future, global perspective, big picture",
"A. tough-minded, just		B. reflective, deliberate",
"A. preparation, plan ahead	B. go with the flow , adapt as you go",
"A. active, initiate	B. reflective, deliberate",
"A. facts, things, what is	B. ideas, dreams, what could be,philosophical",
"A. matter of fact, issue-oriented	B. sensitive, people-oriented, compassionate",
"A. control, govern	B. latitude, freedom"
};
String [] spareList  = new String[questions.length];
Scanner inputReceiver = new Scanner(System.in);

for(int counter = 0; counter < questions.length;counter++){
	System.out.println(questions[counter]);
	System.out.println("Enter A or B");
	String userInput = inputReceiver.nextLine().toUpperCase();
	if(userInput.equals("A")  || userInput.equals("B")){
		spareList[counter] = userInput;
	}else{
		while(true){
			System.out.println("Expected A or B as response, Try again!");
			System.out.println(questions[counter]);
			userInput = inputReceiver.nextLine().toUpperCase();
				if(userInput.equals("A")  || userInput.equals("B")){
				spareList[counter] = userInput;break;
				}
		}
	}
}

int countExtro = 0;
int countIntro = 0;
int countSense = 0;
int countIntui = 0;
int countThink = 0;
int countFeel = 0;
int countJudge = 0;
int countPerspect = 0;

for(int value = 0; value < spareList.length;value+=4){
	if(spareList[value].equals("A"))countExtro++;
	else{
		countIntro++;
	}
}
for(int value = 1; value < spareList.length;value+=4){
	if(spareList[value].equals("A"))countSense++;
	else{
		countIntui++;
	}
}
for(int value = 2; value < spareList.length;value+=4){
	if(spareList[value].equals("A"))countThink++;
	else{
		countFeel++;
	}
}
for(int value = 3; value < spareList.length;value+=4){
	if(spareList[value].equals("A"))countJudge++;
	else{
		countPerspect++;
	}
}
String pTest = "";
if(countExtro > countIntro)pTest += "E";
else{
	pTest += "I";
}
if(countSense > countIntui)pTest += "S";
else{
	pTest += "N";
}
if(countThink > countFeel)pTest += "T";
else{
	pTest += "F";
}
if(countJudge > countPerspect)pTest += "J";
else{
	pTest += "P";
}

return pTest;





}
}