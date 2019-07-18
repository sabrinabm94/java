package br.univille.spring.boot.api.rest.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.univille.spring.boot.api.rest.enums.Coverage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Insurance {
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "customerid", referencedColumnName = "id")
	private Customer customer;

	@Embedded
	private Vehicle vehicle;
	
	@ElementCollection(targetClass = Coverage.class)
	@JoinTable(name = "insurance_coverage", joinColumns = @JoinColumn(name = "insurance_id"))
	@Column(name = "coverage", nullable = false)
	@Enumerated(EnumType.STRING)
	private Set<Coverage> coverages;
	
	private float insurancePrice;
	
	@Column(insertable = false)
	@Temporal(TemporalType.DATE)
	private Date contractBegin;
	
	@Column(insertable = false)
	@Temporal(TemporalType.DATE)
	private Date contractEnd;
}
