package com.example.Mochi.controller;

import com.example.Mochi.entity.Role;
import com.example.Mochi.entity.Roles;
import com.example.Mochi.entity.User;
import com.example.Mochi.jwt.configs.MyUserDetailsService;
import com.example.Mochi.jwt.models.AuthenticationResponse;
import com.example.Mochi.jwt.models.SignupRequest;
import com.example.Mochi.jwt.util.JwtUtil;
import com.example.Mochi.repository.RoleRepository;
import com.example.Mochi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MyUserDetailsService userDetailsService;


    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping()
    public List<User>  getUsers(){
        return service.getUsers();
    }

    @GetMapping("/{userid}")
    public Optional<User> getUserById (@PathVariable("userid") int id){
        return service.getUserById(id);
    }
//    @PostMapping()
//    public String createUser(@RequestBody User user){
//        return service.insertUser(user);
//    }
    //sign up
    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody SignupRequest signupRequest){
        User user = new User(
                signupRequest.getUsername(),
                encoder.encode(signupRequest.getPassword()),
                signupRequest.getEmail(),
                signupRequest.getFullname(),
                signupRequest.getPhone(),
                signupRequest.getAddress());

        Set<String> stringroles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if(stringroles ==  null){
            Role userRole = roleRepository.findByName(Roles.USER);
            if(userRole == null) {
                throw new RuntimeException("Error: Role is not found ");
            }
            roles.add(userRole);
        }
        else{
            Role adminRole= roleRepository.findByName(Roles.ADMIN);
            if(adminRole == null){
                throw new RuntimeException("Error : Role is not found");
            }
            roles.add(adminRole);
        }
        user.setRoles(roles);
        service.insertUser(user);

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(user.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(token));

    }
    @PutMapping()
    public User updateUser (@RequestBody User user){
        return service.updateUser(user);
    }
    @PutMapping("/updatePassword")
    public User updatePassword(@RequestBody User passUser){
        return service.updatePassword(passUser);
    }

    @DeleteMapping("/{userid}")
    @ResponseBody
    public String deleteById(@PathVariable("userid") int id){
        service.deleteUserById(id);
        return "Successfully";
    }
}
