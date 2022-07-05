package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.FeatureDto;
import com.PI.apiBooking.Service.Interfaces.IFeatureService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/features")
@CrossOrigin
public class FeatureController {

    @Autowired
    private IFeatureService featureServices;

    //* ///////// POST ///////// *//
    @Secured({"ADMIN"})
    @Operation(summary = "Guardar o actualizar una Característica")
    @PostMapping
    public ResponseEntity<FeatureDto> save(@RequestBody FeatureDto featureDto) {
        if(featureDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(featureServices.save(featureDto));
        else
            return ResponseEntity.ok(featureServices.save(featureDto));
    }
    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Característica")
    @GetMapping
    public ResponseEntity<Set<FeatureDto>> findAll() {
        return ResponseEntity.ok(featureServices.findAll());
    }

    @Operation(summary = "Traer una Característica por Id")
    @GetMapping("/{id}")
    public ResponseEntity<FeatureDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(featureServices.findById(id));
    }

    //* ///////// DELETE ///////// *//
    @Secured({"ADMIN"})
    @Operation(summary = "Eliminar una Característica por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        featureServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
