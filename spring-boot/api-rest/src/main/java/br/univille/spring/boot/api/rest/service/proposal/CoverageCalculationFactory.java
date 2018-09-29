package br.univille.spring.boot.api.rest.service.proposal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.univille.spring.boot.api.rest.enums.Coverage;
import br.univille.spring.boot.api.rest.service.proposal.calculation.AssistanceCalculation;
import br.univille.spring.boot.api.rest.service.proposal.calculation.BackupCarCalculation;
import br.univille.spring.boot.api.rest.service.proposal.calculation.CoverageCalculation;
import br.univille.spring.boot.api.rest.service.proposal.calculation.GlassCalculation;
import br.univille.spring.boot.api.rest.service.proposal.calculation.ThirdPartyCalculation;
import br.univille.spring.boot.api.rest.service.proposal.calculation.TotalLossCalculation;

@Component
public class CoverageCalculationFactory {

	@Autowired
	private TotalLossCalculation totalLossCalculation;

	@Autowired
	private BackupCarCalculation backupCarCalculation;

	@Autowired
	private ThirdPartyCalculation thirdPartyCalculation;
	
	@Autowired
	private GlassCalculation glassCalculation;
	
	@Autowired
	private AssistanceCalculation assistanceCalculation;

	public CoverageCalculation build(Coverage coverage) {
		switch (coverage) {
		case TOTAL_LOSS:
			return totalLossCalculation;
		case BACKUP_CAR:
			return backupCarCalculation;
		case THIRDY_PARTY:
			return thirdPartyCalculation;
		case GLASS:
			return glassCalculation;
		case ASSISTANCE:
			return assistanceCalculation;
		default:
			break;
		}
		return null;
	}
}
