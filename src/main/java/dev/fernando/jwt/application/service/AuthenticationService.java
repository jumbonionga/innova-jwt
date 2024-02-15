package dev.fernando.jwt.application.service;

import dev.fernando.jwt.application.exception.DemoSecurityException;
import dev.fernando.jwt.application.lasting.EMessage;
import dev.fernando.jwt.application.lasting.ERole;
import dev.fernando.jwt.domain.dto.AuthenticationDto;
import dev.fernando.jwt.domain.dto.UserDto;
import dev.fernando.jwt.domain.entity.User;
import dev.fernando.jwt.domain.repository.IUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public record AuthenticationService(
        IUserRepository userRepository,
        JwtService jwtService,
        PasswordEncoder passwordEncoder,
        AuthenticationManager authenticationManager
) {
    
    public String register(UserDto userDto) {
        User user = User.builder()
                .firstName(userDto.firstName())
                .lastName(userDto.lastName())
                .email(userDto.email())
                .enable(true)
                .role(ERole.USER)
                .password(passwordEncoder.encode(userDto.password()))
                .build();
        userRepository.save(user);
        return jwtService.generateToken(user);
    }
    
    public String login(AuthenticationDto authenticationDto) throws DemoSecurityException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationDto.email(),
                        authenticationDto.password()
                )
        );
        User user = userRepository.findUserByEmail(authenticationDto.email())
                .orElseThrow(
                        () -> new DemoSecurityException(EMessage.USER_NOT_FOUND)
                );
        return jwtService().generateToken(user);
    }
}
