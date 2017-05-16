import java.util.Scanner;

public class Menor {
	public static float numero1;
	public static float numero2;
	public static float numero3;
	public static float maior;
	
	public static void main(String[] args) {
		 Scanner entrada = new Scanner(System.in);
		 System.out.println("Digite um número: ");
		 numero1 = entrada.nextFloat();
		 
		 System.out.println("Digite outro número: ");
		 numero2 = entrada.nextFloat();
		 
		 System.out.println("Digite mais um número: ");
		 numero3 = entrada.nextFloat();
		 
		 if(numero1 > numero2){
			 maior = numero1;
		 }
		 
		 else {
			 maior = numero2;
		 }
		 
		 if(numero2 > numero1){
			 maior = numero2;
		 }
		 
		 else {
			 maior = numero1;
		 }
			 
		 if(numero1 > numero3){
			 maior = numero1;
		 }
		 
		 else {
			 maior = numero3;
		 }
		 
		 if(numero2 > numero3){
			 maior = numero2;
		 }
		 
		 else {
			 maior = numero3;
		 }
		
		 System.out.println("O maior é :" + maior);
	}

}
