package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.model.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    @Query("SELECT v FROM Aluno v WHERE v.cpf = ?1")
    Cliente recuperarAlunoPorCpf(String cpf);
}
