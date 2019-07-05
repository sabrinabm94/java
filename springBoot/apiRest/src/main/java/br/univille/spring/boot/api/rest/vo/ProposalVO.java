package br.univille.spring.boot.api.rest.vo;

import java.util.Set;
import br.univille.spring.boot.api.rest.enums.Coverage;
import br.univille.spring.boot.api.rest.model.Customer;
import br.univille.spring.boot.api.rest.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProposalVO {
	private Customer customer;
	private Vehicle vehicle;
	private Set<Coverage> coverages;
}
