package br.univille.spring.boot.api.rest.service.proposal.calculation;

import br.univille.spring.boot.api.rest.model.Vehicle;
import br.univille.spring.boot.api.rest.vo.ProposalVO;

public abstract class CoverageCalculation {

	public float calcute(ProposalVO proposal) {
		Vehicle vehicle = proposal.getVehicle();
		return calculateValue(proposal) + (calculateVehiclePercent(proposal) * vehicle.getPrice());
	}

	abstract float calculateValue(ProposalVO proposal);

	abstract float calculateVehiclePercent(ProposalVO proposal);

}
