def is_personality_test(name):
	questions = [
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
	]
	spare_list = []

	for question in questions:
		while True:
			print(question)
			user_input = input("Enter A or B: ").upper()
			if user_input == "A" or user_input == "B":
				spare_list.append(user_input)
				break
			else:
				print("Expected A or B as response, Try again!")
	
	count_extro = 0
	count_intro = 0
	count_sense = 0
	count_intui = 0
	count_think = 0
	count_feel = 0
	count_judge = 0
	count_perspect = 0

	for value in range(0, len(spare_list), 4):
		if spare_list[value] == "A":
			count_extro += 1
		else:
			count_intro += 1

	for value in range(1, len(spare_list), 4):
		if spare_list[value] == "A":
			count_sense += 1
		else:
			count_intui += 1

	for value in range(2, len(spare_list), 4):
		if spare_list[value] == "A":
			count_think += 1
		else:
			count_feel += 1

	for value in range(3, len(spare_list), 4):
		if spare_list[value] == "A":
			count_judge += 1
		else:
			count_perspect += 1

	p_test = ""
	if count_extro > count_intro:
		p_test += "E"
	else:
		p_test += "I"

	if count_sense > count_intui:
		p_test += "S"
	else:
		p_test += "N"

	if count_think > count_feel:
		p_test += "T"
	else:
		p_test += "F"

	if count_judge > count_perspect:
		p_test += "J"
	else:
		p_test += "P"

	return p_test

name = input('What is your name: ')
result = is_personality_test(name)
print(f"{name}, Your personality type is {result}")