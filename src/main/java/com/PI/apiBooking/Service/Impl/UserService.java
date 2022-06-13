package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.BadRequestException;
import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.AuthenticationRequest;
import com.PI.apiBooking.Model.DTO.Post.UserDto;
import com.PI.apiBooking.Model.DTO.User_CardDto;
import com.PI.apiBooking.Model.User.User;
import com.PI.apiBooking.Repository.IUserRepository;
import com.PI.apiBooking.Service.Interfaces.IUserService;
import com.PI.apiBooking.Service.Security.MyPasswordEncoder;
import com.PI.apiBooking.Service.Security.jwt.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

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
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public User_CardDto findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        User_CardDto user_cardDto = mapper.convertValue(user, User_CardDto.class);
        logger.info("La busqueda fue exitosa: "+ user_cardDto);
        return user_cardDto;
    }

    @Override
    public UserDto save(UserDto userDto) {
        String hashedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(hashedPassword);
        User user = mapper.convertValue(userDto, User.class);
        userRepository.save(user);
        if (userDto.getId() == null){
            userDto.setId(user.getId());
            logger.info("User registrado correctamente: "+ userDto);
        }else{
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
        User user = userRepository.findByEmail(authenticationRequest.getEmail()).get();

        if (user != null && passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword())) {
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
            final String jwt = jwtUtil.generateToken(userDetails);
            User_CardDto user_cardDto = mapper.convertValue(user, User_CardDto.class);
            user_cardDto.setJwt(jwt);
            return user_cardDto;
        } else {
            throw new BadRequestException("Los datos ingresados no son correctos");
        }
    }

}

