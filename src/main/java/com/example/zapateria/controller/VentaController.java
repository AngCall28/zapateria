package com.example.zapateria.controller;

import com.example.zapateria.model.Venta;
import com.example.zapateria.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

    @CrossOrigin(origins = "http://localhost:3000")
    @RestController
    @RequestMapping("/venta")
    public class VentaController {
        @Autowired
        private VentaRepository ventaRepository;

        @GetMapping()
        public ResponseEntity<Iterable<Venta>> findAll(){
            return ResponseEntity.ok(ventaRepository.findAll());
        }

        @GetMapping("/{idVenta}")
        public ResponseEntity<Venta> findById(@PathVariable Integer idVenta) {
            Optional<Venta> ventaOptional = ventaRepository.findById(idVenta);
            if (!ventaOptional.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(ventaOptional.get());
        }
        @PostMapping
        public ResponseEntity<Void> create(@RequestBody Venta venta, UriComponentsBuilder ucb){
            Venta savedVenta = ventaRepository.save(venta);
            URI uri = ucb
                    .path("venta/{idVenta}")
                    .buildAndExpand(savedVenta.getIdVenta())
                    .toUri();
            return ResponseEntity.created(uri).build();
        }
        @PutMapping("/{idVenta}")
        public ResponseEntity<Void> update(@PathVariable Integer idVenta, @RequestBody Venta venta){
            Optional<Venta> ventaOptional = ventaRepository.findById(idVenta);
            if( ! ventaOptional.isPresent() ){
                return ResponseEntity.notFound().build();
            }
            venta.setIdVenta(ventaOptional.get().getIdVenta());
            ventaRepository.save(venta);
            return ResponseEntity.noContent().build();
        }
        @DeleteMapping("/{idVenta}")
        public ResponseEntity<Void> delete(@PathVariable Integer idVenta){
            if(ventaRepository.findById(idVenta).get() == null){
                return ResponseEntity.notFound().build();
            }
            ventaRepository.deleteById(idVenta);
            return ResponseEntity.noContent().build();
        }
}
