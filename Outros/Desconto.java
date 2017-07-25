import java.util.Scanner;

public class Desconto {
	public static int opcao;
	public static float valor;
	public static float desconto;
	public static float valorDescont;
	public static float valorDescontFinal;
	
	public static float [] listaDesconto = {0, 5, 10, 20, 40};
	
	public static void main(String[] args) {
		 System.out.println("Digite o valor: ");
		 Scanner entrada = new Scanner(System.in);
		 valor = entrada.nextFloat();
		 
		 System.out.println("Escolha a opção do desconto: 1 para 5%, 2 para 10%, 3 para 20%, e 4 para 50%");
		 opcao = entrada.nextInt();
		 System.out.println("Você escolheu a opção: " + opcao);
		 
		 desconto = (listaDesconto[opcao]) * 100;
		 valorDescont = (valor * 100) - desconto;
		 valorDescontFinal = valorDescont / 100;
		 System.out.println("O valor final do produto é: " + valorDescontFinal);
	}

}
