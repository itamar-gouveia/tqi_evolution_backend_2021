package com.tqi.loan.controller;

import com.tqi.loan.models.Client;
import com.tqi.loan.requests.ClientPostRequestBody;
import com.tqi.loan.requests.ClientPutRequestBody;
import com.tqi.loan.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/clients")
public class ClientController {
	
	@Autowired
	ClientService clientService;

	@GetMapping("/all")
	@ApiOperation(value = "List all Clients")
	public ResponseEntity<List<Client>> list(){
		return ResponseEntity.ok(clientService.listAll());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Find client by Id")
	public ResponseEntity<Client> findById(@PathVariable long id){
		return ResponseEntity.ok(clientService.findById(id));
	}

	@PostMapping("/new")
	@ApiOperation(value="Save new Client")
	public ResponseEntity<Client> save(@RequestBody @Valid ClientPostRequestBody clientPostRequestBody){
		return  new ResponseEntity<>(clientService.save(clientPostRequestBody), HttpStatus.CREATED);
	}

	@PutMapping("/update")
	@ApiOperation(value="Update existing Client")
	public ResponseEntity<Void> update(@RequestBody ClientPutRequestBody clientPutRequestBody){
		clientService.update(clientPutRequestBody);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value="Delete existing Client")
	public ResponseEntity<Void> delete(@PathVariable long id){
		clientService.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}	
