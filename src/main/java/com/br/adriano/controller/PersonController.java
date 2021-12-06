package com.br.adriano.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.adriano.domain.dto.request.PersonRequest;
import com.br.adriano.domain.dto.request.PersonUpdateRequest;
import com.br.adriano.domain.dto.response.PersonResponse;
import com.br.adriano.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(value = "Person Endpoint", description = "Description for person", tags = { "Person Endpoint" })
@RestController
@RequestMapping("api/v1/person")
@AllArgsConstructor
public class PersonController {

	private PersonService personService;

	@ApiOperation(value = "find all people")
	@GetMapping
	public ResponseEntity<Page<PersonResponse>> listAllPerson() {
		return ResponseEntity.status(HttpStatus.OK).body(this.personService.listAllPerson());
	}

	@ApiOperation(value = "list person by cpf")
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<PersonResponse> listCpfPerson(@Valid @PathVariable("cpf") String cpf) {
		return ResponseEntity.status(HttpStatus.OK).body(this.personService.findByCpf(cpf));
	}

	@ApiOperation(value = "create new person")
	@PostMapping
	public ResponseEntity<PersonResponse> createNewPerson(@Valid @RequestBody PersonRequest personRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.personService.createNewPerson(personRequest));
	}

	@ApiOperation(value = "update person name")
	@PatchMapping("/{id}")
	public ResponseEntity<PersonResponse> updateNamePerson(@Valid @PathVariable Long personId,
			@RequestBody PersonUpdateRequest personUpdateRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(this.personService.updateNamePerson(personId, personUpdateRequest));
	}

	@ApiOperation(value = "delete person by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<PersonResponse> deleteByIdPerson(@Valid @PathVariable Long personId) {
		this.personService.deleteByIdPerson(personId);
		return ResponseEntity.ok().build();
	}
}
