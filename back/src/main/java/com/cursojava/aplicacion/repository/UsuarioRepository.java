package com.cursojava.aplicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cursojava.aplicacion.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
