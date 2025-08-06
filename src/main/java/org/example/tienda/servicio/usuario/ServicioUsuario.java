package org.example.tienda.servicio.usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.example.tienda.dto.usuario.administrador.CrearUsuarioDTO;
import org.example.tienda.dto.usuario.administrador.EditarUsuarioDTO;
import org.example.tienda.dto.usuario.usuario.ObtenerUsuarioDTO;
import org.example.tienda.modelo.usuario.ROLE;
import org.example.tienda.modelo.usuario.Usuario;
import org.example.tienda.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicioUsuario implements ImplementacionUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    private ObtenerUsuarioDTO convertirUsuarioEnDTO(Usuario usuario) {

        ObtenerUsuarioDTO dtoResponse = new ObtenerUsuarioDTO();

        dtoResponse.setNombre(usuario.getNombre());
        dtoResponse.setDireccion(usuario.getDireccion());
        dtoResponse.setCedula(usuario.getCedula());
        dtoResponse.setRole(usuario.getRole());

        return dtoResponse;
    }

    @Override
    public List<ObtenerUsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = repositorioUsuario.findAll();

        return usuarios.stream()
                .map(this::convertirUsuarioEnDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ObtenerUsuarioDTO obtenerUsuarioPorId(Integer id) {
        Usuario buscarUsuario = repositorioUsuario.findById(id).orElseThrow(()
                -> new EntityNotFoundException(String.format("No se encontró usuario con el id: %s", id)));
        return convertirUsuarioEnDTO(buscarUsuario);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        repositorioUsuario.deleteById(id);
    }

    @Override
    public CrearUsuarioDTO crearUsuario(CrearUsuarioDTO usuario) {

        Optional<Usuario> buscarUsuario = repositorioUsuario.findUsuarioByCedula(usuario.getCedula());

        if (buscarUsuario.isPresent()) {
            throw new IllegalArgumentException("El usuario con la cedula: ---" + usuario.getCedula() + "--- ya existe en la base de datos");
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCedula(usuario.getCedula());
        nuevoUsuario.setNombre(usuario.getNombre());
        nuevoUsuario.setDireccion(usuario.getDireccion());
        nuevoUsuario.setRole(ROLE.USER);

        repositorioUsuario.save(nuevoUsuario);

        return usuario;

    }

    @Override
    public EditarUsuarioDTO editarUsuario(EditarUsuarioDTO usuario, Integer id) {

        Usuario buscarUsuario  = repositorioUsuario.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario con el id " + id + " no existe."));

        buscarUsuario.setNombre(usuario.getNombre());
        buscarUsuario.setDireccion(usuario.getDireccion());
        buscarUsuario.setCedula(usuario.getCedula());

        repositorioUsuario.save(buscarUsuario);

        return usuario;
        
    }
}
