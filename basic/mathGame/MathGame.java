package mathGame;

import java.util.Scanner;

public class MathGame {
	public static int points = 0;
	public static int[] pointsPassStageLevel1 = {85, 85, 85};
	public static int[] pointsPassStageLevel2 = {180, 180, 180};
	public static int[] pointsPassStageLevel3 = {380, 380, 380};
	public static float answers;
	public static boolean hit;
	public static int[] pointsdifficulty = {5, 10, 20};
	public static int phase = 1;
	public static int difficulty;

	public static void main(String[] args) {
		int option;
		Scanner enterData = new Scanner(System.in);
		do {
			Print.print("|=====================|");
			Print.print("|      Math Game      |");
			Print.print("|=====================|");
			Print.print("| 1 ----> Start       |");
			Print.print("| 2 ----> Exit        |");
			Print.print("|=====================|");
			Print.print("Choose the desired option: ");
			option = enterData.nextInt();

			switch (option){
				case 1:
					chooseDificult();
				break;
				case 2:
					Print.print("End game!");
				break;
			}
		} while(option != 2);
	}
	public static void chooseDificult() {
		Scanner enter = new Scanner(System.in);
		Print.print("\nChoose the difficulty: 1 - easy 2 - average 3 - difficult: ");
		difficulty = enter.nextInt();

		if (difficulty == 1) {
			Print.print("\nYou chose the difficulty: 1 - easy\n");
			questiondifficulty1phase1();
		}
		else if (difficulty == 2) {
			Print.print("\nYou chose the difficulty: 2 - average\n");
			questiondifficulty2phase1();
		} else{
			Print.print("\nYou chose the difficulty: 3 - difficult\n");
			questiondifficulty3phase1();
		}
	}
	public static void questiondifficulty1phase1(){
		String[] operators = {"-","+"};
		String operation = " ";
		int result = 0;
		int errorCounter = 0;
		int[] value1 = new int[20];
		int[] value2 = new int[20];

		Scanner enter = new Scanner(System.in);

		for (int counter = 0; counter < 20; counter ++){
			value1[counter] = (int)(Math.random() * 100);
			value2[counter] = (int)(Math.random() * 100);
		}
		for(int counter = 0; counter < 20; counter ++){
			operation = operators[(int)(Math.random() * 2)];
			if(operation == "-"){
				Print.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] - value2[counter];
				if ( answers == result){
					hit = true;
				}else{
					hit = false;
					errorCounter ++;
				}
				pointsCalculo();
			}else if( operation == "+"){
				Print.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] + value2[counter];
				if ( answers == result){
					hit = true;
				}else{
					hit = false;
					errorCounter ++; 
				}
				pointsCalculo();
				if ( errorCounter > 3){
					gameOver();
					break;
				}
			}
		}
	}
	public static void questiondifficulty1phase2(){
		String[] operators = {"+", "-"};
		String operation = " ";
		int result = 0;
		int errorCounter = 0;
		int[] value1 = new int[20];
		int[] value2 = new int[20];

		Scanner enter = new Scanner(System.in);

		for (int counter = 0; counter < 20; counter ++){
			value1[counter] = (int)(Math.random() * 999);
			value2[counter] = (int)(Math.random() * 999);
		}
		for (int counter = 0; counter < 20; counter ++){
			operation = operators[(int)(Math.random() * 2)];
			if ( operation == "-"){
				Print.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] - value2[counter];
				if ( answers == result ){
					hit = true;
				}else{
					hit = false;
					errorCounter ++; 
				}
				pointsCalculo();
			}else if ( operation == "+"){
				Print.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] + value2[counter];
				if ( answers == result){
					hit = true;
				}else{
					hit = false;
					errorCounter ++; 
				}
				if ( errorCounter > 3){
					gameOver();
					break;
				}
				pointsCalculo();
			}
		}
	}
	public static void questiondifficulty1phase3(){
		String[] operators = {"+", "-"};
		String operation = " ";
		int result = 0;
		int errorCounter = 0;
		int[] value1 = new int[20];
		int[] value2 = new int[20];
		Scanner enter = new Scanner(System.in);
		for(int counter = 0; counter < 20; counter ++){
			value1[counter] = (int)(Math.random() * 9999);
			value2[counter] = (int)(Math.random() * 9999);
		}

		for(int counter = 0; counter < 20; counter ++){
			operation = operators[(int)(Math.random() * 2)];
			if(operation == "-"){
				Print.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] - value2[counter];
				if ( answers == result ){
					hit = true;
				}else{
					hit = false;
					errorCounter++; 
				}
				pointsCalculo();
			} else if ( operation == "+"){
				Print.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] + value2[counter];
				if ( answers == result){
					hit = true;
				}else{
					hit = false;
					errorCounter++; 
				}
				if ( errorCounter > 3){
					gameOver();
					break;
				}
				pointsCalculo();
			}
		}
	}

	public static void questiondifficulty2phase1(){
		String[] operators = {"+", "-","*"};
		String operation = " ";
		int result = 0;
		int errorCounter = 0;
		int[] value1 = new int[20];
		int[] value2 = new int[20];

		Scanner enter = new Scanner(System.in);

		for (int counter = 0; counter < 20; counter ++){
			value1[counter] = (int)(Math.random() * 99);
			value2[counter] = (int)(Math.random() * 99);
		}
		for (int counter = 0; counter < 20; counter ++){
			operation = operators[(int)(Math.random() * 3)];
			if ( operation == "-"){
				Print.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] - value2[counter];
				if ( answers == result ){
					hit = true;
				}else{
					hit = false;
					errorCounter ++; 
				}
				pointsCalculo();
			} else if ( operation == "+"){
				Print.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] + value2[counter];
				if ( answers == result){
					hit = true;
				}else{
					hit = false;
					errorCounter ++; 
				}
				pointsCalculo();
			} else if ( operation == "*"){
				System.out.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] * value2[counter];
				if ( answers == result){
					hit = true;
				}else{
					hit = false;
					errorCounter ++; 
				}
			}

			if (errorCounter > 2){
				gameOver();
				break;
			}
			pointsCalculo();
		}
	}

	public static void questiondifficulty2phase2(){
		String[] operators = {"+", "-","*"};
		String operation = " ";
		int result = 0;
		int errorCounter = 0;
		int[] value1 = new int[20];
		int[] value2 = new int[20];
		Scanner enter = new Scanner(System.in);
		for (int counter = 0; counter < 20; counter ++){
			value1[counter] = (int)(Math.random() * 999);
			value2[counter] = (int)(Math.random() * 999);
		}
		for (int counter = 0; counter < 20; counter ++){
			operation = operators[(int)(Math.random() * 3)];

			if ( operation == "-" ){
				Print.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] - value2[counter];
				if ( answers == result ){
					hit = true;
				}else{
					hit = false;
					errorCounter ++; 
				}
				pointsCalculo();
			} else if ( operation == "+"){
				Print.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] + value2[counter];
				if ( answers == result){
					hit = true;
				}else{
					hit = false;
					errorCounter ++; 
				}
				pointsCalculo();
			}else if(operation == "*"){
				Print.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] * value2[counter];
				if ( answers == result){
					hit = true;
				}else{
					hit = false;
					errorCounter ++; 
				}
			}
			if(errorCounter > 2){
				gameOver();
				break;
			}
			pointsCalculo();
		}
	}
	public static void questiondifficulty2phase3(){
		String[] operators = {"+", "-","*"};
		String operation = " ";
		int result = 0;
		int errorCounter = 0;
		int[] value1 = new int[20];
		int[] value2 = new int[20];
		Scanner enter = new Scanner(System.in);

		for (int counter = 0; counter < 20; counter ++){
			value1[counter] = (int)(Math.random() * 9999);
			value2[counter] = (int)(Math.random() * 9999);
		}

		for (int counter = 0; counter < 20; counter ++){
			operation = operators[(int)(Math.random() * 3)];
			if ( operation == "-"){
				Print.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] - value2[counter];
				if ( answers == result ){
					hit = true;
				}else{
					hit = false;
					errorCounter ++; 
				}
				pointsCalculo();
			}else if ( operation == "+"){
				Print.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] + value2[counter];
				if ( answers == result){
					hit = true;
				}else{
					hit = false;
					errorCounter ++;
				}
				pointsCalculo();
			}else if ( operation == "*"){
				Print.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] * value2[counter];
				if ( answers == result){
					hit = true;
				}else{
					hit = false;
					errorCounter ++;
				}
			}
			if ( errorCounter > 2){
				gameOver();
				break;
			}
			pointsCalculo();
		}
	}
	public static void questiondifficulty3phase1(){
		String operation = "*";
		int result = 0;
		int errorCounter = 0;
		int[] value1 = new int[20];
		int[] value2 = new int[20];
		Scanner enter = new Scanner(System.in);

		for (int counter = 0; counter < 20; counter ++){
			value1[counter] = (int)(Math.random() * 99);
			value2[counter] = (int)(Math.random() * 99);
		}

		for (int counter = 0; counter < 20; counter ++){
			Print.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
			answers = enter.nextInt();
			result = value1[counter] * value2[counter];
			if ( answers == result){
				hit = true;
			} else{
				hit = false;
				errorCounter ++; 
			}
			if ( errorCounter > 1 ){
				gameOver();
				break;
			}
			pointsCalculo();
		}
	}

	public static void questiondifficulty3phase2(){
		String operation = "*";
		int result = 0;
		int errorCounter = 0;
		int[] value1 = new int[20];
		int[] value2 = new int[20];
		Scanner enter = new Scanner(System.in);

		for (int counter = 0; counter < 20; counter ++){
			value1[counter] = (int)(Math.random() * 999);
			value2[counter] = (int)(Math.random() * 999);
		}

		for (int counter = 0; counter < 20; counter ++){
			Print.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
			answers = enter.nextInt();
			result = value1[counter] * value2[counter];
			if ( answers == result){
				hit = true;
			}else{
				hit = false;
				errorCounter ++; 
			}
			if ( errorCounter > 1 ){
				gameOver();
				break;
			}
			pointsCalculo();
		}
	}
	public static void questiondifficulty3phase3(){
		String operation = "*";
		int result = 0;
		int errorCounter = 0;
		int[] value1 = new int[20];
		int[] value2 = new int[20];
		Scanner enter = new Scanner(System.in);
		for (int counter = 0; counter < 20; counter ++){
			value1[counter] = (int)(Math.random() * 9999);
			value2[counter] = (int)(Math.random() * 9999);
		}

		for (int counter = 0; counter < 20; counter ++){
			Print.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
			answers = enter.nextInt();
			result = value1[counter] * value2[counter];
			if ( answers == result){
				hit = true;
			}else{
				hit = false;
				errorCounter ++; 
			}
			if ( errorCounter > 1 ){
				gameOver();
				break;
			}
			pointsCalculo();
		}
	}

	public static void pointsCalculo() {
		if ( hit ) {
			points += pointsdifficulty[difficulty - 1];
			Print.print("\nYou answered wrong !\n");
			Print.print("Your current points is " + points + "\n\n");
		}else if ( !hit ) {
			points -= pointsdifficulty[difficulty - 1];
			if ( points < 0 ){
				points = 0;
			}
			Print.print("\nYou answered wrong and lose %d points, your current points is" + pointsdifficulty[difficulty - 1] + points);
		}
		if ( difficulty == 1 ){
			if ( points >= pointsPassStageLevel1[phase - 1] && phase == 1){
				phase = 2;
				points = 0;

				Print.print("\n Congratulations !!!\n");
				Print.print("You went to the phase " + phase + "\n");

				questiondifficulty1phase2();

			}else if ( points >= pointsPassStageLevel1[phase - 1] && phase == 2){
				phase = 3;
				points = 0;
				Print.print("\n Congratulations!!!\n");
				Print.print("You went to the phase " + phase + "\n");

				questiondifficulty1phase3();

			}else if ( points >= pointsPassStageLevel1[phase - 1] && phase == 3){
				phase = 1;
				points = 0;

				winnerMessage();

			}else if (difficulty == 2){
				if ( points >= pointsPassStageLevel2[phase - 1] && phase == 1){
					phase = 2;
					points = 0;

					Print.print("\n Congratulations !!!\n");
					Print.print("You went to the phase " + phase + "\n");

					questiondifficulty2phase2();

				}else if (points >= pointsPassStageLevel2[phase - 1] && phase == 2){
					phase = 3;
					points = 0;

					Print.print("\n Congratulations !!!\n");
					Print.print("You went to the phase " + phase + "\n");

					questiondifficulty2phase3();

				}else if (points >= pointsPassStageLevel2[phase - 1] && phase == 3){
					phase = 1;
					points = 0;

					winnerMessage();
				}
			}else if ( difficulty == 3){
				if (points >= pointsPassStageLevel3[phase - 1] && phase == 1){
					phase = 2;
					points = 0;

					Print.print("\n Congratulations !!!\n");
					Print.print("You went to the phase " + phase + "\n");

					questiondifficulty3phase2();

				}else if ( points >= pointsPassStageLevel3[phase - 1] && phase == 2){
					phase = 3;
					points = 0;

					Print.print("\n Congratulations !!!\n");
					Print.print("You went to the phase " + phase + "\n");

					questiondifficulty3phase3();

				}else if ( points >= pointsPassStageLevel3[phase - 1] && phase == 3){
					phase = 1;
					points = 0;

					winnerMessage();
				}
			}
		}
	}
	public static void winnerMessage(){
		Print.print("\n\n  Congratulations !!!!");
		Print.print("\n You have won the challenge in difficulty: " + difficulty);
	}
	public static void gameOver(){
		Print.print("::::::::::::::::::::::::::::");
		Print.print(":::You got many mistakes.:::");
		Print.print("::::::::GAME OVER:::::::::::");
		Print.print("::::::::::::::::::::::::::::");
	}
}
