package com.example.zapateria.repository;

import com.example.zapateria.model.Historial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends CrudRepository<Historial, Integer> {
}