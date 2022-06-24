package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.FavouriteDto;
import com.PI.apiBooking.Model.DTO.Product_CardDto;
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
    IFavouriteService likeService;

    //* ///////// POST ///////// *//
    @Operation(summary = "Poner o quitar de Favourite")
    @PostMapping
    public ResponseEntity<FavouriteDto> ponerQuitarFavourite(@RequestBody FavouriteDto favouriteDto) throws ResourceNotFoundException {
        Optional<Favourite> favourite = likeService.findByUserIdAndProductId(favouriteDto.getUser().getId(), favouriteDto.getProduct().getId());
        if(favourite.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(likeService.save(favouriteDto));
        }
        else {
            likeService.delete(favourite.get().getId());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todos los productos en Favourite")
    @GetMapping("/{id}")
    public ResponseEntity<Set<Product_CardDto>> findProductsByUserId(@PathVariable Long id){
        return ResponseEntity.ok(likeService.findProductsByUserId(id));
    }
}
