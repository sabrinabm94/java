package trees;

import java.util.List;

public class Node<T> {
	Node<T> Parent;
	List<Node<T>> Children;
	T value;
}
