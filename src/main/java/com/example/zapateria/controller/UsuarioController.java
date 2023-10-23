package com.example.zapateria.controller;

import com.example.zapateria.model.Usuario;
import com.example.zapateria.repository.UsuarioRepository;

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
    private UsuarioRepository usuarioRepository;

    @GetMapping()
    public ResponseEntity<Iterable<Usuario>> findAll(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }
    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioOptional.get());
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Usuario usuario, UriComponentsBuilder ucb){
        Usuario savedUsuario = usuarioRepository.save(usuario);
        URI uri = ucb
                .path("usuario/{idUsuario}")
                .buildAndExpand(savedUsuario.getIdUsuario())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("/{idUsuario}")
    public ResponseEntity<Void> update(@PathVariable Integer idUsuario, @RequestBody Usuario usuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if( ! usuarioOptional.isPresent() ){
            return ResponseEntity.notFound().build();
        }
        usuario.setIdUsuario(usuarioOptional.get().getIdUsuario());
        usuarioRepository.save(usuario);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> delete(@PathVariable Integer idUsuario){
        if(usuarioRepository.findById(idUsuario).get() == null){
            return ResponseEntity.notFound().build();
        }
        usuarioRepository.deleteById(idUsuario);
        return ResponseEntity.noContent().build();
    }
}
