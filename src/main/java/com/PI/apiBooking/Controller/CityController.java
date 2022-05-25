package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CityDto;
import com.PI.apiBooking.Services.Impl.CityServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CityServices cityServices;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar Ciudad")
    @PostMapping
    public ResponseEntity<CityDto> save(@RequestBody CityDto cityDto) {
        return ResponseEntity.ok(cityServices.save(cityDto));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Ciudades")
    @GetMapping
    public ResponseEntity<Set<CityDto>> findAll() {
        return ResponseEntity.ok(cityServices.findAll());
    }

    @Operation(summary = "Traer la Ciudad por Id")
    @GetMapping("/{id}")
    public ResponseEntity<CityDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(cityServices.findById(id));
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar la Ciudad por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        cityServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminada");
    }
}
