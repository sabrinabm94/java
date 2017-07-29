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
			System.out.println("|=====================|");
			System.out.println("|      Math Game      |");
			System.out.println("|=====================|");
			System.out.println("| 1 ----> Start       |");
			System.out.println("| 2 ----> Exit        |");
			System.out.println("|=====================|");
			System.out.print("Choose the desired option: ");
			option = enterData.nextInt();

			switch (option){
				case 1:
				Choose difficultychooseDificult();
				break;
				case 2:
				System.out.println("End game!");
				break;
			}
		}while(option != 2);
	}
	// Funcao pede pro usuario escolher a difficulty
	// e direciona para as question da phase 1 da
	// difficulty selecionada
	public static void chooseDificult() {
		Scanner enter = new Scanner(System.in);
		System.out.print("\nChoose the difficulty: 1 - easy 2 - average 3 - difficult: ");
		difficulty = enter.nextInt();
		if (difficulty == 1)
		{
			System.out.println("\nYou chose the difficulty: 1 - easy\n");
			questiondifficulty1phase1();
		}
		else if (difficulty == 2)
		{
			System.out.println("\nYou chose the difficulty: 2 - average\n");
			questiondifficulty2phase1();
		}else{
			System.out.println("\nYou chose the difficulty: 3 - difficult\n");
			questiondifficulty3phase1();
		}
	}
	public static void questiondifficulty1phase1(){
		// phase1 - Soma e subtracao de numeros ate 100
		String[] operators = {"-","+"};
		String operation = " ";
		int result = 0;
		int errorCounter = 0;
		int[] value1 = new int[20];
		int[] value2 = new int[20];
		Scanner enter = new Scanner(System.in);
		// Gera dois vetores de numeros inteiros que
		// serao usados nas contas
		for (int counter = 0; counter < 20; counter ++){
			value1[counter] = (int)(Math.random() * 100);
			value2[counter] = (int)(Math.random() * 100);
		}
		// Seleciona umas das operacoes e faz a pergunta
		// para a operation escolhida
		for(int counter = 0; counter < 20; counter ++){
			//operation seleciona um dos operators do vetor operators
			operation = operators[(int)(Math.random() * 2)];
			if ( operation == "-"){
				System.out.print ("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] - value2[counter];
				if ( answers == result){
					hit = true;
				}else{
					hit = false;
					errorCounter ++; // incrementa a contagem de erros
				}
				pointsCalculo();
			}else if( operation == "+"){
				System.out.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
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
				System.out.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
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
				System.out.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
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
		for (int counter = 0; counter < 20; counter ++){
			value1[counter] = (int)(Math.random() * 9999);
			value2[counter] = (int)(Math.random() * 9999);
		}
		for (int counter = 0; counter < 20; counter ++){
			operation = operators[(int)(Math.random() * 2)];
			if ( operation == "-"){
				System.out.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
				answers = enter.nextInt();
				result = value1[counter] - value2[counter];
				if ( answers == result ){
					hit = true;
				}else{
					hit = false;
					errorCounter++; 
				}
				pointsCalculo();
			}else if ( operation == "+"){
				System.out.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
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
				System.out.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
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
				System.out.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
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
				System.out.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
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
				System.out.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
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
			if ( errorCounter > 2){
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
				System.out.print("Answer how much is " + value1[counter] + operation + value2[counter] + ": ");
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
				System.out.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
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
			System.out.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
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
			System.out.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
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
			System.out.print("Answer how much is "+ value1[counter] + operation + value2[counter] + ": ");
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
			System.out.println("\nYou answered wrong !\n");
			System.out.println("Your current points is" + points + "\n\n");
		}else if ( !hit ) {
			points -= pointsdifficulty[difficulty - 1];
			if ( points < 0 ){
				points = 0;
			}
			System.out.printf("\nYou answered wrong and lose %d points, your current points is %d \n\n",pointsdifficulty[difficulty - 1], points);
		}
		if ( difficulty == 1 ){
			if ( points >= pointsPassStageLevel1[phase - 1] && phase == 1){
				phase = 2;
				points = 0;

				System.out.println("\n Congratulations !!!\n");
				System.out.println("You went to the phase " + phase + "\n");

				questiondifficulty1phase2();

			}else if ( points >= pointsPassStageLevel1[phase - 1] && phase == 2){
				phase = 3;
				points = 0;
				System.out.println("\n Congratulations!!!\n");
				System.out.println("You went to the phase " + phase + "\n");

				questiondifficulty1phase3();

			}else if ( points >= pointsPassStageLevel1[phase - 1] && phase == 3){
				phase = 1;
				points = 0;

				winnerMessage();

			}else if (difficulty == 2){
				if ( points >= pointsPassStageLevel2[phase - 1] && phase == 1){
					phase = 2;
					points = 0;

					System.out.println("\n Congratulations !!!\n");
					System.out.println("You went to the phase " + phase + "\n");

					questiondifficulty2phase2();

				}else if (points >= pointsPassStageLevel2[phase - 1] && phase == 2){
					phase = 3;
					points = 0;

					System.out.println("\n Congratulations !!!\n");
					System.out.println("You went to the phase " + phase + "\n");

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

					System.out.println("\n Congratulations !!!\n");
					System.out.println("You went to the phase " + phase + "\n");

					questiondifficulty3phase2();

				}else if ( points >= pointsPassStageLevel3[phase - 1] && phase == 2){
					phase = 3;
					points = 0;

					System.out.println("\n Congratulations !!!\n");
					System.out.println("You went to the phase " + phase + "\n");

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
		System.out.println("\n\n  Congratulations !!!!");
		System.out.println("\n You have won the challenge in difficulty: " + difficulty);
		System.out.println("\n\n\n");
		System.out.println(":::::::::::::::::::::::::::::::::::::::");
		System.out.println(":::::::::::::Developed by::::::::::::::");
		System.out.println(":::: ELI FLORENCIO PEREIRA ::::::::::::");
		System.out.println(":::: SABRINA BOEING::::::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::");
	}
	public static void gameOver(){
		System.out.println("::::::::::::::::::::::::::::");
		System.out.println(":::You got many mistakes.:::");
		System.out.println("::::::::GAME OVER:::::::::::");
		System.out.println("::::::::::::::::::::::::::::");
	}
}