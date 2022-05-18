package com.PI.ProyectoIntegrador.Services.Impl;

import com.PI.ProyectoIntegrador.Exceptions.ResourceNotFoundException;
import com.PI.ProyectoIntegrador.Model.Categoria;
import com.PI.ProyectoIntegrador.Model.DTO.CategoriaDto;
import com.PI.ProyectoIntegrador.Repository.ICategoriaRepository;
import com.PI.ProyectoIntegrador.Services.Interfaces.ICategoriaServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoriaServices implements ICategoriaServices {
    protected final static Logger logger = Logger.getLogger(CategoriaServices.class);

    @Autowired
    ICategoriaRepository categoriaRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public CategoriaDto guardar(CategoriaDto categoriaDto) {
        Categoria categoria = mapper.convertValue(categoriaDto,Categoria.class);
        categoriaRepository.save(categoria);
        categoriaDto.setId(categoria.getId());
        logger.info("Categoria registrada correctamente: "+ categoriaDto);
        return categoriaDto;
    }

    @Override
    public CategoriaDto buscar(Long id) throws ResourceNotFoundException {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isEmpty()) {
            throw new ResourceNotFoundException("No existe categoria con id: " + id);
        }
        CategoriaDto categoriaDto = mapper.convertValue(categoria,CategoriaDto.class);
        logger.info("La busqueda fue exitosa: id("+id+")");
        return categoriaDto;
    }

    @Override
    public Set<CategoriaDto> buscarTodas() {
        Set<CategoriaDto> categoriasDtos = new HashSet<>();
        List<Categoria> categorias = categoriaRepository.findAll();
        for (Categoria categoria:categorias
        ) {
            categoriasDtos.add(mapper.convertValue(categoria,CategoriaDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ categoriasDtos);
        return categoriasDtos;
    }

    @Override
    public void eliminar(Long id) throws ResourceNotFoundException {
        buscar(id);
        categoriaRepository.deleteById(id);
        logger.info("Se elimino la categoria correctamente: id("+id+")");
    }

    @Override
    public CategoriaDto actualizar(CategoriaDto categoriaDto) {
        Categoria categoria = mapper.convertValue(categoriaDto,Categoria.class);
        categoriaRepository.save(categoria);
        logger.info("Categoria actualizada correctamente: "+ categoriaDto.toString());
        return categoriaDto;
    }
}
