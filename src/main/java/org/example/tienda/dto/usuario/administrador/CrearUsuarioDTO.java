package org.example.tienda.dto.usuario.administrador;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearUsuarioDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La direccion no puede estar vacío")
    private String direccion;

    @Min(value = 0, message = "La cedula debe ser mayor o igual a 0")
    private Integer cedula;


}
