package br.univille.spring.boot.api.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.univille.spring.boot.api.rest.enums.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(length = 11, updatable=false, nullable=false, name="cadastropessoafisica", unique=true) 
	//anotações do java persistence para características das colunas no banco)
	private String cpf;
	
	@Column(length=50)
	private String name;
	
	@Temporal(TemporalType.DATE) //tem vários tipos temporais, nesse caso escolhemos dia
	private Date birthDate;

	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;
	
	private String email;
	
	private boolean livesWithTheRiskRange;
	
	@Embedded 
	//classe embarcada dentro de outra
	private DrivingLicense drivingLicence;
}
