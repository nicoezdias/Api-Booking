package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.BadRequestException;
import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.AuthenticationRequest;
import com.PI.apiBooking.Model.DTO.Post.UserDto;
import com.PI.apiBooking.Model.DTO.UserBookingDto;
import com.PI.apiBooking.Model.DTO.UserCardDto;
import com.PI.apiBooking.Model.Entity.City;
import com.PI.apiBooking.Model.User.Rol;
import com.PI.apiBooking.Model.User.User;
import com.PI.apiBooking.Model.User.UserRoles;
import com.PI.apiBooking.Repository.IUserRepository;
import com.PI.apiBooking.Service.Interfaces.IUserService;
import com.PI.apiBooking.Security.AuthenticationService;
import com.PI.apiBooking.Security.MyPasswordEncoder;
import com.PI.apiBooking.Security.jwt.JwtUtil;
import com.PI.apiBooking.Util.Mapper.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    protected final static Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MyPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email).get();
        UserDto userDto = userMapper.toUserDto(user);
        logger.info("La busqueda fue exitosa: "+ userDto);
        return userDto;
    }

    @Override
    public UserBookingDto findById(Long id) throws ResourceNotFoundException {
        User user = checkId(id);
        UserBookingDto userBookingDto = userMapper.toUserBookingDto(user);
//        userBookingDto.setName(user.getName());
//        userBookingDto.setSurname(user.getSurname());
        if (user.getCity() != null){
            userBookingDto.setCityId(user.getCity().getId());
        }
        userBookingDto.setEmail(user.getEmail());

        return userBookingDto;
    }

    @Override
    public UserDto save(UserDto userDto) {
        String hashedPassword = passwordEncoder.encodePassword(userDto.getPassword());
        userDto.setPassword(hashedPassword);
        User user = userMapper.toUser(userDto);
        if (userDto.getId() == null){
            Rol rol = new Rol();
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
    public UserDto updateCity(Long userId, City city) throws ResourceNotFoundException {
        checkId(userId);
        User user = userRepository.findById(userId).get();
        user.setCity(city);
        userRepository.save(user);
        UserDto userDto = userMapper.toUserDto(user);
        logger.info("User actualizado correctamente: "+ userDto);
        return userDto;
    }

    @Override
    public UserCardDto validate(AuthenticationRequest authenticationRequest, UserDto userDto) throws BadRequestException{
        Rol rol = new Rol();
        rol.setId(2L);
        rol.setName(UserRoles.USER);
        userDto.setRol(rol);
        User user = userMapper.toUser(userDto);
        userRepository.save(user);
        logger.info("User actualizado correctamente: "+ userDto);
        return authenticate(authenticationRequest);
    }

    @Override
    public UserCardDto authenticate(AuthenticationRequest authenticationRequest) throws BadRequestException {
        Optional<User> user = userRepository.findByEmail(authenticationRequest.getEmail());
        if (user.isPresent() && passwordEncoder.matchesPassword(authenticationRequest.getPassword(), user.get().getPassword())) {
            final UserDetails userDetails = authenticationService.loadUserByUsername(authenticationRequest.getEmail());
            final String jwt = jwtUtil.generateToken(userDetails);
            UserCardDto userCardDto = userMapper.toUserCardDto(user.get());
            userCardDto.setJwt(jwt);
            return userCardDto;
        } else {
            throw new BadRequestException("Los datos ingresados no son correctos");
        }
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

}

