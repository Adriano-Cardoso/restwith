package com.br.adriano.service;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.br.adriano.domain.Profile;
import com.br.adriano.domain.User;
import com.br.adriano.domain.dto.request.UserRequest;
import com.br.adriano.domain.dto.response.UserResponse;
import com.br.adriano.repository.ProfileRepository;
import com.br.adriano.repository.UserRepository;
import com.br.adriano.validation.Message;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("UserService")
@Validated
@Slf4j
@AllArgsConstructor
public class UserService implements UserDetailsService {


	UserRepository userRepository;
	
    ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("method=loadUserByUsername username={}",username);
        return userRepository.findByEmail(username)
                .orElseThrow(() -> Message.NOT_FOT_USER_PERMISSION.asBusinessException());
    }

    public UserResponse save(@Valid UserRequest userRequest) {
        
        userRepository.findByEmail(userRequest.getEmail()).ifPresent(p -> {
            throw Message.IS_PRESENT_USER.asBusinessException();
        });
        
        Profile profile = profileRepository.findByName("USER").orElseThrow(()->Message.NAME_PROFILE_NOT_FOUND.asBusinessException());

        User user = User.builder().email(userRequest.getEmail())
                .password(new BCryptPasswordEncoder().encode(userRequest.getPassword())).userName(userRequest.getUsername())
                .build();

        user.setProfile(Arrays.asList(profile));

        userRepository.save(user);
        
        log.info("method=save username={} email={}", userRequest.getUsername(),userRequest.getEmail());

        return user.toResponse();
    }

}
