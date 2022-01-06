package com.tqi.loan.controller;

import com.tqi.loan.models.Client;
import com.tqi.loan.requests.ClientPostRequestBody;
import com.tqi.loan.requests.ClientPutRequestBody;
import com.tqi.loan.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/clients")
public class ClientController {
	
	@Autowired
	ClientService clientService;

	@GetMapping(path = "/all")
	@ApiOperation(value = "List all Clients")
	public ResponseEntity<Page<Client>> list(Pageable pageable){
		return ResponseEntity.ok(clientService.listAll(pageable));
	}

	@GetMapping(path = "/{id}")
	@ApiOperation(value = "Find client by Id")
	public ResponseEntity<Client> findById(@PathVariable long id){
		return ResponseEntity.ok(clientService.findById(id));
	}

	@PostMapping(path = "/new")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value="Save new Client")
	public ResponseEntity<Client> save(@RequestBody @Valid ClientPostRequestBody clientPostRequestBody){
		return  new ResponseEntity<>(clientService.save(clientPostRequestBody), HttpStatus.CREATED);
	}

	@PutMapping(path = "/update")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value="Update existing Client")
	public ResponseEntity<Void> update(@RequestBody ClientPutRequestBody clientPutRequestBody){
		clientService.update(clientPutRequestBody);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping(path = "/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value="Delete existing Client")
	public ResponseEntity<Void> delete(@PathVariable long id){
		clientService.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}	
