package com.example.zapateria.repository;

import com.example.zapateria.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
}
