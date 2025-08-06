package org.example.tienda.controlador.API;

import jakarta.validation.Valid;
import org.example.tienda.dto.producto.administrador.CrearProductoAdministradorDTO;
import org.example.tienda.dto.producto.administrador.EditarProductoAdministradorDTO;
import org.example.tienda.dto.usuario.administrador.CrearUsuarioDTO;
import org.example.tienda.dto.usuario.administrador.EditarUsuarioDTO;
import org.example.tienda.servicio.usuario.ServicioUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tienda/api/usuario")
public class ControladorUsuarioAPI {

    private final ServicioUsuario servicioUsuario;

    public ControladorUsuarioAPI(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarUsuarios() {
        return ResponseEntity.ok(servicioUsuario.listarUsuarios());
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearUsuarios(@RequestBody @Valid CrearUsuarioDTO crearUsuarioDTO) {
        return ResponseEntity.ok(servicioUsuario.crearUsuario(crearUsuarioDTO));
    }

    @PutMapping("/editar/id/{id}")
    public ResponseEntity<?>editarUsuarioPorId(@RequestBody @Valid EditarUsuarioDTO editarUsuarioDTO, @PathVariable Integer id) {
        return ResponseEntity.ok(servicioUsuario.editarUsuario(editarUsuarioDTO, id));
    }

    @GetMapping("/listar/id/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(servicioUsuario.obtenerUsuarioPorId(id));
    }

    @DeleteMapping("/eliminar/id/{id}")
    public ResponseEntity<?> eliminarUsuarioPorId(@PathVariable Integer id) {
        servicioUsuario.eliminarUsuario(id);
        return ResponseEntity.noContent().build(); // 204 sin body
    }

}
