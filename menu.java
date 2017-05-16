import java.util.Scanner;

public class menu {
    public static float saldo;
    public static int opcao;

    public static void menu(){
    	Scanner entrada = new Scanner(System.in);
        System.out.println("Escolha uma das opções a baixo:");
        System.out.println("0. Fim");
        System.out.println("1. Depósito");
        System.out.println("2. Saque");
        System.out.println("3. Consulta");
        System.out.println("Opcao:");
    }

    public static void deposito(){
        System.out.println("Você entrou no método depósito.");
	    float valorDeposito;
	    Scanner entrada = new Scanner(System.in);
	    System.out.print("Digite o valor para depositar: ");
	    valorDeposito = entrada.nextFloat();
	    System.out.println("O depósito foi de: " + valorDeposito);
	    saldo = saldo + valorDeposito;
    }

     public static void saque(){
        System.out.println("Você entrou no método saque.");
        float valorSaque;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o valor para retirar: ");
        valorSaque = entrada.nextFloat();
        System.out.println("O valor do saque foi de: " + valorSaque);
        saldo = saldo - valorSaque;
    }

     public static void consulta(){
        System.out.println("Você entrou no método consulta.");
        System.out.println(saldo);
    }

    public static void main(String[] args) {
    	 Scanner entrada = new Scanner(System.in);

        do{
            menu();
            opcao = entrada.nextInt();

            switch(opcao){
            case 1:
                deposito();
                break;

            case 2:
                saque();
                break;

            case 3:
                consulta();
                break;

            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }
}
