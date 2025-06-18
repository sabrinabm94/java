package br.univille.spring.boot.api.rest.service.proposal;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.spring.boot.api.rest.enums.Coverage;
import br.univille.spring.boot.api.rest.model.Customer;
import br.univille.spring.boot.api.rest.model.Insurance;
import br.univille.spring.boot.api.rest.model.Vehicle;
import br.univille.spring.boot.api.rest.repository.CustomerRepository;
import br.univille.spring.boot.api.rest.repository.InsuranceRepository;
import br.univille.spring.boot.api.rest.vo.ProposalVO;

@Service
public class ProposalService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private InsuranceRepository insuranceRepository;
	
	@Autowired
	private CoverageCalculationFactory factory;
	
	public Insurance calculate(ProposalVO proposal) {
		float insurancePrice = 0;
		for (Coverage coverage : proposal.getCoverages()) {
			insurancePrice += factory.build(coverage).calcute(proposal);
		}
		return save(proposal.getCustomer(),
				proposal.getVehicle(),
				proposal.getCoverages(),
				insurancePrice);
	}
	public Insurance save(Customer customer,
			Vehicle vehicle,
			Set<Coverage> coverages,
			float insurancePrice) {
		Customer existsCustomer = customerRepository.findByCpf(customer.getCpf());
		if(existsCustomer == null) {
			existsCustomer = customerRepository.save(customer);
		}
		
		Insurance insurance = Insurance.builder()
		.customer(existsCustomer)
		.vehicle(vehicle)
		.coverages(coverages)
		.insurancePrice(insurancePrice).build();
		
		return insuranceRepository.save(insurance);
	}
	
}
