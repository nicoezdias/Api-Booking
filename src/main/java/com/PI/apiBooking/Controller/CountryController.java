package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.CountryDto;
import com.PI.apiBooking.Service.Interfaces.ICountryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
@CrossOrigin
public class CountryController {

    @Autowired
    ICountryService countryService;

    //* ///////// POST ///////// *//
    @Secured({"ADMIN"})
    @Operation(summary = "Guardar o actualizar un País")
    @PostMapping
    public ResponseEntity<CountryDto> save(@RequestBody CountryDto countryDto) {
        if(countryDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(countryService.save(countryDto));
        else
            return ResponseEntity.ok(countryService.save(countryDto));
    }

    //* ///////// DELETE ///////// *//
    @Secured({"ADMIN"})
    @Operation(summary = "Eliminar un País por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        countryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
