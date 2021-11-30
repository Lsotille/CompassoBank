package com.example.compassobank.repository;

import com.example.compassobank.entity.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    Optional<Associado> findbyCpf(String cpf);

    Optional<Associado> findbyCnpj(String username);
}
