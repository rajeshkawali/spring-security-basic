package com.rajeshkawali.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rajeshkawali.entity.MyUserDetails;
import com.rajeshkawali.entity.User;
import com.rajeshkawali.repository.SpringSecurityRepository;

import java.util.Optional;

@Service
public class SpringSecurityService implements UserDetailsService {

    @Autowired
    SpringSecurityRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return user.map(MyUserDetails::new).get();
    }
}
