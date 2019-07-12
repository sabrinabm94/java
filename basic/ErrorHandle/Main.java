package ErrorHandle;

public class Main {
	public static void main(String[] args) throws ErrorException {
		throwErrorException();
		throwErrorRuntimeException();
		cathError();
	}

	public static void cathError() {
		int i = 4;
		int j = 0;
		int x;

		try {
			x = i / j;
		}

		catch (ArithmeticException exception){
			System.out.println("Division by 0: " + exception);
		}

		catch (RuntimeException error) {
			System.out.println("Runtime Exception: " + error.getMessage());
		}

		catch (Exception error) {
			System.out.println("Exception: " + error.getMessage());
		}

		finally {
			System.out.println("Finally block: always run");
		}
	}

	public static void throwErrorException() throws ErrorException {
		throw new ErrorException("Exception");
	}

	public static void throwErrorRuntimeException() {
		throw new ErrorRuntimeException("Runtime Exception");
	}
}
