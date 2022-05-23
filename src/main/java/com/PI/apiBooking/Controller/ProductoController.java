package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CaracteristicaDto;
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

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar Producto")
    @PostMapping
    public ResponseEntity<ProductoDto> guardar(@RequestBody ProductoDto producto) {
        return ResponseEntity.ok(productoServices.save(producto));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todos los Productos")
    @GetMapping
    public ResponseEntity<Set<ProductoDto>> buscarTodos(){
        return ResponseEntity.ok(productoServices.findAll());
    }

    @Operation(summary = "Traer el Productos por Id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        ProductoDto producto = productoServices.findById(id);

        return ResponseEntity.ok(producto);
    }

    @Operation(summary = "Traer el Productos por Categoria")
    @GetMapping("categoria/{id}")
    public ResponseEntity<Set<ProductoDto>> buscarPorCategoria(@PathVariable Long id) throws ResourceNotFoundException {
        Set<ProductoDto> producto = productoServices.findByCategory(id);
        return ResponseEntity.ok(producto);
    }

    @Operation(summary = "Traer el Productos por Característica")
    @GetMapping("caracteristica/{id}")
    public ResponseEntity<Set<ProductoDto>> buscarPorCaracteristica(@PathVariable Long id) throws ResourceNotFoundException {
        Set<ProductoDto> producto = productoServices.findByFeature(id);
        return ResponseEntity.ok(producto);
    }

    @Operation(summary = "Contar la cantidad de Productos por Categoría")
    @GetMapping("/contar/{c}")
    public Long contarPorCategorias(@PathVariable String c) {
        return productoServices.countByCategory(c);
    }

    @Operation(summary = "Traer Productos por Categoria")
    @GetMapping("/c/{c}")
    public Set<ProductoDto> buscarPorC(@PathVariable String c) {
        return productoServices.buscarPorCategoria(c);
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar el Producto por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        productoServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
    }
}
