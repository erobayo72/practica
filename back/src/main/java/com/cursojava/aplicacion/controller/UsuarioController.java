package com.cursojava.aplicacion.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cursojava.aplicacion.entity.Usuario;
import com.cursojava.aplicacion.service.interf.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> read(){
        return ResponseEntity.ok(usuarioService.findAll());
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable(value="id") Long id){
        Optional<Usuario> usuario = usuarioService.findById(id);
        if(usuario.isPresent()){
            return ResponseEntity.ok(usuario);
        } 
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CONTINUE).body(usuarioService.save(usuario));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Long id){
        Optional<Usuario> usuario = usuarioService.findById(id);
        if(usuario.isPresent()){
            usuarioService.delete(id);
            return ResponseEntity.ok(null);
        } 
        return ResponseEntity.notFound().build();
    }
    
}
