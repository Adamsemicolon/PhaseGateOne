const prompt = require('prompt-sync')();

function isCreditCard(cardNumber) {
    let firstChar = cardNumber.charAt(0);

    if (cardNumber.length < 13 || cardNumber.length > 16) {
        console.log("Invalid card Number");
        return;
    }

    let sumSecondDigit = 0;
    let sumOddPlace = 0;

    let cardType = "";
    if (firstChar === '4') {
        cardType = "Visa";
    } else if (firstChar === '5') {
        cardType = "MasterCard";
    } else if (firstChar === '3' && cardNumber.length > 1 && cardNumber.charAt(1) === '7') {
        cardType = "American Express";
    } else if (firstChar === '6') {
        cardType = "Discover";
    } else {
        console.log("Unsupported card type");
        return;
    }

    let value = 0;
    for (let counter = cardNumber.length - 1; value < cardNumber.length; counter--, value++) {
        let digit = Number(cardNumber.charAt(counter));

        if (counter % 2 === 0) {
            let take = digit * 2;
            let strTake = "" + take
            if (strTake.length > 1) {
                let takeIn = Number(strTake.charAt(0));
                let takeInSecondDigit = Number(strTake.charAt(1));
                sumSecondDigit += takeIn + takeInSecondDigit;
            } else {
                sumSecondDigit += take;
            }
        } else {
            sumOddPlace += digit;
        }
    }

    let sum = sumOddPlace + sumSecondDigit;

    console.log("Credit Card Type: " + cardType);
    console.log("Credit Card Number: " + cardNumber);
    console.log("Credit Card Digit length: " + cardNumber.length);
    console.log("Credit Card Validity Status: " + (sum % 10 === 0 ? "Valid" : "Invalid"));
}

let cardNumber = prompt("Hello, Kindly Enter Card details to verify: ");
isCreditCard(cardNumber);