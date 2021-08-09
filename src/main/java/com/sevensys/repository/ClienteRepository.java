package com.sevensys.repository;

import com.sevensys.model.Cliente;
import com.sevensys.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Cliente deleteById(int id);
}