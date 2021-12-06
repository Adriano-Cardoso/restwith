package com.br.adriano.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.br.adriano.domain.Book;
import com.br.adriano.domain.Person;
import com.br.adriano.domain.dto.request.PersonRequest;
import com.br.adriano.domain.dto.request.PersonUpdateRequest;
import com.br.adriano.domain.dto.response.PersonResponse;
import com.br.adriano.repository.PersonRepository;
import com.br.adriano.validation.Message;
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

	private BookService bookService;

	@Validated(OnCreate.class)
	public PersonResponse createNewPerson(@Valid PersonRequest personRequest) {

		Book book = this.bookService.findById(personRequest.getBookId());

		this.repository.findByCpf(personRequest.getCpf()).ifPresent(p -> {
			throw Message.PERSON_EXIST.asBusinessException();
		});

		Person person = Person.of(personRequest);

		person.addBook(book);

		this.repository.save(person);
		log.info("method=createNewPerson id={}", person.toString());

		return person.toDto();
	}

	@Transactional
	@Validated(OnUpdate.class)
	public PersonResponse updateNamePerson(Long personId, PersonUpdateRequest personUpdateRequest) {
		Person person = this.repository.findById(personId)
				.orElseThrow(() -> Message.NOT_FOUND_ID_PERSON.asBusinessException());

		person.updatePerson(personUpdateRequest);

		log.info("method=updateNamePerson id={}", person.toString());

		return person.toDto();

	}

	public Page<PersonResponse> listAllPerson() {
		log.info("method=listAllPerson");

		int limit = 3;
		int page = 0;

		Pageable pageable = PageRequest.of(page, limit);

		log.info("method=listAllPerson limit{}", limit);
		return this.repository.listAllPerson(pageable);
	}

	public void deleteByIdPerson(Long personId) {

		Person person = this.repository.findById(personId)
				.orElseThrow(() -> Message.NOT_FOUND_ID_PERSON.asBusinessException());

		log.info("method=findByCpf findByCpf={}", personId);
		this.repository.delete(person);

	}

	public PersonResponse findByCpf(String cpf) {

		log.info("method=findByCpf findByCpf={}", cpf);
		return this.repository.findByCpf(cpf).orElseThrow(() -> Message.NOT_FOUND_ID_PERSON.asBusinessException());

	}

}
