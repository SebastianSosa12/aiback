package com.example.aifinalback.repositorios;

import com.example.aifinalback.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository <Cliente,Integer> {

}
