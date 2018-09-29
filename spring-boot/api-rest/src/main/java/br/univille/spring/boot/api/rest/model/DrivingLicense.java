package br.univille.spring.boot.api.rest.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.univille.spring.boot.api.rest.enums.DrivingCategory;
import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
@ApiModel
@Embeddable
public class DrivingLicense {
	@Temporal(TemporalType.DATE)
	private Date firstLicenseDate;

	@Enumerated(EnumType.STRING)
	private DrivingCategory drivingCategory;
	
	@Temporal(TemporalType.DATE)
	private Date licenseExpiration;
}
