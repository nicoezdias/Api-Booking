package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.FeatureDto;
import com.PI.apiBooking.Model.DTO.ProductDto;
import com.PI.apiBooking.Service.Interfaces.IFeatureService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/features")
public class FeatureController {

    @Autowired
    IFeatureService featureServices;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar o actualizar Caracteristica")
    @PostMapping
    public ResponseEntity<FeatureDto> save(@RequestBody FeatureDto featureDto) {
        if(featureDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(featureServices.save(featureDto));
        else
            return ResponseEntity.ok(featureServices.save(featureDto));
    }
    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Caracteristica")
    @GetMapping
    public ResponseEntity<Set<FeatureDto>> findAll() {
        return ResponseEntity.ok(featureServices.findAll());
    }

    @Operation(summary = "Traer la Caracteristica por Id")
    @GetMapping("/{id}")
    public ResponseEntity<FeatureDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(featureServices.findById(id));
    }

    @Operation(summary = "Traer todos Productos por Nombre de Característica")
    @GetMapping("products/name/{featureName}")
    public ResponseEntity<Set<ProductDto>> findProductsByFeature(@PathVariable String featureName){
        Set<ProductDto> product = featureServices.findProductsByFeature(featureName);
        return ResponseEntity.ok(product);
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar la Caracteristica por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        featureServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
