package com.example.zapateria.repository;

import com.example.zapateria.model.Talla;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TallaRepository extends CrudRepository<Talla, Integer> {
}