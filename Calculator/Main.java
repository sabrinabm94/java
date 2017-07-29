import java.util.Scanner;

public class Main {
	public static float numeroA;
	public static float numeroB;
	
	public static void main(String[] args) {
		int opcao = 0;
		imprimirMenu(opcao);
	}
	
	public static void imprimirMenu(int opcao){
		System.out.println("|=====================|");
        System.out.println("| Operações matemáticas |");
        System.out.println("|=====================|");
        System.out.println("| 1 ----> Somar       |");
        System.out.println("| 2 ----> Subtrair    |");
        System.out.println("| 3 ----> multiplicar |");
        System.out.println("| 4 ----> dividir     |");
        System.out.println("| 5 ----> potência    |");
        System.out.println("| 6 ----> sair        |");
        System.out.println("|=====================|");
        System.out.print("Escolha a opção desejada: ");
    	Scanner leia = new Scanner(System.in);
		opcao = leia.nextInt();
		menuOpcao(opcao);
	}
	
	public static void menuOpcao(int opcao){
		switch(opcao){
		case 1: 
			useSomar(numeroA, numeroB);
			break;
		case 2: 
			 useSubtrair(numeroA, numeroB);
			break;
		case 3: 
			 useMultiplicar(numeroA, numeroB);
			break;
		case 4: 
			 useDividir(numeroA, numeroB);
			break;
		case 5: 
			usePotencia(numeroA, numeroB);
			break;
		case 6: 
			 System.out.println("Fim de jogo");
			 break;
		}
		
		if (opcao != 1 && opcao !=2 && opcao !=3 && opcao != 4 && opcao != 5 && opcao != 6) {
			 System.out.println("Opção inválida, tente novamente");
			 imprimirMenu(0);
		}
	}
    
	public static void useSomar(float numeroA, float numeroB){
		System.out.println("Operação de Soma: ");
		somar Soma = new somar();
		Scanner entrada = new Scanner(System.in); 
		System.out.print("Operação de Soma ");
        System.out.print("Digite o valor A: ");
        numeroA = entrada.nextInt();
        System.out.print("Digite o valor B: ");
        numeroB = entrada.nextInt();
        System.out.print("Resultado: " + Soma.somar(numeroA, numeroB));
        imprimirMenu(0);
	}
	
	public static void useSubtrair(float numeroA, float numeroB){
		System.out.println("Operação de Subtrair: ");
		subtrair Subtracao = new subtrair();
		Scanner entrada2 = new Scanner(System.in);
		System.out.print("Subtracao ");
        System.out.print("Digite o valor A: ");
        numeroA = entrada2.nextInt();
        System.out.print("Digite o valor B: ");
        numeroB = entrada2.nextInt();
        System.out.print("Resultado: " + Subtracao.subtrair(numeroA, numeroB));
        imprimirMenu(0);
	}
	
	public static void useMultiplicar(float numeroA, float numeroB){
		System.out.println("Operação de Multiplicar: ");
		multiplicar Multiplicacao = new multiplicar();
		Scanner entrada3 = new Scanner(System.in); 
		System.out.print("Multiplicação ");
        System.out.print("Digite o valor A: ");
        numeroA = entrada3.nextInt();
        System.out.print("Digite o valor B: ");
        numeroB = entrada3.nextInt();
        System.out.print("Resultado: " + Multiplicacao.multiplicar(numeroA, numeroB));
        imprimirMenu(0);
	}
	
	public static void useDividir(float numeroA, float numeroB){
		System.out.println("Operação de Dividir: ");
        dividir Divisao = new dividir();
		Scanner entrada4 = new Scanner(System.in); 
		System.out.print("Divisão ");
        System.out.print("Digite o valor A: ");
       numeroA = entrada4.nextInt();
        System.out.print("Digite o valor B: ");
        numeroB = entrada4.nextInt();
        System.out.print("Resultado: " + Divisao.dividir(numeroA, numeroB));
        imprimirMenu(0);
	}
	
	public static void usePotencia(float numeroA, float numeroB){
		System.out.println("Operação de Potência: ");
		potencia Potencia = new potencia();
		Scanner entrada5 = new Scanner(System.in); 
		System.out.print("Potência ");
        System.out.print("Digite o valor A: ");
        numeroA = entrada5.nextInt();
        System.out.print("Digite o valor B: ");
        numeroB = entrada5.nextInt();
        System.out.print("Resultado: " + Potencia.potencia(numeroA, numeroB));
        imprimirMenu(0);
	}
}
