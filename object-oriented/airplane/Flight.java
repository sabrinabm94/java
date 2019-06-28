import java.util.Date;
import java.util.List;

public class Flight {
	private int number;
	private String status;
	private Date date;
	private List<java.Passenger> passengers;
	
	private java.Airplane airplane = new java.Airplane();
	
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
	
	public List<java.Passenger> getPassenger() {
		return null;
	}
	
	//verificar
	public List<java.Passenger> setPassenger() {
		return null;
	}
}
