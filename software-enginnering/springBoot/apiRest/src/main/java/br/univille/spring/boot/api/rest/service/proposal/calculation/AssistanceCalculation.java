package br.univille.spring.boot.api.rest.service.proposal.calculation;

import org.springframework.stereotype.Component;

import br.univille.spring.boot.api.rest.model.Vehicle;
import br.univille.spring.boot.api.rest.vo.ProposalVO;

@Component
public class AssistanceCalculation extends CoverageCalculation {
	@Override
	float calculateValue(ProposalVO proposal) {
		Vehicle vehicle = proposal.getVehicle();
		return calculateValue(proposal) * vehicle.getPrice();
	}

	@Override
	float calculateVehiclePercent(ProposalVO proposal) {
		return calculateValue(proposal) * (calculateVehiclePercent(proposal));
	}
	
}
