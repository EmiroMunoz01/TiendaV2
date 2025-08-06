package org.example.tienda.servicio.usuario;

import java.util.List;

import org.example.tienda.dto.usuario.administrador.CrearUsuarioDTO;
import org.example.tienda.dto.usuario.administrador.EditarUsuarioDTO;
import org.example.tienda.dto.usuario.usuario.ObtenerUsuarioDTO;

public interface ImplementacionUsuario {

    //1 listar todos los usuarios
    public List<ObtenerUsuarioDTO> listarUsuarios();


    //2 obtener usuario por ID
    public ObtenerUsuarioDTO obtenerUsuarioPorId(Integer id);


    //3 Eliminar usuario, no tenemos retorno
    public void eliminarUsuario(Integer id);


    //4 Crearemos usuario
    public CrearUsuarioDTO crearUsuario(CrearUsuarioDTO usuario);


    //5 Actualizaremos usuario
    public EditarUsuarioDTO editarUsuario(EditarUsuarioDTO usuario, Integer id);
}
