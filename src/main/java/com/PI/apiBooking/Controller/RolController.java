package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Model.DTO.Post.RolDto;
import com.PI.apiBooking.Service.Interfaces.IRolService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    IRolService rolService;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar o actualizar un Rol")
    @PostMapping
    public ResponseEntity<RolDto> save(@RequestBody RolDto rolDto) {
        if(rolDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(rolService.save(rolDto));
        else
            return ResponseEntity.ok(rolService.save(rolDto));
    }
}
