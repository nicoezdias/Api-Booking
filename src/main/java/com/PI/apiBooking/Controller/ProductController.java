package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
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
    @GetMapping("/categories/count/{category}")
    public ResponseEntity<Long> countByCategory(@PathVariable String category) {
        return ResponseEntity.ok(productServices.countByCategory(category));
    }

    @Operation(summary = "Traer todos Productos por Id de Categoria")
    @GetMapping("categories/id/{id}")
    public ResponseEntity<Set<ProductDto>> findByCategoryId(@PathVariable Long id){
        Set<ProductDto> product = productServices.findByCategoryId(id);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Traer todos Productos por Título de Categoria")
    @GetMapping("categories/title/{categoryTitle}")
    public ResponseEntity<Set<ProductDto>> findByCategoryTitle(@PathVariable String categoryTitle){
        Set<ProductDto> product = productServices.findByCategoryTitle(categoryTitle);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Traer todos Productos por Id de Ciudad")
    @GetMapping("city/id/{id}")
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

//    @Operation(summary = "Traer el Productos por Característica")
//    @GetMapping("caracteristica/{id}")
//    public ResponseEntity<Set<ProductDto>> buscarPorCaracteristica(@PathVariable Long id) throws ResourceNotFoundException {
//        Set<ProductDto> producto = productServices.findByFeature(id);
//        return ResponseEntity.ok(producto);
//    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar el Producto por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        productServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

