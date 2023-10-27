package com.zapateriaGina.zapateriaapi.repository;

import com.zapateriaGina.zapateriaapi.model.Talla;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TallaRepository extends CrudRepository<Talla, Integer> {
}