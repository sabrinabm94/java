/*-------------------------------------------------------------------------------\
| * Trabalho.java - Programacao orientada a objetos.                             |
| * A intencao do programa e criar um jogo de matematica                         |
| * Com 3 niveis de dificuldade - 1 facil; 2 medio, 3 difícil;                   |
| * O jogo também possui 3 fases: fase 1, fase 2 e fase 3.                       |
| * Se o jogador conseguir passar pelas três fases em  qualquer um dos níveis de |
| * dificuldade ele vence o jogo naquela dificuldade.                            |
| * Cada dificuldade tem suas próprias perguntas e 3 fases para                  |
| * o jogador passar.                                                            |
| * Na fase 1 o jogador tem que fazer 85 pontos na dificuldade 1, 185 pontos na  |
| * dificuldade 2 e 385 pontos no dificuldade 3 para o jogador vencer o jogo.    |
| *                                                                              |
| * Na fase 2 o jogador tem que fazer 85 pontos no dificuldade 1, 185 pontos na  |
| * dificuldade 2 e 385 pontos no dificuldade 3.                                 |
| *                                                                              |
| * Na fase 3 o jogador tem que fazer 85 na no dificuldade 1, 185 pontos na      |
| * dificuldade 2 e 185 pontos no dificuldade 3.                                 |
| * Desenvolvedores: Eli Florêncio Pereira, Sabrina Boeing                       |
| * Professor Leanderson                                                         |
\-------------------------------------------------------------------------------*/

import java.util.Scanner;

