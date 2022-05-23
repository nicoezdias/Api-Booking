package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.ImageDto;
import com.PI.apiBooking.Services.Impl.ImageServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/imagenes")
public class ImageController {

    @Autowired
    ImageServices imageServices;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar Imagen")
    @PostMapping
    public ResponseEntity<ImageDto> save(@RequestBody ImageDto image) {
        return ResponseEntity.ok(imageServices.save(image));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Imágenes")
    @GetMapping
    public ResponseEntity<Set<ImageDto>> findAll(){
        return ResponseEntity.ok(imageServices.findAll());
    }

    @Operation(summary = "Traer la Imagen por Id")
    @GetMapping("/{id}")
    public ResponseEntity<ImageDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(imageServices.findById(id));
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar la Imagen por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        imageServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
    }
}
