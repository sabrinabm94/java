package br.univille.spring.boot.api.rest.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import br.univille.spring.boot.api.rest.enums.Service;
import br.univille.spring.boot.api.rest.model.Provider;
import br.univille.spring.boot.api.rest.repository.ProviderRepository;

@RestController
@RequestMapping("provider")
public class ProviderController {
	@Autowired
	private ProviderRepository providerRepository;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello!";
	}
	
	@PostMapping("/save")
	public Provider save(Provider provider) {
		return providerRepository.saveAndFlush(provider);
	}
	
	@PostMapping("/save/{name}/{service}")
	public Provider save(
		@PathVariable("name") String name,
		@PathVariable("service") Service service) {
			Provider provider = new Provider();
			provider.setName(name);
			Set<Service> services = new HashSet();
			services.add(service);
			provider.setServices(services);
			return providerRepository.saveAndFlush(provider);
		}
	
	@GetMapping("/list")
	public List<Provider> list() {
		return providerRepository.findAll(); //lista de todos os fornecedores
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		providerRepository.deleteById(id);
		return ResponseEntity.ok("Registro excluido com sucesso!");
	}
	
	@PutMapping("/update")
	public Provider update(@RequestBody Provider provider) {
		return providerRepository.saveAndFlush(provider);
	}
}
