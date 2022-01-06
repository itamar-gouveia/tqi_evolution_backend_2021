package com.tqi.loan.controller;

import java.util.List;

import com.tqi.loan.models.Tranche;
import com.tqi.loan.repository.TrancheRepository;

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
@RequestMapping(value="/tranches")
public class TrancheController {

    @Autowired
    TrancheRepository trancheRepository;

    @GetMapping("/all")
    public List<Tranche> listTranches(){
        return trancheRepository.findAll();
    }

  

    @PostMapping("/new")
    public Tranche saveTranche(@RequestBody Tranche tranche) {
        return trancheRepository.save(tranche);

    }

    @PutMapping("/update")
    public Tranche updateTranche(@RequestBody Tranche tranche) {
        return trancheRepository.save(tranche);

    }

    @DeleteMapping("/{id}")
    public void deleteTranche(@PathVariable Long id) {
        trancheRepository.deleteById(id);

    }


}
