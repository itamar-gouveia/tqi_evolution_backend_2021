package com.tqi.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tqi.loan.models.Client;

public interface ClientController extends JpaRepository<Client, Long>{

	
}
