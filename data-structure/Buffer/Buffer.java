package buffer;

public class Buffer {
private double value = 0;
private boolean verify;
	public synchronized double get() {
		return value;
	}
	public synchronized void put(double value) {
		this.value =  value;
		
		
	}
	public synchronized boolean verify() {
		return value != 0;
	}
}
