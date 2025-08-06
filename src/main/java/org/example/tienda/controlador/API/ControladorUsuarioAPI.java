package org.example.tienda.controlador.API;

import org.example.tienda.servicio.usuario.ServicioUsuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tienda/api/usuario")
public class ControladorUsuarioAPI {

    private final ServicioUsuario servicioUsuario;

    public ControladorUsuarioAPI(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;

    }




}
