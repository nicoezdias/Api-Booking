package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Util.Mail.EmailSenderService;
import com.PI.apiBooking.Model.DTO.BookingUserDto;
import com.PI.apiBooking.Model.DTO.Post.BookingDto;
import com.PI.apiBooking.Service.Interfaces.IBookingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@PreAuthorize("hasAnyRole('USER','ADMIN')")
@RestController
@RequestMapping("/bookings")
@CrossOrigin
public class BookingController {

    @Autowired
    private IBookingService bookingService;
    @Autowired
    private EmailSenderService emailSenderService;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar o actualizar una Reserva")
    @PostMapping
    public ResponseEntity<BookingDto> save(@RequestBody BookingDto bookingDto) throws MessagingException {
        if(bookingDto.getId() == null) {
            BookingDto booking = bookingService.save(bookingDto);
//            emailSenderService.sendMailBooking(booking);
            return ResponseEntity.status(HttpStatus.CREATED).body(booking);
        }else{
            BookingDto booking = bookingService.save(bookingDto);
//            emailSenderService.sendMailBooking(booking);
            return ResponseEntity.ok(bookingService.save(booking));
        }

    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las reservas por Id de Usuario")
    @GetMapping("user/{userId}")
    public ResponseEntity<List<BookingUserDto>> findBookingByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(bookingService.findBookingByUserId(userId));
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar una Reserva por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        bookingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
