package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.BookingDto;
import com.PI.apiBooking.Model.DTO.Post.CategoryDto;
import com.PI.apiBooking.Service.Interfaces.IBookingService;
import com.PI.apiBooking.Service.Interfaces.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Set;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    IBookingService bookingService;

    //* ///////// GET ///////// *//

    @Operation(summary = "Traer todas las reservas por Id de Producto")
    @GetMapping("products/{productId}")
    public ResponseEntity<Set<BookingDto>> findBookingByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(bookingService.findBookingByProductId(productId));
    }

    //* ///////// POST ///////// *//

    @Operation(summary = "Guardar o actualizar Reserva")
    @PostMapping
    public ResponseEntity<BookingDto> save(@RequestBody BookingDto bookingDto) {
        if(bookingDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.save(bookingDto));
        else
            return ResponseEntity.ok(bookingService.save(bookingDto));
    }

    //* ///////// DELETE ///////// *//
    @Operation(summary = "Eliminar la Reserva por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        bookingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
