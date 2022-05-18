package com.PI.ProyectoIntegrador.Controller;

import com.PI.ProyectoIntegrador.Exceptions.ResourceNotFoundException;
import com.PI.ProyectoIntegrador.Model.DTO.CategoriaDto;
import com.PI.ProyectoIntegrador.Services.Impl.CategoriaServices;
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

    @Operation(summary = "Guardar Categoria")
    @PostMapping
    public ResponseEntity<CategoriaDto> guardar(@RequestBody CategoriaDto categoria) {
        return ResponseEntity.ok(categoriaServices.guardar(categoria));
    }

    @Operation(summary = "Traer todas las Categorias")
    @GetMapping
    public ResponseEntity<Set<CategoriaDto>> buscarTodas() {
        return ResponseEntity.ok(categoriaServices.buscarTodas());
    }

    @Operation(summary = "Traer la Categoria por Id")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> buscar(@PathVariable Long id) throws ResourceNotFoundException {
        CategoriaDto categoria = categoriaServices.buscar(id);

        return ResponseEntity.ok(categoria);
    }

    @Operation(summary = "Eliminar la Categoria por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        categoriaServices.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminada");
    }

}
