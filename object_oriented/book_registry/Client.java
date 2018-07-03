package bookRegistry;

import java.sql.Date;

public class Client {
	private String name;
	private String user; //pensar em funo para validar caracteres especiais
	private String description;
	private String password;
	private Date birtDate;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setBirtDate(Date birtDate) {
		this.birtDate = birtDate;
	}
	
	public Date getBirtDate() {
		return birtDate;
	}
	
	public void userValidation(String user) {
		if (user.matches ("[!#@$%�&*0-9].*")) {
			System.out.println("Caracteres inv�lidos, tente novamente!");
			user = "";
		}
		
		//retirar
	}
}