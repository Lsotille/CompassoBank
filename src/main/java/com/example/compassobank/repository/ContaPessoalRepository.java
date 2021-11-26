package com.example.compassobank.repository;


import com.example.compassobank.entity.ContaPessoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaPessoalRepository extends JpaRepository<ContaPessoal, Long> {
}
