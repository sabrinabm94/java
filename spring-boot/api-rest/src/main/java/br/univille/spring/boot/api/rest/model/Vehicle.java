package br.univille.spring.boot.api.rest.model;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Vehicle {
	private int assemblyYear;
	private String plate;
	private float price;
}
