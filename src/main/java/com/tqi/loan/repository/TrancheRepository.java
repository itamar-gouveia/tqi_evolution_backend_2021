package com.tqi.loan.repository;


import com.tqi.loan.models.Tranche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrancheRepository extends JpaRepository<Tranche, Long> {
}
