package buffer;

public class Consumidor extends Thread {
	private Buffer buffer;
	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}
	public void run() {
		while(true) {
			buffer.get(); 
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} 
}
