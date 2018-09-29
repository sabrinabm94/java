package br.univille.spring.boot.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.univille.spring.boot.api.rest.model.Insurance;
import br.univille.spring.boot.api.rest.service.proposal.ProposalService;
import br.univille.spring.boot.api.rest.vo.ProposalVO;

@RestController
@RequestMapping("proposal")
public class ProposalController {
	@Autowired
	ProposalService proposalService;
	
	@PostMapping("/calculate")
	public Insurance calculate(@RequestBody ProposalVO proposal) {
		return proposalService.calculate(proposal);
	}	
}
