import java.util.Scanner;
public class CreditCardFunction{
public static void main(String[]args){

Scanner userInput = new Scanner(System.in);

System.out.println("Hello, Kindly Enter Card details to verify: ");
String cardNumber = userInput.nextLine();
isCreditCard(cardNumber);
}

public static void isCreditCard(String cardNumber){
char firstChar = cardNumber.charAt(0);

if(cardNumber.length() < 13 || cardNumber.length() > 16){
System.out.print("Invalid card Number");
return;}

int sumSecondDigit = 0;
int sumOddPlace = 0;

String cardType = "";
if(firstChar == '4'){
	cardType = "Visa";
} else if (firstChar == '5') {
	cardType = "MasterCard";
} else if (firstChar == '3' && cardNumber.length() > 1 && cardNumber.charAt(1) == '7') {
	cardType = "American Express";
}else if (firstChar == '6') {
	cardType = "Discover";
} else {
	System.out.println("Unsupported card type");
	return;
}
int value = 0;
	for(int counter = cardNumber.length() -1; value < cardNumber.length(); counter--,value++){
		if(counter % 2 == 0){
			int take = Character.getNumericValue(cardNumber.charAt(counter));
			take *= 2;
			String takeInLength = String.valueOf(take);
			if(takeInLength.length() > 1){
				int takeIn = Character.getNumericValue(takeInLength.charAt(0));
				int takeInSecondDigit = Character.getNumericValue(takeInLength.charAt(1));
				sumSecondDigit += takeIn + takeInSecondDigit;
			}else{
			sumSecondDigit += take;	
			}
		}
		else{
			int getDigit = Character.getNumericValue(cardNumber.charAt(counter));
			sumOddPlace += getDigit;
		}
	}
	int sum = sumOddPlace + sumSecondDigit;
		System.out.println("Credit Card Type:" + cardType);
		System.out.println("Credit Card Number: " + cardNumber);
		System.out.println("Credit Card Digit length: " + cardNumber.length());
		System.out.println("Credit Card Validity Status: " + (sum % 10 == 0 ? "Valid" : "Invalid"));
	
}
}