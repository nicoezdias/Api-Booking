package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CategoriaDto;
import com.PI.apiBooking.Services.Impl.CategoriaServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaServices categoriaServices;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar Categoria")
    @PostMapping
    public ResponseEntity<CategoriaDto> guardar(@RequestBody CategoriaDto categoria) {
        return ResponseEntity.ok(categoriaServices.save(categoria));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Categorias")
    @GetMapping
    public ResponseEntity<Set<CategoriaDto>> buscarTodas() {
        return ResponseEntity.ok(categoriaServices.findAll());
    }

    @Operation(summary = "Traer la Categoria por Id")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        CategoriaDto categoria = categoriaServices.findById(id);

        return ResponseEntity.ok(categoria);
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar la Categoria por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        categoriaServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminada");
    }

}
