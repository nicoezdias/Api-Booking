package com.PI.ProyectoIntegrador.Controller;

import com.PI.ProyectoIntegrador.Exceptions.ResourceNotFoundException;
import com.PI.ProyectoIntegrador.Model.DTO.ProductoDto;
import com.PI.ProyectoIntegrador.Services.Impl.ProductoServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoServices productoServices;

    @Operation(summary = "Registramos un nuevo Producto")
    @PostMapping
    public ResponseEntity<ProductoDto> guardar(@RequestBody ProductoDto producto) {
        return ResponseEntity.ok(productoServices.guardar(producto));
    }

    @Operation(summary = "Traemos todos los Productos")
    @GetMapping
    public ResponseEntity<Set<ProductoDto>> buscarTodos(){
        return ResponseEntity.ok(productoServices.buscarTodas());
    }

    @Operation(summary = "Traemos el Productos por Id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> buscar(@PathVariable Long id) throws ResourceNotFoundException {
        ProductoDto producto = productoServices.buscar(id);

        return ResponseEntity.ok(producto);
    }

    @Operation(summary = "Eliminamos el Producto por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        productoServices.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminada");
    }

    @Operation(summary = "Actualizamos el Producto")
    @PutMapping()
    public ResponseEntity<ProductoDto> actualizar(@RequestBody ProductoDto producto) throws ResourceNotFoundException {
        ResponseEntity<ProductoDto> response = null;

        if (producto.getId() != null && productoServices.buscar(producto.getId()) != null)
            response = ResponseEntity.ok(productoServices.actualizar(producto));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
}
