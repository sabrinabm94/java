package br.univille.spring.boot.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.univille.spring.boot.api.rest.model.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
	@Query("from Insurance where customer.cpf = :cpf and vehicle.plate = :plate")
	Insurance findInsurance (String cpf, String plate);
}

