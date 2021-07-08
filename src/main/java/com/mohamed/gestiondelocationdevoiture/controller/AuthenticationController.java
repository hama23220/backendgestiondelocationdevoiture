package com.mohamed.gestiondelocationdevoiture.controller;

import com.mohamed.gestiondelocationdevoiture.dto.auth.AuthenticationRequest;
import com.mohamed.gestiondelocationdevoiture.dto.auth.AuthenticationResponse;
import com.mohamed.gestiondelocationdevoiture.services.auth.ApplicationUserDetailsService;
import com.mohamed.gestiondelocationdevoiture.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import static com.mohamed.gestiondelocationdevoiture.utils.Constants.AUTHENTICATION_ENDPOINT;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtli;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){

        authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
               )
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());

        final String jwt = jwtUtli.generateToken(userDetails);

        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
    }
}
