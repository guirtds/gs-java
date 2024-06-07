package com.example.beachcoins.repository;

import com.example.beachcoins.model.Ecoponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcopontoRepository extends JpaRepository<Ecoponto, Long> {
}
