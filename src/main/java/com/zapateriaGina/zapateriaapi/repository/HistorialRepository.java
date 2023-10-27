package com.zapateriaGina.zapateriaapi.repository;

import com.zapateriaGina.zapateriaapi.model.Historial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends CrudRepository <Historial, String> {
}
