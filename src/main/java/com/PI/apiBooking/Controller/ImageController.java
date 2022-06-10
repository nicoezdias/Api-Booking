package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.ImageProductDto;
import com.PI.apiBooking.Model.DTO.Post.ImageDto;
import com.PI.apiBooking.Service.Interfaces.IImageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    IImageService imageServices;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar o actualizar una Imagen")
    @PostMapping
    public ResponseEntity<ImageDto> save(@RequestBody ImageDto imageDto) {
        if(imageDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(imageServices.save(imageDto));
        else
            return ResponseEntity.ok(imageServices.save(imageDto));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Imágenes")
    @GetMapping
    public ResponseEntity<Set<ImageProductDto>> findAll(){
        return ResponseEntity.ok(imageServices.findAll());
    }

    @Operation(summary = "Traer una Imagen por Id")
    @GetMapping("/{id}")
    public ResponseEntity<ImageProductDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(imageServices.findById(id));
    }

    @Operation(summary = "Traer las Imágenes por Id de Producto")
    @GetMapping("/product/{productId}")
    public ResponseEntity<Set<ImageProductDto>> findImagesByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(imageServices.findImagesByProductId(productId));
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar una Imagen por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        imageServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
