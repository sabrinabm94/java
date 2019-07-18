package br.univille.spring.boot.api.rest.service.proposal.calculation;

import br.univille.spring.boot.api.rest.vo.ProposalVO;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class GlassCalculation extends CoverageCalculation {
	@Override
	float calculateValue(ProposalVO proposal) {
		int vehicleAge = (new Date().getYear()) - proposal.getVehicle().getAssemblyYear();
		
		float percent = 0;
		if (vehicleAge < 3) {
			percent = 0.03f;
		} else if (vehicleAge >= 3 && vehicleAge < 5) {
			percent = 0.02f;
		} else {
			percent = 0.01f;
		}
		return percent;
	}

	@Override
	float calculateVehiclePercent(ProposalVO proposal) {
		int vehicleAge = (new Date().getYear()) - proposal.getVehicle().getAssemblyYear();
		float percent = 0;
		if (vehicleAge < 3) {
			percent = 0.03f;
		} else if (vehicleAge >= 3 && vehicleAge < 5) {
			percent = 0.02f;
		} else {
			percent = 0.01f;
		}
		return percent * (calculateVehiclePercent(proposal));
	}
	
}
