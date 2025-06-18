package trees.avl;

import javaRepositories.Print;

public class Main {
	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();
		
		for(int i = 1; i <= 100; i++) {
			tree.add(i);
			tree.find(i);
			Print.print(tree.counterAdd + ";" + tree.counterFind);
		}
	}
}
