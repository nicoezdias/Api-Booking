package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.FavouriteDto;
import com.PI.apiBooking.Model.DTO.ProductCardDto;
import com.PI.apiBooking.Model.Entity.Favourite;
import com.PI.apiBooking.Service.Interfaces.IFavouriteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@Secured({"PENDING","USER","ADMIN"})
@RestController
@RequestMapping("/likes")
@CrossOrigin
public class FavouriteController {

    @Autowired
    IFavouriteService favouriteService;

    //* ///////// POST ///////// *//
    @Operation(summary = "Poner o quitar de Favourite")
    @PostMapping
    public ResponseEntity<FavouriteDto> ponerQuitarFavourite(@RequestBody FavouriteDto favouriteDto) throws ResourceNotFoundException {
        Optional<Favourite> favourite = favouriteService.findByUserIdAndProductId(favouriteDto.getUser().getId(), favouriteDto.getProduct().getId());
        if(favourite.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(favouriteService.save(favouriteDto));
        }
        else {
            favouriteService.delete(favourite.get().getId());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todos los productos en Favourite")
    @GetMapping("/{userId}")
    public ResponseEntity<Set<ProductCardDto>> findProductsByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(favouriteService.findProductsByUserId(userId));
    }
}
