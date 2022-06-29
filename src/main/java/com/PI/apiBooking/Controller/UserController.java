package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.BadRequestException;
import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.AuthenticationRequest;
import com.PI.apiBooking.Model.DTO.Post.UserDto;
import com.PI.apiBooking.Model.DTO.UserCardDto;
import com.PI.apiBooking.Model.User.UserRoles;
import com.PI.apiBooking.Service.Interfaces.IUserService;
import com.PI.apiBooking.Mail.EmailSenderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    IUserService userService;
    @Autowired
    private EmailSenderService emailSenderService;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar o actualizar un Usuario")
    @PostMapping
    public ResponseEntity<UserCardDto> save(@RequestBody UserDto userDto) throws BadRequestException, MessagingException {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setEmail(userDto.getEmail());
        authenticationRequest.setPassword(userDto.getPassword());

        if(userDto.getId() == null){
            userService.save(userDto);
            UserCardDto user_cardDto =userService.authenticate(authenticationRequest);
//            emailSenderService.sendMailLog(userDto.getEmail(),userDto.getName()+" "+userDto.getSurname());
            return ResponseEntity.status(HttpStatus.CREATED).body(user_cardDto);
        } else{
            userService.save(userDto);
            return ResponseEntity.ok(userService.authenticate(authenticationRequest));
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserCardDto> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws BadRequestException {
        return ResponseEntity.ok(userService.authenticate(authenticationRequest));
    }

    @PostMapping("/validate")
    public ResponseEntity<UserCardDto> validateUser(@RequestBody AuthenticationRequest authenticationRequest) throws BadRequestException {
        UserDto userDto = userService.findByEmail(authenticationRequest.getEmail());
        userDto.getRol().setId(2L);
        userDto.getRol().setName(UserRoles.USER);
        userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.authenticate(authenticationRequest));
    }

    //* ///////// DELETE ///////// *//
    @Secured({"ADMIN"})
    @Operation(summary = "Eliminar un Usuario por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
