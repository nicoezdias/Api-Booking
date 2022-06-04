package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.FeatureDto;
import com.PI.apiBooking.Model.DTO.ProductDto;
import com.PI.apiBooking.Service.Interfaces.IProductService;
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
    IProductService productServices;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar o actualizar Producto")
    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
        if(productDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(productServices.save(productDto));
        else
            return ResponseEntity.ok(productServices.save(productDto));
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

    @Operation(summary = "Traer la cantidad de Productos por Id de Categoría")
    @GetMapping("/categories/count/{categoryId}")
    public ResponseEntity<Integer> countByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(productServices.countByCategory(categoryId));
    }

    @Operation(summary = "Traer todos Productos por Id de Categoria")
    @GetMapping("categories/{categoryId}")
    public ResponseEntity<Set<ProductDto>> findByCategoryId(@PathVariable Long categoryId){
        Set<ProductDto> product = productServices.findByCategoryId(categoryId);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Traer todos Productos por Id de Ciudad")
    @GetMapping("city/{cityId}")
    public ResponseEntity<Set<ProductDto>> findByCityId(@PathVariable Long cityId){
        Set<ProductDto> product = productServices.findByCityId(cityId);
        return ResponseEntity.ok(product);
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar el Producto por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        productServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

