package br.univille.spring.boot.api.rest.service.proposal.calculation;

import org.springframework.stereotype.Component;

import br.univille.spring.boot.api.rest.vo.ProposalVO;

@Component
public class ThirdPartyCalculation extends TotalLossCalculation {

	@Override
	public float calcute(ProposalVO proposal) {
		return super.calcute(proposal) / 2;
	}

}
