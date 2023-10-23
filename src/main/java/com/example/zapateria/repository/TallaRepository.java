package com.example.zapateria.repository;

//import com.example.zapateria.model.Calzado;
//import com.example.zapateria.model.Usuario;
//import com.example.zapateria.model.Proveedores;
import com.example.zapateria.model.Talla;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TallaRepository extends CrudRepository<Talla, Integer> {
}