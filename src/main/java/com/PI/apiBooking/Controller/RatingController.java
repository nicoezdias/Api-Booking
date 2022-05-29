package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.RatingDto;
import com.PI.apiBooking.Service.Interfaces.IRatingServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    IRatingServices ratingServices;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar o actualizar Puntuación")
    @PostMapping
    public ResponseEntity<RatingDto> save(@RequestBody RatingDto ratingDto) {
        if(ratingDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(ratingServices.save(ratingDto));
        else
            return ResponseEntity.ok(ratingServices.save(ratingDto));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Puntuaciones")
    @GetMapping
    public ResponseEntity<Set<RatingDto>> findAll(){
        return ResponseEntity.ok(ratingServices.findAll());
    }

    @Operation(summary = "Traer la Puntuación por Id")
    @GetMapping("/{id}")
    public ResponseEntity<RatingDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(ratingServices.findById(id));
    }

    @Operation(summary = "Traer el promedio de Puntuaciones por Producto")
    @GetMapping("product/{id}")
    public ResponseEntity<Optional<Double>> findByCategory(@PathVariable Long id){
        Optional<Double> ratings = ratingServices.findByProduct(id);
        return ResponseEntity.ok(ratings);
    }


    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar la Puntuación por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        ratingServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}