package com.bby2k.stickynotes.controller.authentication;

import com.bby2k.stickynotes.entity.Role;
import com.bby2k.stickynotes.entity.User;
import com.bby2k.stickynotes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class AuthenticationManagerImplementation implements AuthenticationManager {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getPrincipal() + "";
        String password = authentication.getCredentials() + "";

        Optional<User> user = this.userService.loadUserByEmail(email);

        if(user.isEmpty()){
            throw new BadCredentialsException("1000");
        }
        if(passwordEncoder.matches(passwordEncoder.encode(password), user.get().getPassword())){
            throw new BadCredentialsException("1000");
        }
        if(!user.get().isEnabled()){
            throw new BadCredentialsException("1001");
        }
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(user.get().getRole());

        return new UsernamePasswordAuthenticationToken(
                email,
                null,
                userRoles.stream()
                        .map(x -> new SimpleGrantedAuthority(x.name()))
                        .collect(Collectors.toList())
        );
    }
}
