package com.zapateriaGina.zapateriaapi.repository;

import com.zapateriaGina.zapateriaapi.model.Proveedores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoresRepository extends CrudRepository<Proveedores, Integer> {
}