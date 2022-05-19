package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CaracteristicaDto;
import com.PI.apiBooking.Services.Impl.CaracteristicaServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/caracteristicas")
public class CaracteristicaController {

    @Autowired
    CaracteristicaServices caracteristicaServices;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar Caracteristica")
    @PostMapping
    public ResponseEntity<CaracteristicaDto> guardar(@RequestBody CaracteristicaDto caracteristica) {
        return ResponseEntity.ok(caracteristicaServices.save(caracteristica));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Caracteristica")
    @GetMapping
    public ResponseEntity<Set<CaracteristicaDto>> buscarTodas() {
        return ResponseEntity.ok(caracteristicaServices.findAll());
    }

    @Operation(summary = "Traer la Caracteristica por Id")
    @GetMapping("/{id}")
    public ResponseEntity<CaracteristicaDto> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        CaracteristicaDto caracteristica = caracteristicaServices.findById(id);

        return ResponseEntity.ok(caracteristica);
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar la Caracteristica por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        caracteristicaServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminada");
    }
}
