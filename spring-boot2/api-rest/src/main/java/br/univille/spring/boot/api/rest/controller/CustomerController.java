package br.univille.spring.boot.api.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.univille.spring.boot.api.rest.model.Customer;
import br.univille.spring.boot.api.rest.repository.CustomerRepository;

@RestController
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello!";
	}
	
	@PostMapping("/save")
	public Customer save(@RequestBody Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}
	
	@GetMapping("/list")
	public List<Customer> list() {
		return customerRepository.findAll(); //lista de todos os fornecedores
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		customerRepository.deleteById(id);
		return ResponseEntity.ok("Registro excluido com sucesso!");
	}
	
	@PutMapping("/update")
	public Customer update(@RequestBody Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}
}
