package com.tqi.loan.controller;

import java.util.List;

import com.tqi.loan.models.Client;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value="/customers")
public class ClientController {
	
	@Autowired
	com.tqi.loan.repository.ClientController customerRepository;
	
	@GetMapping("/all")
	@ApiOperation(value="list all Customers")
	public List<Client> listCustomers(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="list Customer  ")
	public Client listCustomerId(@PathVariable  Long id) {
		return customerRepository.findById(id).get();
		}


	@PostMapping("/new")
	public Client salveCustomer(@RequestBody Client customer) {
		return customerRepository.save(customer);
		
	}
	
	@PutMapping("/update")
	public Client updateCustomer(@RequestBody Client customer) {
		return customerRepository.save(customer);
		
	}
	
	@DeleteMapping("/{id}")
	public void deletarCliente(@PathVariable Long id) {
		customerRepository.deleteById(id);
		
	}
	
	
}	
