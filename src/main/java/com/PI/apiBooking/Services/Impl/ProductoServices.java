package com.PI.apiBooking.Services.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.Categoria;
import com.PI.apiBooking.Model.DTO.ProductoDto;
import com.PI.apiBooking.Model.Producto;
import com.PI.apiBooking.Repository.ICategoriaRepository;
import com.PI.apiBooking.Repository.IProductoRepository;
import com.PI.apiBooking.Services.Interfaces.IProductoServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductoServices implements IProductoServices {
    protected final static Logger logger = Logger.getLogger(ProductoServices.class);

    @Autowired
    IProductoRepository productoRepository;
    @Autowired
    CategoriaServices categoriaServices;
    @Autowired
    ObjectMapper mapper;

    @Override
    public ProductoDto guardar(ProductoDto productoDto) {
        Producto producto = mapper.convertValue(productoDto,Producto.class);
        productoRepository.save(producto);
        if (productoDto.getId() == null){
            productoDto.setId(producto.getId());
            logger.info("Producto registrado correctamente: "+ productoDto);
        }else{
            logger.info("Producto actualizado correctamente: "+ productoDto);
        }
        return productoDto;
    }

    @Override
    public ProductoDto buscarPorId(Long id) throws ResourceNotFoundException {
        Producto producto = idCorrecto(id);
        ProductoDto productoDto = mapper.convertValue(producto,ProductoDto.class);
        logger.info("La busqueda fue exitosa: id("+id+")");
        return productoDto;
    }

    @Override
    public Set<ProductoDto> buscarTodas() {
        Set<ProductoDto> productosDto = new HashSet<>();
        List<Producto> productos = productoRepository.findAll();
        for (Producto producto:productos
        ) {
            productosDto.add(mapper.convertValue(producto,ProductoDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ productosDto);
        return productosDto;
    }

    @Override
    public void eliminar(Long id) throws ResourceNotFoundException {
        idCorrecto(id);
        productoRepository.deleteById(id);
        logger.info("Se elimino el producto correctamente: id("+id+")");
    }

    public Set<ProductoDto> buscarPorcategoria(long categoriaid) throws ResourceNotFoundException {
        Categoria categoria = categoriaServices.idCorrecto(categoriaid);
        Set<ProductoDto> productosDto = new HashSet<>();
        Set<Producto> productos = categoria.getProducts();
        for (Producto producto:productos
        ) {
            productosDto.add(mapper.convertValue(producto,ProductoDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ productosDto);
        return productosDto;
    }

    public Producto idCorrecto(Long id) throws ResourceNotFoundException{
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isEmpty()) {
            throw new ResourceNotFoundException("No existe Producto con id: " + id);
        }
        return producto.get();
    }
}
