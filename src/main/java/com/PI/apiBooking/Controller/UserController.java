package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.BadRequestException;
import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.AuthenticationRequest;
import com.PI.apiBooking.Model.DTO.Post.UserDto;
import com.PI.apiBooking.Model.DTO.User_CardDto;
import com.PI.apiBooking.Service.Interfaces.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar o actualizar un Usuario")
    @PostMapping
    public ResponseEntity<User_CardDto> save(@RequestBody UserDto userDto) throws BadRequestException {
        UserDto user = userService.save(userDto);
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(user.getEmail(),user.getPassword());
        if(userDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.authenticate(authenticationRequest));
        else
            return ResponseEntity.ok(userService.authenticate(authenticationRequest));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<User_CardDto> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.authenticate(authenticationRequest));
    }
    //* ///////// GET ///////// *//
    @Operation(summary = "Traer un Usuario por email")
    @GetMapping("/{email}")
    public ResponseEntity<User_CardDto> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar un Usuario por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
