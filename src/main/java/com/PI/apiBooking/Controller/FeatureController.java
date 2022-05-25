package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.FeatureDto;
import com.PI.apiBooking.Services.Interfaces.IFeatureServices;
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
    IFeatureServices featureServices;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar Caracteristica")
    @PostMapping
    public ResponseEntity<FeatureDto> save(@RequestBody FeatureDto feature) {
        return ResponseEntity.ok(featureServices.save(feature));
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

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar la Caracteristica por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws ResourceNotFoundException {
        featureServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
