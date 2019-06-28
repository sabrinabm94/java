import ordenacoes.Bubble;

public class BubbleSortMain2 extends ordenacoes.BubblePopulate {
	public static void main(String[] args) {
		ordenacoes.BubblePopulate bubblePopulate = new ordenacoes.BubblePopulate();
		ordenacoes.Bubble bubble = new Bubble();

		for(int n = 1; n < 1000; n++){
			int[] crescent = new int [n];
			int[] decrescent = new int [n];
			int[] random = new int [n];

			bubblePopulate.crescent(crescent);
			bubblePopulate.decreasing(decrescent);
			bubblePopulate.random(random);
			
			int crescentSort = bubble.sort(crescent);
			
			int descrescentSort = bubble.sort(decrescent);
			
			//minmax2r
			int randomSort = bubble.sort(random);

			System.out.println(n + ";" + crescentSort + ";" + descrescentSort + ";" + randomSort);
			//1;0;0;0;0;0
		}
	}
}