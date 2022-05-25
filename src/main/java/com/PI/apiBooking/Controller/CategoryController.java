package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CategoryDto;
import com.PI.apiBooking.Services.Interfaces.ICategoryServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    ICategoryServices categoryServices;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar Categoria")
    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto category) {
        return ResponseEntity.ok(categoryServices.save(category));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Categorias")
    @GetMapping
    public ResponseEntity<Set<CategoryDto>> findAll() {
        return ResponseEntity.ok(categoryServices.findAll());
    }

    @Operation(summary = "Traer la Categoria por Id")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(categoryServices.findById(id));
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar la Categoria por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws ResourceNotFoundException {
        categoryServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
