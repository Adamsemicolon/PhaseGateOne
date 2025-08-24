import java.util.Scanner;

public class MenstrualApp {
public static void main(String[] args) {

Scanner userInput = new Scanner(System.in);
       
        while(true) {
            System.out.println("What day of the month did your last period start? ");
            int lastPeriodStartDay = userInput.nextInt();

            if (lastPeriodStartDay < 1 || lastPeriodStartDay > 31) {
                System.out.println("Invalid date, Pick a number between 1 and 31.");break;
            }

            System.out.println("How long is your cycle usually?");
            int cycleLength = userInput.nextInt();

            System.out.println("How many days does your period last? ");
            int periodLength = userInput.nextInt();

            if (cycleLength <= 0 || periodLength <= 0) {
                System.out.println("CycleLength and flow duration must be positive numbers.");break;
            }
            displayCycle(lastPeriodStartDay, cycleLength, periodLength);
        }
    }

public static void displayCycle(int lastPeriodStartDay, int cycleLength, int periodLength) {

	int flowEndDay = lastPeriodStartDay + periodLength - 1;

	int nextPeriod = lastPeriodStartDay + cycleLength;

	int ovulationDay = nextPeriod - 14;

	int fertileStartDay = ovulationDay - 4;
	int fertileEndDay = ovulationDay + 2;

	int safePeriod1Start = flowEndDay + 1;
	int safePeriod1End = fertileStartDay - 1;

	int safePeriod2Start = fertileEndDay + 1;
	int safePeriod2End = nextPeriod - 1;

	System.out.println("Here is your cycle info");
	System.out.println("Your last flow was Day " + lastPeriodStartDay + " to Day " + flowEndDay);
	System.out.println("Your next period starts on Day " + nextPeriod);
	System.out.println("Ovulation date is Day " + ovulationDay);
	System.out.println("Fertile window is Day " + fertileStartDay + " to Day " + fertileEndDay);

	if (safePeriod1Start <= safePeriod1End) {
        	System.out.println("Safe period 1: Day " + safePeriod1Start + " to Day " + safePeriod1End);}
	if (safePeriod2Start <= safePeriod2End) {
		System.out.println("Safe period 2: Day " + safePeriod2Start + " to Day " + safePeriod2End);}
}
}