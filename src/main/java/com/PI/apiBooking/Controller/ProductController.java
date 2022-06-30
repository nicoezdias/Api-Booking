package com.PI.apiBooking.Controller;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.ProductDto;
import com.PI.apiBooking.Model.DTO.ProductBookingDto;
import com.PI.apiBooking.Model.DTO.ProductCardDto;
import com.PI.apiBooking.Model.DTO.ProductCompleteDto;
import com.PI.apiBooking.Service.Interfaces.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    @Autowired
    IProductService productServices;

    //* ///////// POST ///////// *//
    @Secured({"ADMIN"})
    @Operation(summary = "Guardar o actualizar un Producto")
    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
        if(productDto.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(productServices.save(productDto));
        else
            return ResponseEntity.ok(productServices.save(productDto));
    }

    //* ///////// GET ///////// *//
    @Operation(summary = "Traer todos los Productos")
    @GetMapping(value = {"all", "all/{userId}"})
    public ResponseEntity<Set<ProductCardDto>> findAll(@PathVariable(required = false) Long userId){
        return ResponseEntity.ok(productServices.findAll(userId));
    }

    @Operation(summary = "Traer un Productos por Id")
    @GetMapping(value = {"/{id}", "/{id}/{userId}"})
    public ResponseEntity<ProductCompleteDto> findById(@PathVariable Long id, @PathVariable(required = false) Long userId) throws ResourceNotFoundException {
        return ResponseEntity.ok(productServices.findById(id, userId));
    }

    @Operation(summary = "Traer todos Productos por Id de Categoria")
    @GetMapping(value = {"categories/{categoryId}", "categories/{categoryId}/{userId}"})
    public ResponseEntity<Set<ProductCardDto>> findByCategoryId(@PathVariable Long categoryId, @PathVariable(required = false) Long userId){
        Set<ProductCardDto> product = productServices.findByCategoryId(categoryId, userId);
        return ResponseEntity.ok(product);
    }

//    @Operation(summary = "Traer todos Productos por Id de Ciudad")
//    @GetMapping(value = {"city/{cityId}", "city/{cityId}/{userId}"})
//    public ResponseEntity<Set<Product_CardDto>> findByCityId(@PathVariable Long cityId, @PathVariable(required = false) Long userId){
//        Set<Product_CardDto> product = productServices.findByCityId(cityId, userId);
//        return ResponseEntity.ok(product);
//    }

    @Operation(summary = "Traer todos Productos por Fecha e Id de Ciudad")
    //@GetMapping("date")
    //public ResponseEntity<Set<Product_CardDto>> findByDateAndCityId(@RequestParam(required = false) String arrival, @RequestParam(required = false) String departure, @RequestParam int id){
    @GetMapping(value = {"date/{cityId}", "date/{cityId}/{userId}", "date/{cityId}/{arrival}/{departure}", "date/{cityId}/{userId}/{arrival}/{departure}"})
    public ResponseEntity<Set<ProductCardDto>> findByDateAndCityId(@PathVariable Long cityId, @PathVariable(required = false) Long userId, @PathVariable(required = false) String arrival, @PathVariable(required = false) String departure){
        Set<ProductCardDto> productsCardDto = productServices.findByDateAndCityId(cityId, userId, arrival, departure);

        return ResponseEntity.ok(productsCardDto);
    }

    @Operation(summary = "Traer un Producto por Id para una Reserva")
    @GetMapping("/booking/{productId}/{userId}")
    public ResponseEntity<ProductBookingDto> findForBooking(@PathVariable Long productId, @PathVariable Long userId) throws ResourceNotFoundException {
        return ResponseEntity.ok(productServices.findForBooking(productId, userId));
    }

    @Operation(summary = "Traer un Producto por Id para Editar")
    @GetMapping("/edit/{id}")
    public ResponseEntity<ProductDto> findForEdit(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productServices.findForEdit(id));
    }

    //* ///////// DELETE ///////// *//
    @Secured({"ADMIN"})
    @Operation(summary = "Eliminar el Producto por Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        productServices.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

