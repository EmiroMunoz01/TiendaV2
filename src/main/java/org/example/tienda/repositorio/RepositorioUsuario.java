package org.example.tienda.repositorio;

import org.example.tienda.modelo.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {


    Optional<Usuario> findUsuarioByCedula(Integer cedula);

    void deleteUsuarioByCedula(Integer cedula);

}
