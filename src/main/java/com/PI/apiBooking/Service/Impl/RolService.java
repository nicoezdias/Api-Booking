package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.RolDto;
import com.PI.apiBooking.Model.User.Rol;
import com.PI.apiBooking.Repository.IRolRepository;
import com.PI.apiBooking.Service.Interfaces.IRolService;
import com.PI.apiBooking.Util.Mapper.RolMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService implements IRolService {
    protected final static Logger logger = Logger.getLogger(RolService.class);

    @Autowired
    private IRolRepository rolRepository;
    @Autowired
    private RolMapper rolMapper;

    @Override
    public RolDto save(RolDto rolDto) {
        Rol rol = rolMapper.toRol(rolDto);
        rolRepository.save(rol);
        if (rolDto.getId() == null){
            rolDto.setId(rol.getId());
            logger.info("Rol registrado correctamente: "+ rolDto);
        }else{
            logger.info("Rol actualizado correctamente: "+ rolDto);
        }
        return rolDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        rolRepository.deleteById(id);
        logger.info("Se elimino el Rol correctamente: id("+id+")");
    }

    @Override
    public Rol checkId(Long id) throws ResourceNotFoundException {
        Optional<Rol> rol = rolRepository.findById(id);
        if (rol.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return rol.get();
    }
}
