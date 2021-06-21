package com.example.Mochi.controller;

import com.example.Mochi.entity.User;
import com.example.Mochi.jwt.configs.JwtAuthenticationEntryPoint;
import com.example.Mochi.jwt.configs.MyUserDetailsService;
import com.example.Mochi.jwt.models.AuthenticationRequest;
import com.example.Mochi.jwt.models.AuthenticationResponse;
import com.example.Mochi.jwt.util.JwtUtil;
import com.example.Mochi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    UserService service;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private JwtUtil jwtTokenUtil;

//    @Autowired
//    private UserDetailsService jwtInMemoryUserDetailsService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser (HttpServletRequest request) {
//		return (int) request.getAttribute("userID");
        System.out.print(request);
        Principal principal = request.getUserPrincipal();

        return service.getUserByUsername(principal.getName());
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
