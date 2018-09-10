package br.com.sabrina.api.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity  //estrutura de mapeamento de objeto relacional
@Table(name="Provider")
public class ProviderModel {  
	//correspondente a tabela Provider do banco de dados
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int provider_id;
	
	@Column(name="name")
	String name;
	
	@Column(name="cpf_cnpj")
	String cpf_cnpj;
	
	@Column(name="rg")
	String rg;
	
	@Column(name="address")
	String adress;
	
	@Column(name="city")
	String city;
	
	@Column(name="email")
	String email;
	
	@Column(name="register_date")
	@Temporal(TemporalType.TIMESTAMP)
	Date register_date;
	
	public int getId() {
		return provider_id;
	}
	
	public void setId(int provider_id) {
		this.provider_id = provider_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}