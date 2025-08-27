const prompt = require('prompt-sync')();
let name = prompt('What is your name');
let result = isPersonalityTest(name);
console.log(`${name}, Your personality type is ${result}`);

function isPersonalityTest(name){
let questions = [
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
];
let spareList  = [];

for(let counter = 0; counter < questions.length;counter++){
	console.log(`${questions[counter]}`);
	let userInput = prompt('Enter A or B').toUpperCase();
	if(userInput === "A"  || userInput === "B"){
		spareList[counter] = userInput;
	}else{
		while(true){
			console.log("Expected A or B as response, Try again!");
			userInput = prompt(questions[counter]).toUpperCase();
				if(userInput === "A"  || userInput === "B"){
				spareList[counter] = userInput;break;
				}
		}
	}
}

let countExtro = 0;
let countIntro = 0;
let countSense = 0;
let countIntui = 0;
let countThink = 0;
let countFeel = 0;
let countJudge = 0;
let countPerspect = 0;

for(let value = 0; value < spareList.length;value+=4){
	if(spareList[value] === "A")countExtro++;
	else{
		countIntro++;
	}
}
for(let value = 1; value < spareList.length;value+=4){
	if(spareList[value] === "A")countSense++;
	else{
		countIntui++;
	}
}
for(let value = 2; value < spareList.length;value+=4){
	if(spareList[value] === "A")countThink++;
	else{
		countFeel++;
	}
}
for(let value = 3; value < spareList.length;value+=4){
	if(spareList[value] === "A")countJudge++;
	else{
		countPerspect++;
	}
}
let pTest = "";
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