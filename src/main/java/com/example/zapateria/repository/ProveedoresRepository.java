package com.example.zapateria.repository;

//import com.example.zapateria.model.Calzado;
//import com.example.zapateria.model.Usuario;
import com.example.zapateria.model.Proveedores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoresRepository extends CrudRepository<Proveedores, Integer> {
}