package com.br.adriano.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.br.adriano.domain.Person;
import com.br.adriano.domain.dto.request.PersonRequest;
import com.br.adriano.domain.dto.request.PersonUpdateRequest;
import com.br.adriano.domain.dto.response.PersonResponse;
import com.br.adriano.exception.IdNotFoundException;
import com.br.adriano.exception.PersonCpfResourceExistingException;
import com.br.adriano.exception.PersonCpfResourceNotFoundException;
import com.br.adriano.repository.PersonRepository;
import com.br.adriano.validation.OnCreate;
import com.br.adriano.validation.OnUpdate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@AllArgsConstructor
@Slf4j
@Validated
@Service("PersonService")
public class PersonService {
	
	private PersonRepository repository;
	
	
	
	@Validated(OnCreate.class)
	public PersonResponse createNewPerson(PersonRequest request) {
		this.repository.findByCpf(request.getCpf()).ifPresent(p -> {throw new PersonCpfResourceExistingException("O cpf já existe");});
		
		Person person = Person.of(request);
		
		this.repository.save(person);
		log.info("method=createNewPerson id={}", person.getId());
		
		return person.toDto();
	}
	
	@Transactional
	@Validated(OnUpdate.class)
	public PersonResponse updateNamePerson(Long id, PersonUpdateRequest request) {
		Person person = this.repository.findById(id).orElseThrow(() -> new IdNotFoundException("O id informado não existe " + id));
		
		person.updatePerson(request);
		
		log.info("method=updateNamePerson id={}", person.getId());
		
		return person.toDto();
		
	}
	
	public List<PersonResponse> listAllPerson(){
		log.info("method=listAllPerson");
		return this.repository.listAllPerson();
	}
	
	
	public void deleteByIdPerson(Long id) {
		Person person = this.repository.findById(id).orElseThrow(() -> new IdNotFoundException("O id informado não existe " + id));
		log.info("method=findByCpf findByCpf={}", id);
		this.repository.delete(person);
		
	}

	public PersonResponse findByCpf(String cpf) {
		log.info("method=findByCpf findByCpf={}", cpf);
		return this.repository.findByCpf(cpf).orElseThrow(() -> new PersonCpfResourceNotFoundException("O cpf informado não existe "+ cpf));
		
	}
	
	

}
