package com.zapateriaGina.zapateriaapi.controller;

import com.zapateriaGina.zapateriaapi.model.Usuario;
import com.zapateriaGina.zapateriaapi.model.Venta;
import com.zapateriaGina.zapateriaapi.repository.UsuarioRepository;
import com.zapateriaGina.zapateriaapi.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/venta")
public class VentaController {
    //////

    @Autowired
    VentaRepository ventaRepository;
    //Mostrar todos los elementos Venta
    @GetMapping()
    public ResponseEntity<Iterable<Venta>> findAll(){
        return ResponseEntity.ok(ventaRepository.findAll());
    }
    //Busqueda por ID (idVenta)
    @GetMapping ("/{idVenta}")
    public ResponseEntity<Venta> findById(@PathVariable String idVenta){
        Optional<Venta> ventaOptional = ventaRepository.findById(idVenta);
        if (ventaOptional.isPresent()){
            return ResponseEntity.ok(ventaOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //Crear nuevo elemento
    @PostMapping
    public ResponseEntity<Void> create (@RequestBody Venta newVenta, UriComponentsBuilder ucb){
        Venta savedVenta = ventaRepository.save(newVenta);
        URI uri = ucb
                .path("venta/{idVenta}")
                .buildAndExpand(savedVenta.getIdVenta())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    //Actualizar elemento
    @PutMapping("/{idVenta}")
    public ResponseEntity<Void> update (@PathVariable String idVenta, @RequestBody Venta ventaAct){
        Venta ventaAnt = ventaRepository.findById(idVenta).get();
        if (ventaAnt != null){
            ventaRepository.save(ventaAct);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Eliminar elemento por ID
    @DeleteMapping("/{idVenta}")
    public ResponseEntity<Void> delete(@PathVariable String idVenta){
        if(ventaRepository.findById(idVenta).get() != null){
            ventaRepository.deleteById(idVenta);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //////
}
