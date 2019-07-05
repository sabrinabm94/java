package br.univille.spring.boot.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.spring.boot.api.rest.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{ //generics
	//herda muitos métodos do jpa repository
	
}
