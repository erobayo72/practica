package com.cursojava.aplicacion.service.interf;

import java.util.List;
import java.util.Optional;
import com.cursojava.aplicacion.entity.Usuario;

public interface UsuarioService {
    
    public List<Usuario> findAll();

    public Optional<Usuario> findById(Long id);

    public Usuario save(Usuario usuario);

    public void delete(Long id);

}
