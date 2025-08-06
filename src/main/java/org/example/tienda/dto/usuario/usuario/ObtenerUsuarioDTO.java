package org.example.tienda.dto.usuario.usuario;

import org.example.tienda.modelo.usuario.ROLE;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObtenerUsuarioDTO {

    private String nombre;

    private String direccion;

    private Integer cedula;

    private ROLE role;

}
