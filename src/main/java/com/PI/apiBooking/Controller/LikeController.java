package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.LikeDto;
import com.PI.apiBooking.Model.DTO.Product_CardDto;
import com.PI.apiBooking.Model.Entity.Like;
import com.PI.apiBooking.Service.Interfaces.ILikeService;
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
public class LikeController {

    @Autowired
    ILikeService likeService;

    //* ///////// POST ///////// *//
    @Operation(summary = "Poner o quitar un like")
    @PostMapping
    public ResponseEntity<LikeDto> ponerQuitarLike(@RequestBody LikeDto likeDto) throws ResourceNotFoundException {
        Optional<Like> like = likeService.findByUserIdAndProductId(likeDto.getUser().getId(), likeDto.getProduct().getId());
        if(like.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(likeService.save(likeDto));
        }
        else {
            likeService.delete(like.get().getId());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todos los productos likeados")
    @GetMapping("/{id}")
    public ResponseEntity<Set<Product_CardDto>> findProductsByUserId(@PathVariable Long id){
        return ResponseEntity.ok(likeService.findProductsByUserId(id));
    }
}
