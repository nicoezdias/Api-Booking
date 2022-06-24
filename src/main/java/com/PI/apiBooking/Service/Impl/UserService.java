package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.BadRequestException;
import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.AuthenticationRequest;
import com.PI.apiBooking.Model.DTO.Post.UserDto;
import com.PI.apiBooking.Model.DTO.User_BookingDto;
import com.PI.apiBooking.Model.DTO.User_CardDto;
import com.PI.apiBooking.Model.User.Rol;
import com.PI.apiBooking.Model.User.User;
import com.PI.apiBooking.Model.User.UserRoles;
import com.PI.apiBooking.Repository.IUserRepository;
import com.PI.apiBooking.Service.Interfaces.IUserService;
import com.PI.apiBooking.Security.AuthenticationService;
import com.PI.apiBooking.Security.MyPasswordEncoder;
import com.PI.apiBooking.Security.jwt.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    protected final static Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    IUserRepository userRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private MyPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email).get();
        UserDto userDto = mapper.convertValue(user, UserDto.class);
        logger.info("La busqueda fue exitosa: "+ userDto);
        return userDto;
    }

    @Override
    public User_BookingDto findById(Long id) throws ResourceNotFoundException {
        User user = checkId(id);
        User_BookingDto user_bookingDto = mapper.convertValue(user, User_BookingDto.class);
        user_bookingDto.setName(user.getName());
        user_bookingDto.setSurname(user.getSurname());
        if (user.getCity() != null){
            user_bookingDto.setCityName(user.getCity().getName() + ", " + user.getCity().getProvince().getName());
        }
        user_bookingDto.setEmail(user.getEmail());

        return user_bookingDto;
    }

    @Override
    public UserDto save(UserDto userDto) {
        String hashedPassword = passwordEncoder.encodePassword(userDto.getPassword());
        Rol rol = new Rol();
        userDto.setPassword(hashedPassword);
        User user = mapper.convertValue(userDto, User.class);
        if (userDto.getId() == null){
            rol.setId(3L);
            rol.setName(UserRoles.PENDING);
            user.setRol(rol);
            userRepository.save(user);
            userDto.setId(user.getId());
            logger.info("User registrado correctamente: "+ userDto);
        }else{
            userRepository.save(user);
            logger.info("User actualizado correctamente: "+ userDto);
        }
        return userDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        userRepository.deleteById(id);
        logger.info("Se elimino el User correctamente: id("+id+")");
    }

    @Override
    public User checkId(Long id) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return user.get();
    }

    @Override
    public User_CardDto authenticate(AuthenticationRequest authenticationRequest) throws BadRequestException {
        Optional<User> user = userRepository.findByEmail(authenticationRequest.getEmail());
        if (!user.isEmpty() && passwordEncoder.matchesPassword(authenticationRequest.getPassword(), user.get().getPassword())) {
            final UserDetails userDetails = authenticationService.loadUserByUsername(authenticationRequest.getEmail());
            final String jwt = jwtUtil.generateToken(userDetails);
            User_CardDto user_cardDto = mapper.convertValue(user, User_CardDto.class);
            user_cardDto.setRol_Name(user.get().getRol().getName().name());
            user_cardDto.setJwt(jwt);
            return user_cardDto;
        } else {
            throw new BadRequestException("Los datos ingresados no son correctos");
        }
    }

}

