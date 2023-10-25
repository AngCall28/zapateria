package com.example.zapateria.controller;

import com.example.zapateria.model.Historial;
import com.example.zapateria.repository.HistorialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/Historial")
public class HistorialController {

    @Autowired
    private HistorialRepository historialRepository;

    @GetMapping()
    public ResponseEntity<Iterable<Historial>> findAll(){
        return ResponseEntity.ok(historialRepository.findAll());
    }
    @GetMapping("/{idHistorial}")
    public ResponseEntity<Historial> findById(@PathVariable Integer idHistorial) {
        Optional<Historial> historialOptional = historialRepository.findById(idHistorial);
        if (!historialOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(historialOptional.get());
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Historial historial, UriComponentsBuilder ucb){
        Historial savedHistorial = historialRepository.save(historial);
        URI uri = ucb
                .path("Historial/{idHistorial}")
                .buildAndExpand(savedHistorial.getIdHistorial())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("/{idHistorial}")
    public ResponseEntity<Void> update(@PathVariable Integer idHistorial, @RequestBody Historial historial){
        Optional<Historial> historialOptional = historialRepository.findById(idHistorial);
        if( !historialOptional.isPresent() ){
            return ResponseEntity.notFound().build();
        }
        historial.setIdHistorial(historialOptional.get().getIdHistorial());
        historialRepository.save(historial);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{idHistorial}")
    public ResponseEntity<Void> delete(@PathVariable Integer idHistorial){
        if(historialRepository.findById(idHistorial).get() == null){
            return ResponseEntity.notFound().build();
        }
        historialRepository.deleteById(idHistorial);
        return ResponseEntity.noContent().build();
    }
}