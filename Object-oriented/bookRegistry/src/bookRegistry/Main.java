package bookRegistry;

public class Main {
	public static void main(String[] args) {
		ConnectionFactory C = new ConnectionFactory();

		Controller controller = new Controller();
		controller.initController();
	}
}
