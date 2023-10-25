package com.example.zapateria.controller;

import com.example.zapateria.model.Proveedores;
import com.example.zapateria.repository.ProveedoresRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/Proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @GetMapping()
    public ResponseEntity<Iterable<Proveedores>> findAll(){
        return ResponseEntity.ok(proveedoresRepository.findAll());
    }
    @GetMapping("/{idProveedor}")
    public ResponseEntity<Proveedores> findById(@PathVariable Integer idProveedor) {
        Optional<Proveedores> proveedoresOptional = proveedoresRepository.findById(idProveedor);
        if (!proveedoresOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(proveedoresOptional.get());
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Proveedores proveedores, UriComponentsBuilder ucb){
        Proveedores savedProveedores = proveedoresRepository.save(proveedores);
        URI uri = ucb
                .path("Proveedores/{idProveedor}")
                .buildAndExpand(savedProveedores.getIdProveedor())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("/{idProveedor}")
    public ResponseEntity<Void> update(@PathVariable Integer idProveedor, @RequestBody Proveedores proveedores){
        Optional<Proveedores> proveedoresOptional = proveedoresRepository.findById(idProveedor);
        if( !proveedoresOptional.isPresent() ){
            return ResponseEntity.notFound().build();
        }
        proveedores.setIdProveedor(proveedoresOptional.get().getIdProveedor());
        proveedoresRepository.save(proveedores);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{idProveedor}")
    public ResponseEntity<Void> delete(@PathVariable Integer idProveedor){
        if(proveedoresRepository.findById(idProveedor).get() == null){
            return ResponseEntity.notFound().build();
        }
        proveedoresRepository.deleteById(idProveedor);
        return ResponseEntity.noContent().build();
    }
}
