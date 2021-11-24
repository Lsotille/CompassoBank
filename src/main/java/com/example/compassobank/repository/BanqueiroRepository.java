package com.example.compassobank.repository;

import com.example.compassobank.entity.Banqueiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanqueiroRepository extends JpaRepository<Banqueiro, Long> {
}
