package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.ProvinceDto;
import com.PI.apiBooking.Service.Interfaces.IProvinceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provinces")
@CrossOrigin
public class ProvinceController {

    @Autowired
    IProvinceService provinceService;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar o actualizar una Provincia")
    @PostMapping
    public ResponseEntity<ProvinceDto> save(@RequestBody ProvinceDto provinceDto) {
        if(provinceDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(provinceService.save(provinceDto));
        else
            return ResponseEntity.ok(provinceService.save(provinceDto));
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar una Provincia por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        provinceService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
