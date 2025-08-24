
def displayCycle(last_period_start_day, cycle_length, period_length):

	flow_end_day = last_period_start_day + period_length - 1

	next_period = last_period_start_day + cycle_length

	ovulation_day = next_period - 14

	fertile_start_day = ovulation_day - 4
	fertile_end_day = ovulation_day + 2

	safe_period_1_start = flow_end_day + 1
	safe_period_1_end = fertile_start_day - 1

	safe_period_2_start = fertile_end_day + 1
	safe_period_2_end = next_period - 1

	print("Here is your cycle info");
	print(f"Your last flow was Day {last_period_start_day} to Day {flow_end_day}")
	print(f"Your next period starts on Day {next_period}" )
	print(f"Ovulation date is Day {ovulation_day}")
	print(f"Fertile window is Day {fertile_start_day} to Day {fertile_end_day}")

	if safe_period_1_start <= safe_period_1_end:
        	print(f'Safe period 1 is Day {safe_period_1_start} to Day{safe_period_1_end}')
	if safe_period_2_start <= safe_period_2_end:
        	print(f'Safe period 2 is Day {safe_period_2_start} to Day {safe_period_2_end}')



while(True):
	last_period_start_day = int(input('What day of the month did your last period start?'))
	if last_period_start_day < 1 or last_period_start_day > 31:
		print("Invalid date, Pick a number between 1 and 31.")

	cycle_length = int(input("How long is your cycle usually?"))

	period_length = int(input("How many days does your period last? "))
	
	if cycle_length <= 0 or period_length <= 0:
		print("Cycle and flow duration must be positive numbers.")
	displayCycle(last_period_start_day, cycle_length, period_length)
	break;