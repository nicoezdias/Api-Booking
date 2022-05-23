package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CiudadDto;
import com.PI.apiBooking.Services.Impl.CiudadServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    CiudadServices ciudadServices;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar Ciudad")
    @PostMapping
    public ResponseEntity<CiudadDto> guardar(@RequestBody CiudadDto ciudadDto) {
        return ResponseEntity.ok(ciudadServices.save(ciudadDto));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Ciudades")
    @GetMapping
    public ResponseEntity<Set<CiudadDto>> buscarTodas() {
        return ResponseEntity.ok(ciudadServices.findAll());
    }

    @Operation(summary = "Traer la Ciudad por Id")
    @GetMapping("/{id}")
    public ResponseEntity<CiudadDto> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        CiudadDto ciudadDto = ciudadServices.findById(id);
        return ResponseEntity.ok(ciudadDto);
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar la Ciudad por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        ciudadServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminada");
    }
}
