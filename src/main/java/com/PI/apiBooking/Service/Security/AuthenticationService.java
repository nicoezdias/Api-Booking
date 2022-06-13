package com.PI.apiBooking.Service.Security;

import com.PI.apiBooking.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.PI.apiBooking.Model.User.User user = userRepository.findByEmail(email).get();

        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRol().getName());

        Collections.singletonList(grantedAuthority);
        User userDetail = new User(user.getName(),user.getPassword(),true, true, true,true, Collections.singletonList(grantedAuthority));
        return userDetail;
    }


}
