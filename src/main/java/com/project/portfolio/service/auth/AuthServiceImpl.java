package com.project.portfolio.service.auth;

import com.project.portfolio.core.security.JwtService;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    @Autowired
    private AuthRules authRules;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Override
    public String createSecretPassword() {
        User user = authRules.findUser(); // Kullanıcıyı bul
        String randomSecretPass = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        user.setPassword(passwordEncoder.encode(randomSecretPass));
        user.setPasswordCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        return randomSecretPass; // Şifreyi oluştur ve kaydet
    }
    // Kullanıcı doğrulama ve JWT token oluşturma işlemi
    @Override
    public String login(String username, String password) {

        User user = authRules.findUserByUsername(username);
        // Kullanıcı doğrulaması
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        // JWT oluştur
        return jwtService.generateToken(user);
    }
}
