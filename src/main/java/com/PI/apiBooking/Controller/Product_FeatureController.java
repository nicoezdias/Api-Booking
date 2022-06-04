package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.FeatureDto;
import com.PI.apiBooking.Model.DTO.Product_FeatureDto;
import com.PI.apiBooking.Service.Interfaces.IProduct_FeatureService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/products_features")
public class Product_FeatureController {

    @Autowired
    IProduct_FeatureService product_featureService;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar o actualizar Productos_Características")
    @PostMapping
    public ResponseEntity<Product_FeatureDto> save(@RequestBody Product_FeatureDto product_featureDto) {
        if(product_featureDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(product_featureService.save(product_featureDto));
        else
            return ResponseEntity.ok(product_featureService.save(product_featureDto));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todos los Productos_Características")
    @GetMapping
    public ResponseEntity<Set<Product_FeatureDto>> findAll(){
        return ResponseEntity.ok(product_featureService.findAll());
    }

    @Operation(summary = "Traer el Productos_Características por Id")
    @GetMapping("/{id}")
    public ResponseEntity<Product_FeatureDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(product_featureService.findById(id));
    }

    @Operation(summary = "Traer las Características por Id de Producto")
    @GetMapping("features/{productId}")
    public ResponseEntity<Set<FeatureDto>> findFeaturesByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(product_featureService.findFeaturesByProductId(productId));
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar el Productos_Características por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        product_featureService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
