package java;

public class Airport {
	private String name;
	private int code;
	
	private City city = new City();
	
	public String getName() {
		return name;
	}
	
	public String setName() {
		return name;
	}
	
	public int getCode() {
		return code;
	}
	
	public int setCode() {
		return code;
	}
}
