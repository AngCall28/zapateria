package com.zapateriaGina.zapateriaapi.controller;

import com.zapateriaGina.zapateriaapi.model.Historial;
import com.zapateriaGina.zapateriaapi.model.Usuario;
import com.zapateriaGina.zapateriaapi.repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/historial")
public class HistorialController {
    @Autowired
    HistorialRepository historialRepository;
    //Mostrar todos los elementos Historial
    @GetMapping()
    public ResponseEntity<Iterable<Historial>> findAll(){
        return ResponseEntity.ok(historialRepository.findAll());
    }
    //Busqueda por ID (idHistorial)
    @GetMapping ("/{idHistorial}")
    public ResponseEntity<Historial> findById(@PathVariable String idHistorial){
        Optional<Historial> historialOptional = historialRepository.findById(idHistorial);
        if (historialOptional.isPresent()){
            return ResponseEntity.ok(historialOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //Crear nuevo elemento
    @PostMapping
    public ResponseEntity<Void> create (@RequestBody Historial newHistorial, UriComponentsBuilder ucb){
        Historial savedHistorial = historialRepository.save(newHistorial);
        URI uri = ucb
                .path("historial/{idHistorial}")
                .buildAndExpand(savedHistorial.getIdHistorial())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    //Actualizar elemento
    @PutMapping("/{idHistorial}")
    public ResponseEntity<Void> update (@PathVariable String idHistorial, @RequestBody Historial historialAct){
        Historial historialAnt = historialRepository.findById(idHistorial).get();
        if (historialAnt != null){
            historialRepository.save(historialAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Eliminar elemento por ID
    @DeleteMapping("/{idHistorial}")
    public ResponseEntity<Void> delete(@PathVariable String idHistorial){
        if(historialRepository.findById(idHistorial).get() != null){
            historialRepository.deleteById(idHistorial);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
