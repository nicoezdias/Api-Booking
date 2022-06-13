package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.PolicyDto;
import com.PI.apiBooking.Service.Interfaces.IPolicyService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    @Autowired
    IPolicyService policyService;

    //* ///////// POST ///////// *//
//
    @Operation(summary = "Guardar o actualizar una Política")
    @PostMapping
    public ResponseEntity<PolicyDto> save(@RequestBody PolicyDto policyDto) {
        if(policyDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(policyService.save(policyDto));
        else
            return ResponseEntity.ok(policyService.save(policyDto));

    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las Políticas")
    @GetMapping
    public ResponseEntity<Set<PolicyDto>> findAll(){
        return ResponseEntity.ok(policyService.findAll());
    }

    @Operation(summary = "Traer una Política por Id")
    @GetMapping("/{id}")
    public ResponseEntity<PolicyDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(policyService.findById(id));
    }

    //* ///////// DELETE ///////// *//
//    @Secured({"ADMIN"})
    @Operation(summary = "Eliminar una Política por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        policyService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
