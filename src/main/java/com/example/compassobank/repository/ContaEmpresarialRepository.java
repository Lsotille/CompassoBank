package com.example.compassobank.repository;

import com.example.compassobank.entity.ContaEmpresarial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaEmpresarialRepository extends JpaRepository<ContaEmpresarial, Long> {
}
