package com.tqi.loan.controller;

import java.util.List;

import com.tqi.loan.models.Client;
import com.tqi.loan.repository.ClientRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/clients")
public class ClientController {
	
	@Autowired
	ClientRepository clientRepository;
	
	@GetMapping("/all")
	@ApiOperation(value="List all clients")
	@ApiResponses({
			@ApiResponse(code= 200, message= "List all clients successfully "),
			@ApiResponse(code= 401, message= "Authentication failed")

	})
	public List<Client> listclients(){
		return clientRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="List client by Id")
	public Client listClientId(@PathVariable  Long id) {
		return clientRepository.findById(id).get();
		}


	@PostMapping("/new")
	@ApiOperation(value="Save a new client")
	public Client salveClient(@RequestBody Client client) {
		return clientRepository.save(client);
		
	}
	
	@PutMapping("/update")
	@ApiOperation(value="Update data of client")
	public Client updateClient(@RequestBody Client client) {
		return clientRepository.save(client);
		
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Delete client by id")
	public void deletarCliente(@PathVariable Long id) {
		clientRepository.deleteById(id);
		
	}
	
	
}	
