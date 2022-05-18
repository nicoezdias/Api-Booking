package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.ProductoDto;
import com.PI.apiBooking.Services.Impl.ProductoServices;
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

    @Operation(summary = "Guardar Producto")
    @PostMapping
    public ResponseEntity<ProductoDto> guardar(@RequestBody ProductoDto producto) {
        return ResponseEntity.ok(productoServices.guardar(producto));
    }

    @Operation(summary = "Traer todos los Productos")
    @GetMapping
    public ResponseEntity<Set<ProductoDto>> buscarTodos(){
        return ResponseEntity.ok(productoServices.buscarTodas());
    }

    @Operation(summary = "Traer el Productos por Id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> buscar(@PathVariable Long id) throws ResourceNotFoundException {
        ProductoDto producto = productoServices.buscar(id);

        return ResponseEntity.ok(producto);
    }

    @Operation(summary = "Eliminar el Producto por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        productoServices.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminada");
    }
}
