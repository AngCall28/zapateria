package com.zapateriaGina.zapateriaapi.controller;

import com.zapateriaGina.zapateriaapi.model.Calzado;
import com.zapateriaGina.zapateriaapi.repository.CalzadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/calzado")
public class CalzadoController {
    @Autowired
    private CalzadoRepository calzadoRepository;

    @GetMapping()
    public ResponseEntity<Iterable<Calzado>> findAll(){
        return ResponseEntity.ok(calzadoRepository.findAll());
    }

    @GetMapping("/{idCalzado}")
    public ResponseEntity<Calzado> findById(@PathVariable Integer idCalzado) {
        Optional<Calzado> calzadoOptional = calzadoRepository.findById(idCalzado);
        if (!calzadoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(calzadoOptional.get());
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Calzado calzado, UriComponentsBuilder ucb){
        Calzado savedCalzado = calzadoRepository.save(calzado);
        URI uri = ucb
                .path("calzado/{idCalzado}")
                .buildAndExpand(savedCalzado.getIdCalzado())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("/{idCalzado}")
    public ResponseEntity<Void> update(@PathVariable Integer idCalzado, @RequestBody Calzado calzado){
        Optional<Calzado> calzadoOptional = calzadoRepository.findById(idCalzado);
        if( ! calzadoOptional.isPresent() ){
            return ResponseEntity.notFound().build();
        }
        calzado.setIdCalzado(calzadoOptional.get().getIdCalzado());
        calzadoRepository.save(calzado);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{idCalzado}")
    public ResponseEntity<Void> delete(@PathVariable Integer idCalzado){
        if(calzadoRepository.findById(idCalzado).get() == null){
            return ResponseEntity.notFound().build();
        }
        calzadoRepository.deleteById(idCalzado);
        return ResponseEntity.noContent().build();
    }
}