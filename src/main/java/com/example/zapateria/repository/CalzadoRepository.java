package com.example.zapateria.repository;

import com.example.zapateria.model.Calzado;
//import com.example.zapateria.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalzadoRepository extends CrudRepository<Calzado, Integer> {
}