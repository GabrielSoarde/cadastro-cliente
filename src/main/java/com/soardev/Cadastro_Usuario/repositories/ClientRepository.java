package com.soardev.Cadastro_Usuario.repositories;


import com.soardev.Cadastro_Usuario.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
