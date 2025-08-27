def isCreditCard(cardNumber):
    firstChar = cardNumber[0]

    if len(cardNumber) < 13 or len(cardNumber) > 16:
        print("Invalid card Number")
        return

    sumSecondDigit = 0
    sumOddPlace = 0

    cardType = ""
    if firstChar == '4':
        cardType = "Visa"
    elif firstChar == '5':
        cardType = "MasterCard"
    elif firstChar == '3' and len(cardNumber) > 1 and cardNumber[1] == '7':
        cardType = "American Express"
    elif firstChar == '6':
        cardType = "Discover"
    else:
        print("Unsupported card type")
        return

    length = len(cardNumber)
    for counter in range(length - 1, -1, -1):
        digit = int(cardNumber[counter])
        if counter % 2 == 0:
            take = digit * 2
            take_str = str(take)
            if len(take_str) > 1:
                takeIn = int(take_str[0])
                takeInSecondDigit = int(take_str[1])
                sumSecondDigit += takeIn + takeInSecondDigit
            else:
                sumSecondDigit += take
        else:
            sumOddPlace += digit

    sum = sumSecondDigit + sumOddPlace

    print("Credit Card Type: " + cardType)
    print("Credit Card Number: " + cardNumber)
    print("Credit Card Digit length: " + str(len(cardNumber)))
    print("Credit Card Validity Status: " + ("Valid" if sum % 10 == 0 else "Invalid"))


cardNumber = input("Hello, Kindly Enter Card details to verify: ")
isCreditCard(cardNumber)