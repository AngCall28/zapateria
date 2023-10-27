package com.zapateriaGina.zapateriaapi.controller;

import com.zapateriaGina.zapateriaapi.model.Talla;
import com.zapateriaGina.zapateriaapi.repository.TallaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/Talla")
public class TallaController {

    @Autowired
    private TallaRepository tallaRepository;

    @GetMapping()
    public ResponseEntity<Iterable<Talla>> findAll(){
        return ResponseEntity.ok(tallaRepository.findAll());
    }
    @GetMapping("/{idTalla}")
    public ResponseEntity<Talla> findById(@PathVariable Integer idTalla) {
        Optional<Talla> tallaOptional = tallaRepository.findById(idTalla);
        if (!tallaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tallaOptional.get());
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Talla talla, UriComponentsBuilder ucb){
        Talla savedTalla = tallaRepository.save(talla);
        URI uri = ucb
                .path("Talla/{idTalla}")
                .buildAndExpand(savedTalla.getIdTalla())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("/{idTalla}")
    public ResponseEntity<Void> update(@PathVariable Integer idTalla, @RequestBody Talla talla){
        Optional<Talla> tallaOptional = tallaRepository.findById(idTalla);
        if( !tallaOptional.isPresent() ){
            return ResponseEntity.notFound().build();
        }
        talla.setIdTalla(tallaOptional.get().getIdTalla());
        tallaRepository.save(talla);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{idTalla}")
    public ResponseEntity<Void> delete(@PathVariable Integer idTalla){
        if(tallaRepository.findById(idTalla).get() == null){
            return ResponseEntity.notFound().build();
        }
        tallaRepository.deleteById(idTalla);
        return ResponseEntity.noContent().build();
    }
}