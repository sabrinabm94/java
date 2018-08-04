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
	
	public void setNumber(int number) {
		this.number = number;
	}
		
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Passenger> getPassenger() {
		return null;
	}
	
	//verificar
	public List<Passenger> setPassenger() {
		return null;
	}
}
