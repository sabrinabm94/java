package br.univille.spring.boot.api.rest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.spring.boot.api.rest.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{ //generics
	//herda muitos métodos do jpa repository
	Customer findByCpf(String cpf);
}
