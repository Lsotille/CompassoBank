package com.example.compassobank.repository;

import com.example.compassobank.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
