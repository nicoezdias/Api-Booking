package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.BookingDto;
import com.PI.apiBooking.Service.Interfaces.IBookingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Secured({"USER","ADMIN"})
@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    IBookingService bookingService;

    //* ///////// POST ///////// *//
    @Operation(summary = "Guardar o actualizar una Reserva")
    @PostMapping
    public ResponseEntity<BookingDto> save(@RequestBody BookingDto bookingDto) {
        if(bookingDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.save(bookingDto));
        else
            return ResponseEntity.ok(bookingService.save(bookingDto));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todas las reservas por Id de Producto")
    @GetMapping("product/{productId}")
    public ResponseEntity<Set<BookingDto>> findBookingByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(bookingService.findBookingByProductId(productId));
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar una Reserva por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        bookingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
