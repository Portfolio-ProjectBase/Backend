package com.project.portfolio.controller.auth;
import com.project.portfolio.controller.auth.request.LoginRequest;
import com.project.portfolio.controller.auth.response.JwtResponse;
import com.project.portfolio.controller.user.response.UserResponse;
import com.project.portfolio.core.security.JwtService;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.repository.user.UserRepository;
import com.project.portfolio.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    // Rastgele şifre oluştur ve veritabanına kaydet
    @PostMapping("/createSecretPass")
    public ResponseEntity<String> createSecretPass() {
        // Rastgele şifre oluşturma
        String randomSecretPass = UUID.randomUUID().toString().replace("-", "").substring(0, 8); // 8 karakterlik şifre

        // Kullanıcıyı bul ve şifresini güncelle
        User user = userRepository.findByUsername("dnz");
        user.setPassword(passwordEncoder.encode(randomSecretPass)); // Şifreyi encode ediyoruz
        user.setPasswordCreatedAt(LocalDateTime.now());
        userRepository.save(user); // Güncellenmiş User'ı kaydediyoruz


        return ResponseEntity.ok(randomSecretPass);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Kullanıcı doğrulaması
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            // Kullanıcı doğrulandıktan sonra JWT oluştur
            User userResponse = userRepository.findByUsername(loginRequest.getUsername());
            String token = jwtService.generateToken(userResponse);

            // Token ve kullanıcı bilgilerini geri döndür
            return ResponseEntity.ok(new JwtResponse(token));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

}

