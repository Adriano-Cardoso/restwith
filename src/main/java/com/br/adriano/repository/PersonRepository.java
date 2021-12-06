package com.br.adriano.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.adriano.domain.Person;
import com.br.adriano.domain.dto.response.PersonResponse;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("select new com.br.adriano.domain.dto.response.PersonResponse("
			+ "p.personId,"
			+ " p.firstName,"
			+ " p.lastName,"
			+ " p.cpf, "
			+ "p.address,"
			+ " p.gender,"
			+ " p.bookId)"
			+ " From Person p where p.cpf=:cpf")
	Optional<PersonResponse> findByCpf(@Param("cpf") String cpf);

	@Query("select new com.br.adriano.domain.dto.response.PersonResponse("
			+ "p.personId,"
			+ " p.firstName,"
			+ " p.lastName,"
			+ " p.cpf, "
			+ "p.address,"
			+ " p.gender,"
			+ " p.bookId)"
			+ " From Person p")
	Page<PersonResponse> listAllPerson(Pageable page);
}
