package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.RatingDto;
import com.PI.apiBooking.Service.Interfaces.IRatingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/ratings")
@CrossOrigin
public class RatingController {

    @Autowired
    IRatingService ratingServices;

    //* ///////// POST ///////// *//
    @Secured({"ADMIN"})
    @Operation(summary = "Guardar o actualizar una Puntuación")
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

    @Operation(summary = "Traer una Puntuación por Id")
    @GetMapping("/{id}")
    public ResponseEntity<RatingDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(ratingServices.findById(id));
    }

    //* ///////// DELETE ///////// *//
    @Secured({"ADMIN"})
    @Operation(summary = "Eliminar una Puntuación por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        ratingServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
