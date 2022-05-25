package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.ProductDto;
import com.PI.apiBooking.Services.Impl.ProductServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServices productServices;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar Producto")
    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto product) {
        return ResponseEntity.ok(productServices.save(product));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todos los Productos")
    @GetMapping
    public ResponseEntity<Set<ProductDto>> findAll(){
        return ResponseEntity.ok(productServices.findAll());
    }

    @Operation(summary = "Traer el Productos por Id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productServices.findById(id));
    }

    @Operation(summary = "Cantidad de Productos por Categoría")
    @GetMapping("/contar/{c}")
    public Long countByCategory(@PathVariable String category) {
        return productServices.countByCategory(category);
    }

    @Operation(summary = "Traer el Productos por Categoria")
    @GetMapping("categoria/{id}")
    public ResponseEntity<Set<ProductDto>> findByCategory(@PathVariable Long id){
        Set<ProductDto> product = productServices.findByCategory(id);
        return ResponseEntity.ok(product);
    }

//    @Operation(summary = "Traer el Productos por Característica")
//    @GetMapping("caracteristica/{id}")
//    public ResponseEntity<Set<ProductDto>> buscarPorCaracteristica(@PathVariable Long id) throws ResourceNotFoundException {
//        Set<ProductDto> producto = productServices.findByFeature(id);
//        return ResponseEntity.ok(producto);
//    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar el Producto por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        productServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
    }
}
