package ErrorHandle;

public class Main {
	public static void main(String[] args) {
		int i = 4;
		int j = 0;
		int x;
		
		try {
			x = i/j;
		}
		
		catch (ArithmeticException a){
			System.out.println("Division by 0");
		}
		
		catch (Exception e) {
			System.out.println("ErrorHandle.Main: " + e.getMessage());
		}
		
		finally {
			System.out.println("Always run");
		}
	}
}
