package com.zapateriaGina.zapateriaapi.repository;

import com.zapateriaGina.zapateriaapi.model.Calzado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalzadoRepository extends CrudRepository<Calzado, Integer> {
}