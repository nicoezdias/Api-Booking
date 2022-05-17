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

    @Operation(summary = "Registramos una nueva Categoria")
    @PostMapping
    public ResponseEntity<CategoriaDto> guardar(@RequestBody CategoriaDto categoria) {
        return ResponseEntity.ok(categoriaServices.guardar(categoria));
    }

    @Operation(summary = "Traemos todas las Categorias")
    @GetMapping
    public ResponseEntity<Set<CategoriaDto>> buscarTodas(){
        return ResponseEntity.ok(categoriaServices.buscarTodas());
    }

    @Operation(summary = "Traemos la Categoria por Id")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> buscar(@PathVariable Long id) throws ResourceNotFoundException {
        CategoriaDto categoria = categoriaServices.buscar(id);

        return ResponseEntity.ok(categoria);
    }

    @Operation(summary = "Eliminamos la Categoria por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        categoriaServices.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminada");
    }

    @Operation(summary = "Actualizamos la Categoria")
    @PutMapping()
    public ResponseEntity<CategoriaDto> actualizar(@RequestBody CategoriaDto categoria) throws ResourceNotFoundException {
        ResponseEntity<CategoriaDto> response = null;

        if (categoria.getId() != null && categoriaServices.buscar(categoria.getId()) != null)
            response = ResponseEntity.ok(categoriaServices.actualizar(categoria));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
}
