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

    @Operation(summary = "Traer todos Productos por Id de Categoria")
    @GetMapping("categories/{id}")
    public ResponseEntity<Set<ProductDto>> findByCategoryId(@PathVariable Long id){
        Set<ProductDto> product = productServices.findByCategoryId(id);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Traer todos Productos por Id de Ciudad")
    @GetMapping("city/{id}")
    public ResponseEntity<Set<ProductDto>> findByCityId(@PathVariable Long id){
        Set<ProductDto> product = productServices.findByCityId(id);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Traer todos Productos por Título de Ciudad")
    @GetMapping("city/name/{cityName}")
    public ResponseEntity<Set<ProductDto>> findByCityName(@PathVariable String cityName){
        Set<ProductDto> product = productServices.findByCityName(cityName);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Traer todas las Características por Id de Producto")
    @GetMapping("features/{productId}")
    public ResponseEntity<Set<FeatureDto>> findFeaturesByProductId(@PathVariable Long productId){
        Set<FeatureDto> product = productServices.findFeaturesByProductId(productId);
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

