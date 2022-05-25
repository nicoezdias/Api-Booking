package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CategoryDto;
import com.PI.apiBooking.Services.Impl.CategoryServices;
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
    CategoryServices categoryServices;

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
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        categoryServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminada");
    }

}
