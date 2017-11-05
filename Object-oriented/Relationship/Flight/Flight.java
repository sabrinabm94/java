package java;
import java.util.Date;
import java.util.List;

public class Flight {
	private int number;
	private String status;
	private Date date;
	private List<Passenger> passengers;
	
	private Airplane airplane = new Airplane();
	
	public int getNumber() {
		return number;
	}
	
	public int setNumber() {
		return number;
	}
	
	public String setStatus() {
		return status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public Date getDate() {
		return date;
	}
	
	public Date setDate() {
		return date;
	}
	
	public List<Passenger> getPassenger() {
		return null;
	}
	
	public List<Passenger> setPassenger() {
		return null;
	}
}
