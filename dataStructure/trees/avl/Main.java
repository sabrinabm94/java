package trees.avl;

public class Main {
	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();
		
		for(int i = 1; i <= 100; i++) {
			tree.add(i);
			
			tree.find(i);
			//contador adicionado + contador localizar
			System.out.println(tree.counterAdd + ";" + tree.counterFind);
		}
	}
}
