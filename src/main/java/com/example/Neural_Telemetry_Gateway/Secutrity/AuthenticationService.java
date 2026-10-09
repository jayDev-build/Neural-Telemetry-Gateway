package com.example.Neural_Telemetry_Gateway.Secutrity;

import com.example.Neural_Telemetry_Gateway.Repository.UserRepository;
import com.example.Neural_Telemetry_Gateway.DTO.RegisterUserDto;
import com.example.Neural_Telemetry_Gateway.DTO.LoginUserDto;
import com.example.Neural_Telemetry_Gateway.Entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        User user = User.builder()
                .name(input.getName())
                .mailaddress(input.getMailaddress())
                .password(passwordEncoder.encode(input.getPassword())).build();

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getMailaddress(),
                        input.getPassword()));

        return userRepository.findBymailaddress(input.getMailaddress())
                .orElseThrow();
    }
}