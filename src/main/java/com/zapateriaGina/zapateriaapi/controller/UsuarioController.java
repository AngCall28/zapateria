package com.zapateriaGina.zapateriaapi.controller;

import com.zapateriaGina.zapateriaapi.model.Usuario;
import com.zapateriaGina.zapateriaapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    //Mostrar todos los elementos Usuario
    @GetMapping()
    public ResponseEntity<Iterable<Usuario>> findAll(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }
    //Busqueda por ID (idUsuario)
    @GetMapping ("/{idUsuario}")
    public ResponseEntity<Usuario> findById(@PathVariable String idUsuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if (usuarioOptional.isPresent()){
            return ResponseEntity.ok(usuarioOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //Crear nuevo elemento
    @PostMapping
    public ResponseEntity<Void> create (@RequestBody Usuario newUsuario, UriComponentsBuilder ucb){
        Usuario savedUsuario = usuarioRepository.save(newUsuario);
        URI uri = ucb
                .path("usuario/{idUsuario}")
                .buildAndExpand(savedUsuario.getIdUsuario())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    //Actualizar elemento
    @PutMapping("/{idUsuario}")
    public ResponseEntity<Void> update (@PathVariable String idUsuario, @RequestBody Usuario usuarioAct){
        Usuario usuarioAnt = usuarioRepository.findById(idUsuario).get();
        if (usuarioAnt != null){
           usuarioRepository.save(usuarioAct);
           return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Eliminar elemento por ID
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> delete(@PathVariable String idUsuario){
        if(usuarioRepository.findById(idUsuario).get() != null){
            usuarioRepository.deleteById(idUsuario);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
