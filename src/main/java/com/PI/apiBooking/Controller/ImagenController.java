package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.ImagenDto;
import com.PI.apiBooking.Services.Impl.ImagenServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/imagenes")
public class ImagenController {

    @Autowired
    ImagenServices imagenServices;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar Imagen")
    @PostMapping
    public ResponseEntity<ImagenDto> guardar(@RequestBody ImagenDto imagen) {
        return ResponseEntity.ok(imagenServices.save(imagen));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Imágenes")
    @GetMapping
    public ResponseEntity<Set<ImagenDto>> buscarTodos(){
        return ResponseEntity.ok(imagenServices.findAll());
    }

    @Operation(summary = "Traer la Imagen por Id")
    @GetMapping("/{id}")
    public ResponseEntity<ImagenDto> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        ImagenDto imagen = imagenServices.findById(id);
        return ResponseEntity.ok(imagen);
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar la Imagen por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        imagenServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
    }
}
