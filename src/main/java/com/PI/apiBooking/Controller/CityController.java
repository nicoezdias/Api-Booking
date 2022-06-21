package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.City_ListDto;
import com.PI.apiBooking.Model.DTO.Post.CityDto;
import com.PI.apiBooking.Service.Interfaces.ICityService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cities")
@CrossOrigin
public class CityController {

    @Autowired
    ICityService cityServices;

    //* ///////// POST ///////// *//
//    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Guardar o actualizar una Ciudad")
    @PostMapping
    public ResponseEntity<CityDto> save(@RequestBody CityDto cityDto) {
        if(cityDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(cityServices.save(cityDto));
        else
            return ResponseEntity.ok(cityServices.save(cityDto));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Ciudades")
    @GetMapping
    public ResponseEntity<Set<City_ListDto>> findAll() {
        return ResponseEntity.ok(cityServices.findAll());
    }

    @Operation(summary = "Traer una Ciudad por Id")
    @GetMapping("/{id}")
    public ResponseEntity<CityDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(cityServices.findById(id));
    }

    //* ///////// DELETE ///////// *//
//    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Eliminar una Ciudad por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        cityServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
