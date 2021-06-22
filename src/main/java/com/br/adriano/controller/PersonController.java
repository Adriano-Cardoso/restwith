package com.br.adriano.controller;

import java.util.List;

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
@RequestMapping("api/v1/person/")
@AllArgsConstructor
public class PersonController {

	private PersonService service;

	@ApiOperation(value = "find all people")
	@GetMapping
	public ResponseEntity<List<PersonResponse>> listAllPerson() {
		return ResponseEntity.ok(this.service.listAllPerson());
	}

	@ApiOperation(value = "list person by cpf")
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<PersonResponse> listCpfPerson(@PathVariable("cpf") String cpf) {
		return ResponseEntity.ok(this.service.findByCpf(cpf));
	}

	@ApiOperation(value = "create new person")
	@PostMapping
	public ResponseEntity<PersonResponse> createNewPerson(@RequestBody PersonRequest request) {
		return ResponseEntity.ok(this.service.createNewPerson(request));
	}

	@ApiOperation(value = "update person name")
	@PatchMapping("/{id}")
	public ResponseEntity<PersonResponse> updateNamePerson(@PathVariable Long id,
			@RequestBody PersonUpdateRequest request) {
		return ResponseEntity.ok(this.service.updateNamePerson(id, request));
	}

	@ApiOperation(value = "delete person by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<PersonResponse> deleteByIdPerson(@PathVariable Long id) {
		this.service.deleteByIdPerson(id);
		return ResponseEntity.ok().build();
	}
}