public class Trabalho {
	public static int pontuacao = 0;
	// Pontuacao para passar cada fase do jogo.
	// Nivel ou Dificuldade 1 permitem ate 3 erros porque ( questoes = 20, pontuacao = 5; 5 x 20 = 100 )
	public static int[] pontuacaoPassarCadaFaseNivel1 = {85, 85, 85};
	// Dificuldade 2 permite 2 erros porque ( questoes = 20, pontuacao = 10; 10 x 20 = 200)
	public static int[] pontuacaoPassarCadaFaseNivel2 = {180, 180, 180};
	// Dificuldade 3 permite somente 1 erro porque ( questoes = 20, pontuacao = 20; 20 x 20 = 400)
	public static int[] pontuacaoPassarCadaFaseNivel3 = {380, 380, 380};
	// Variavel declarada aqui porque e usada em mais de uma funcao
	public static float resposta;
	// Idem Variavel anterior
	public static boolean acertou;
	// Pontuacao relacionada a cada dificuldade
	// Dificuldade 1 = 5, Dificuldade 2 = 10, Dificuldade 3 = 20
	public static int[] pontuacaoDificuldade = {5, 10, 20};
	// Variavel para testar mudanca de fase; Nao sei porque está aqui / verificar depois
	public static int fase = 1;
	// Variavel para dificuldade usada em mais de uma funcao
	public static int dificuldade;
  // Funcao main chama o menu inicial
	// se for escolhido 1 chamada a funcao
	// que escolhe a dificuldade
	// se for escolhido 2 sai.
	public static void main(String[] args) {
		int opcao;
		Scanner leia = new Scanner(System.in);
		do {
			System.out.println("|=====================|");
			System.out.println("| Jogo de matematica  |");
			System.out.println("|=====================|");
			System.out.println("| 1 ----> Comecar     |");
			System.out.println("| 2 ----> Sair        |");
			System.out.println("|=====================|");
			System.out.print("Escolha a opcao desejada: ");
			opcao = leia.nextInt();

			switch (opcao){
				case 1:
					escolhaDificuldade();
					break;
				case 2:
					System.out.println("Fim de jogo!");
					break;
				}
		}while(opcao != 2);
	}
	// Funcao pede pro usuario escolher a dificuldade
	// e direciona para as perguntas da fase 1 da
	// dificuldade selecionada
	public static void escolhaDificuldade() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("\nEscolha a dificuldade: 1 - facil 2 - media 3 - dificil: ");
		dificuldade = entrada.nextInt();
		if (dificuldade == 1)
		{
			System.out.println("\nVoce selecionou a dificuldade dificuldade 1 - Facil\n");
			perguntasDificuldade1Fase1();
		}
		else if (dificuldade == 2)
		{
			System.out.println("\nVoce selecionou a dificuldade dificuldade 2 - Medio\n");
			perguntasDificuldade2Fase1();
		}else{
			System.out.println("\nVoce selecionou a dificuldade dificuldade 3 - Dificil\n");
			perguntasDificuldade3Fase1();
		}
	}
	public static void perguntasDificuldade1Fase1(){
		// Fase1 - Soma e subtracao de numeros ate 100
		String[] operadores = {"-","+"};
		String operacao = " ";
		int resultado = 0;
		int contErros = 0;
		int[] valor1 = new int[20];
		int[] valor2 = new int[20];
		Scanner entrada = new Scanner(System.in);
		// Gera dois vetores de numeros inteiros que
		// serao usados nas contas
		for (int contador = 0; contador < 20; contador ++){
			valor1[contador] = (int)(Math.random() * 100);
			valor2[contador] = (int)(Math.random() * 100);
		}
		// Seleciona umas das operacoes e faz a pergunta
		// para a operacao escolhida
		for(int contador = 0; contador < 20; contador ++){
			//operacao seleciona um dos operadores do vetor operadores
			operacao = operadores[(int)(Math.random() * 2)];
			if ( operacao == "-"){
				System.out.print ("Responda quanto e " + valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] - valor2[contador];
				if ( resposta == resultado){
					acertou = true;
				}else{
					acertou = false;
					contErros ++; // incrementa a contagem de erros
				}
				pontuacaoCalculo();
			}else if( operacao == "+"){
				System.out.print("Responda quanto e " + valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] + valor2[contador];
				if ( resposta == resultado){
					acertou = true;
				}else{
					acertou = false;
					contErros ++; // incremeta a contagem de erros
				}
				// chama a funcao que incrementa ou decrementa
				// a pontuacao de acordo com a resposta
				// Tambem e responsavel por passar o jogador
				// para a proxima fase do jogo
				// obs* Funcao nao sera comentada ou se for
				// nao sera tao bem explicada quanto foi aqui
				// nas outras chamadas desta funcao
				pontuacaoCalculo();
				// Se a contagem de erros chegar a 3
				// chama a funcao com a mensagem
				// de game over e encerra o loop das
				// perguntas e faz o jogador voltar ao
			  // menu inicial
				if ( contErros > 3){
					gameOver();
					break;
				}
			}
		}
	}
	public static void perguntasDificuldade1Fase2(){
		// Fase 2 - Faz a soma e subtracao de numeros com ate 3 casas
		String[] operadores = {"+", "-"};
		String operacao = " ";
		int resultado = 0;
		int contErros = 0;
		int[] valor1 = new int[20];
		int[] valor2 = new int[20];
		Scanner entrada = new Scanner(System.in);
		// Gera os dois vetores de numeros ate 3 casas decimais
		for (int contador = 0; contador < 20; contador ++){
			valor1[contador] = (int)(Math.random() * 999);
			valor2[contador] = (int)(Math.random() * 999);
		}
		// Seleciona a operacao e faz as perguntas
		for (int contador = 0; contador < 20; contador ++){
			operacao = operadores[(int)(Math.random() * 2)];
			if ( operacao == "-"){
				System.out.print("Responda quanto e " + valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] - valor2[contador];
				if ( resposta == resultado ){
					acertou = true;
				}else{
					acertou = false;
					contErros ++; // Incrementa a contagem de erros
				}
				//Incrementa a pontuacao
				pontuacaoCalculo();
			}else if ( operacao == "+"){
				System.out.print("Responda quanto e "+ valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] + valor2[contador];
				if ( resposta == resultado){
					acertou = true;
				}else{
					acertou = false;
					contErros ++; // incrementa a contagem de erros
				}
				// Chegou ao limite erros, game over
				if ( contErros > 3){
					gameOver();
					break;
				}
				// incrementa a pontuacao
				pontuacaoCalculo();
			}
		}
	}
	public static void perguntasDificuldade1Fase3(){
		// Fase 3 - Faz a soma e subtracao de numeros com ate 4 casas
		String[] operadores = {"+", "-"};
		String operacao = " ";
		int resultado = 0;
		int contErros = 0;
		int[] valor1 = new int[20];
		int[] valor2 = new int[20];
		Scanner entrada = new Scanner(System.in);
    // Gera dois vetores de numeros ate 4 casas decimais
		for (int contador = 0; contador < 20; contador ++){
			valor1[contador] = (int)(Math.random() * 9999);
			valor2[contador] = (int)(Math.random() * 9999);
		}
		// Seleciona o operador e faz as perguntas
		for (int contador = 0; contador < 20; contador ++){
			operacao = operadores[(int)(Math.random() * 2)];
			if ( operacao == "-"){
				System.out.print("Responda quanto e " + valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] - valor2[contador];
				if ( resposta == resultado ){
					acertou = true;
				}else{
					acertou = false;
					contErros++; // Incrementa os erros
				}
				pontuacaoCalculo();
			}else if ( operacao == "+"){
				System.out.print("Responda quanto e "+ valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] + valor2[contador];
				if ( resposta == resultado){
					acertou = true;
				}else{
					acertou = false;
					contErros++; // Incrementa os erros
				}
				// Se chegou ao limite de erros, game over
				if ( contErros > 3){
					gameOver();
					break;
				}
				// incrementa a pontuacao
				pontuacaoCalculo();
			}
		}
	}
	public static void perguntasDificuldade2Fase1(){
		// Dificuldade 2 Fase 1 - Faz a soma,subtracao e multiplicacao de numeros com ate 2 casas
		String[] operadores = {"+", "-","*"};
		String operacao = " ";
		int resultado = 0;
		int contErros = 0;
		int[] valor1 = new int[20];
		int[] valor2 = new int[20];
		//Gera dois vetores de numeros
		Scanner entrada = new Scanner(System.in);
		for (int contador = 0; contador < 20; contador ++){
			valor1[contador] = (int)(Math.random() * 99);
			valor2[contador] = (int)(Math.random() * 99);
		}
		// Seleciona o operador e faz as perguntas
		for (int contador = 0; contador < 20; contador ++){
			operacao = operadores[(int)(Math.random() * 3)];
			if ( operacao == "-"){
				System.out.print("Responda quanto e " + valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] - valor2[contador];
				if ( resposta == resultado ){
					acertou = true;
				}else{
					acertou = false;
					contErros ++; // incrementa erros
				}
				pontuacaoCalculo();
			}else if ( operacao == "+"){
				System.out.print("Responda quanto e "+ valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] + valor2[contador];
				if ( resposta == resultado){
					acertou = true;
				}else{
					acertou = false;
					contErros ++; // incrementa erros
				}
				pontuacaoCalculo();
			}else if ( operacao == "*"){
				System.out.print("Responda quanto e "+ valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] * valor2[contador];
				if ( resposta == resultado){
					acertou = true;
				}else{
					acertou = false;
					contErros ++; // incrementa erros
				}
			}
			if (contErros > 2){
				gameOver();
				break;
			}
			pontuacaoCalculo();
		}
	}
	public static void perguntasDificuldade2Fase2(){
		// Dificuldade 2 Fase 2 - Faz a soma,subtracao e multiplicacao de numeros com ate 3 casas
		String[] operadores = {"+", "-","*"};
		String operacao = " ";
		int resultado = 0;
		int contErros = 0;
		int[] valor1 = new int[20];
		int[] valor2 = new int[20];
		Scanner entrada = new Scanner(System.in);
		// Gera dois vetores de numeros
		for (int contador = 0; contador < 20; contador ++){
			valor1[contador] = (int)(Math.random() * 999);
			valor2[contador] = (int)(Math.random() * 999);
		}
		// Seleciona o operador e faz as perguntas
		for (int contador = 0; contador < 20; contador ++){
			operacao = operadores[(int)(Math.random() * 3)];
			if ( operacao == "-" ){
				System.out.print("Responda quanto e " + valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] - valor2[contador];
				if ( resposta == resultado ){
					acertou = true;
				}else{
					acertou = false;
					contErros ++; // Incrementa erros
				}
				pontuacaoCalculo();
			}else if ( operacao == "+"){
				System.out.print("Responda quanto e "+ valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] + valor2[contador];
				if ( resposta == resultado){
					acertou = true;
				}else{
					acertou = false;
					contErros ++; // Incrementa erros
				}
				pontuacaoCalculo();
			}else if ( operacao == "*"){
				System.out.print("Responda quanto e "+ valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] * valor2[contador];
				if ( resposta == resultado){
					acertou = true;
				}else{
					acertou = false;
					contErros ++; // incrementa erros
				}
			}
			// Se errar mais que duas perguntas, game over
			if ( contErros > 2){
				gameOver();
				break;
			}
			pontuacaoCalculo();
		}
	}
	public static void perguntasDificuldade2Fase3(){
		// Dificuldade 2 Fase 3 - Faz a soma,subtracao e multiplicacao de numeros com ate 4 casas
		String[] operadores = {"+", "-","*"};
		String operacao = " ";
		int resultado = 0;
		int contErros = 0;
		int[] valor1 = new int[20];
		int[] valor2 = new int[20];
		Scanner entrada = new Scanner(System.in);
		// Gera dois vetores de numeros
		for (int contador = 0; contador < 20; contador ++){
			valor1[contador] = (int)(Math.random() * 9999);
			valor2[contador] = (int)(Math.random() * 9999);
		}
		// Seleciona o operador e faz as perguntas
		for (int contador = 0; contador < 20; contador ++){
			operacao = operadores[(int)(Math.random() * 3)];
			if ( operacao == "-"){
				System.out.print("Responda quanto e " + valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] - valor2[contador];
				if ( resposta == resultado ){
					acertou = true;
				}else{
					acertou = false;
					contErros ++; // Incrementa erros
				}
				pontuacaoCalculo();
			}else if ( operacao == "+"){
				System.out.print("Responda quanto e "+ valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] + valor2[contador];
				if ( resposta == resultado){
					acertou = true;
				}else{
					acertou = false;
					contErros ++; // incrementa erros
				}
				pontuacaoCalculo();
			}else if ( operacao == "*"){
				System.out.print("Responda quanto e "+ valor1[contador] + operacao + valor2[contador] + ": ");
				resposta = entrada.nextInt();
				resultado = valor1[contador] * valor2[contador];
				if ( resposta == resultado){
					acertou = true;
				}else{
					acertou = false;
					contErros ++; // incrementa erros
				}
			}
			if ( contErros > 2){
				gameOver();
				break;
			}
			pontuacaoCalculo();
		}
	}
	public static void perguntasDificuldade3Fase1(){
		// Dificuldade 3 Fase 1 - Dificuldade 3 somente multiplicacao de numeros com ate 2 casas
		String operacao = "*";
		int resultado = 0;
		int contErros = 0;
		int[] valor1 = new int[20];
		int[] valor2 = new int[20];
		Scanner entrada = new Scanner(System.in);
		// Gerar dois vetores de numeros
		for (int contador = 0; contador < 20; contador ++){
			valor1[contador] = (int)(Math.random() * 99);
			valor2[contador] = (int)(Math.random() * 99);
		}
		// Agora e so multiplicacao
		for (int contador = 0; contador < 20; contador ++){
			System.out.print("Responda quanto e "+ valor1[contador] + operacao + valor2[contador] + ": ");
			resposta = entrada.nextInt();
			resultado = valor1[contador] * valor2[contador];
			if ( resposta == resultado){
				acertou = true;
			}else{
				acertou = false;
				contErros ++; // incrementa erros
			}
			// Se errar mais que uma pergunta, game over
			if ( contErros > 1 ){
				gameOver();
				break;
			}
			pontuacaoCalculo();
		}
	}
	public static void perguntasDificuldade3Fase2(){
		// Dificuldade 3 Fase 2 - Dificuldade 3 somente multiplicacao de numeros com ate 2 casas
		String operacao = "*";
		int resultado = 0;
		int contErros = 0;
		int[] valor1 = new int[20];
		int[] valor2 = new int[20];
		Scanner entrada = new Scanner(System.in);
		// Gerar dois vetores de numeros
		for (int contador = 0; contador < 20; contador ++){
			valor1[contador] = (int)(Math.random() * 999);
			valor2[contador] = (int)(Math.random() * 999);
		}
		for (int contador = 0; contador < 20; contador ++){
			System.out.print("Responda quanto e "+ valor1[contador] + operacao + valor2[contador] + ": ");
			resposta = entrada.nextInt();
			resultado = valor1[contador] * valor2[contador];
			if ( resposta == resultado){
				acertou = true;
			}else{
				acertou = false;
				contErros ++; // incrementa erros
			}
			// Se errar mais que uma game over
			if ( contErros > 1 ){
				gameOver();
				break;
			}
			pontuacaoCalculo();
		}
	}
	public static void perguntasDificuldade3Fase3(){
		// Dificuldade 3 Fase 3 - Dificuldade 3 somente multiplicacao de numeros com ate 4 casas
		String operacao = "*";
		int resultado = 0;
		int contErros = 0;
		int[] valor1 = new int[20];
		int[] valor2 = new int[20];
		Scanner entrada = new Scanner(System.in);
		// Gerar dois vetores de numeros
		for (int contador = 0; contador < 20; contador ++){
			valor1[contador] = (int)(Math.random() * 9999);
			valor2[contador] = (int)(Math.random() * 9999);
		}
		for (int contador = 0; contador < 20; contador ++){
			System.out.print("Responda quanto e "+ valor1[contador] + operacao + valor2[contador] + ": ");
			resposta = entrada.nextInt();
			resultado = valor1[contador] * valor2[contador];
			if ( resposta == resultado){
				acertou = true;
			}else{
				acertou = false;
				contErros ++; // incrementa erros
			}
			// Se errar mais que uma pergunta, game over
			if ( contErros > 1 ){
				gameOver();
				break;
			}
			pontuacaoCalculo();
		}
	}
	public static void pontuacaoCalculo() {

		if ( acertou ) {
			pontuacao += pontuacaoDificuldade[dificuldade - 1];
			System.out.println("\nVoce acertou !\n");
			System.out.println("sua pontuacao atual e " + pontuacao + "\n\n");
		}else if ( !acertou ) {
			pontuacao -= pontuacaoDificuldade[dificuldade - 1];
			if ( pontuacao < 0 ){
				pontuacao = 0;
			}
			System.out.printf("\nVoce errou e perdeu %d pontos, sua pontuacao atual e %d \n\n",pontuacaoDificuldade[dificuldade - 1], pontuacao);
		}
		if ( dificuldade == 1 ){
			if ( pontuacao >= pontuacaoPassarCadaFaseNivel1[fase - 1] && fase == 1){
				fase = 2;
				pontuacao = 0;

				System.out.println("\nParabens !!!\n");
				System.out.println("Voce passou para a fase" + fase + "\n");

				perguntasDificuldade1Fase2();

			}else if ( pontuacao >= pontuacaoPassarCadaFaseNivel1[fase - 1] && fase == 2){
				fase = 3;
				pontuacao = 0;
				System.out.println("\nParabens!!!\n");
				System.out.println("Voce passou para a fase " + fase + "\n");

				perguntasDificuldade1Fase3();

			}else if ( pontuacao >= pontuacaoPassarCadaFaseNivel1[fase - 1] && fase == 3){
				fase = 1;
				pontuacao = 0;

				mensagemVencedor();

			}else if (dificuldade == 2){
				if ( pontuacao >= pontuacaoPassarCadaFaseNivel2[fase - 1] && fase == 1){
					fase = 2;
					pontuacao = 0;

					System.out.println("\nParabens !!!\n");
					System.out.println("Voce passou para a fase " + fase + "\n");

					perguntasDificuldade2Fase2();

				}else if (pontuacao >= pontuacaoPassarCadaFaseNivel2[fase - 1] && fase == 2){
					fase = 3;
					pontuacao = 0;

					System.out.println("\nParabens !!!\n");
					System.out.println("Voce passou para a fase " + fase + "\n");

					perguntasDificuldade2Fase3();

				}else if (pontuacao >= pontuacaoPassarCadaFaseNivel2[fase - 1] && fase == 3){
					fase = 1;
					pontuacao = 0;

					mensagemVencedor();
				}
			}else if ( dificuldade == 3){
				if (pontuacao >= pontuacaoPassarCadaFaseNivel3[fase - 1] && fase == 1){
					fase = 2;
					pontuacao = 0;

					System.out.println("\nParabens !!!\n");
					System.out.println("Voce passou para a fase " + fase + "\n");

					perguntasDificuldade3Fase2();

				}else if ( pontuacao >= pontuacaoPassarCadaFaseNivel3[fase - 1] && fase == 2){
					fase = 3;
					pontuacao = 0;

					System.out.println("\nParabens !!!\n");
					System.out.println("Voce passou para a fase " + fase + "\n");

					perguntasDificuldade3Fase3();

				}else if ( pontuacao >= pontuacaoPassarCadaFaseNivel3[fase - 1] && fase == 3){
					fase = 1;
					pontuacao = 0;

					mensagemVencedor();
				}
			}
		}
	}
	public static void mensagemVencedor(){
		System.out.println("\n\n  Parabens !!!!");
		System.out.println("\n Voce venceu o desafio no dificuldade " + dificuldade);
		System.out.println("\n\n\n");
		System.out.println("Desenvolvedores::::::::::::::::::::::::");
		System.out.println(":::: ELI FLORENCIO PEREIRA ::::::::::::");
		System.out.println(":::: SABRINA BOEING::::::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::");
		System.out.println(":::PROGRAMACAO ORIENTADA A OBJETOS:::::");
		System.out.println(":::PROFESSOR LEANDERSON::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::");
	}
	public static void gameOver(){
		System.out.println("::::::::::::::::::::::::::::");
		System.out.println("::Você obteve muitos erros::");
		System.out.println("::::::::GAME OVER:::::::::::");
		System.out.println("::::::::::::::::::::::::::::");
	}
}