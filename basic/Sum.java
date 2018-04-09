public class Sum {
	public static void main(String[] args) {
		int start = 0;
		int end = 1000;
		for(start = 0; start < end; start++){
			System.out.print(start += start);
		}
	}
}
