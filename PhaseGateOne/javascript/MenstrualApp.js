const prompt = require('prompt-sync')();
	//while(true) {
		let lastPeriodStartDay = prompt('What day of the month did your last period start?');
		if (lastPeriodStartDay < 1 || lastPeriodStartDay > 31) {
		console.log("Invalid date, Pick a number between 1 and 31.");return;}

		let cycleLength = prompt("How long is your cycle usually?");

		let periodLength = prompt("How many days does your period last? ");

		if (cycleLength <= 0 || periodLength <= 0) {
		console.log("Cycle and flow duration must be positive numbers.");return;}

		displayCycle(lastPeriodStartDay, cycleLength, periodLength);
    //}

function displayCycle(lastPeriodStartDay, cycleLength, periodLength) {

	let flowEndDay = Number(lastPeriodStartDay) + Number(periodLength) - 1;
	console.log(flowEndDay);

	let nextPeriod = Number(lastPeriodStartDay) + Number(cycleLength);

	let ovulationDay = nextPeriod - 14;

	let fertileStartDay = ovulationDay - 4;
	let fertileEndDay = ovulationDay + 2;

	let safePeriod1Start = flowEndDay + 1;
	let safePeriod1End = fertileStartDay - 1;

	let safePeriod2Start = fertileEndDay + 1;
	let safePeriod2End = nextPeriod - 1;

	console.log("Here is your cycle info");
	console.log(`Your last flow was Day ${lastPeriodStartDay} to Day ${flowEndDay}`);
	console.log(`Your next period starts on Day ${nextPeriod}`);
	console.log(`Ovulation date is Day ${ovulationDay}`);
	console.log(`Fertile window is Day ${fertileStartDay} to Day ${fertileEndDay}`);

	if (safePeriod1Start <= safePeriod1End) {
        	console.log(`Safe period 1 is Day ${safePeriod1Start} to Day ${safePeriod1End}`);}
	if (safePeriod2Start <= safePeriod2End) {
        	console.log(`Safe period 2 is Day ${safePeriod2Start} to Day ${safePeriod2End}`);}
}
