package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CategoryCardDto;
import com.PI.apiBooking.Model.DTO.CategoryCompleteDto;
import com.PI.apiBooking.Model.DTO.Post.CategoryDto;
import com.PI.apiBooking.Service.Interfaces.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryController {

    @Autowired
    private ICategoryService categoryServices;

    //* ///////// POST ///////// *//
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Guardar o actualizar una Categoría")
    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto) {
        if(categoryDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryServices.save(categoryDto));
        else
            return ResponseEntity.ok(categoryServices.save(categoryDto));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Categorías")
    @GetMapping
    public ResponseEntity<Set<CategoryCardDto>> findAll() {
        return ResponseEntity.ok(categoryServices.findAll());
    }

    @Operation(summary = "Traer una Categoría por Id")
    @GetMapping("/{id}")
    public ResponseEntity<CategoryCompleteDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(categoryServices.findById(id));
    }

    //* ///////// DELETE ///////// *//
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Eliminar una Categoría por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        categoryServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
