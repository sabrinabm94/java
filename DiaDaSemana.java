// Crie uma classe DiaDaSemana.java que imprime em tela o dia da
// semana por extenso conforme o código informado pelo usuário. O código
// deve ser um valor entre 1 à 7. Por exemplo, o código 1 representa
// Domingo, 2 representa Segunda-Feira, assim por diante.
// Exemplo de Saída:
// Informe o código do dia da semana : 3
// Dia da Semana selecionado: Terça-Feira

import java.util.Scanner;

public class DiaDaSemana {
	public static int dia;
    // public static dias = new int[8];
    public static String [] dias = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite um número equivalente ao dia que deseja ver: ");
        dia = entrada.nextInt();
        System.out.print(dias[dia - 1]);
       
    }
}