package com.zapateriaGina.zapateriaapi.repository;

import com.zapateriaGina.zapateriaapi.model.Venta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends CrudRepository <Venta, String>{

}
