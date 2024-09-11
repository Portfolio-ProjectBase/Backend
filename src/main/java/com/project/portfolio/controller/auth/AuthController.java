package com.project.portfolio.controller.auth;
import com.project.portfolio.controller.auth.request.LoginRequest;
import com.project.portfolio.controller.auth.response.JwtResponse;
import com.project.portfolio.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;


    // Rastgele şifre oluştur ve veritabanına kaydet
    @PostMapping("/createSecretPass")
    public ResponseEntity<String> createSecretPass() {
        try {
            // Rastgele şifre oluşturma işlemini AuthService'e delege et
            String secretPass = authService.createSecretPassword();
            return ResponseEntity.ok(secretPass);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Giriş ve JWT oluşturma işlemini AuthService'e delege et
            String token = authService.login(loginRequest.getUsername(), loginRequest.getPassword());

            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}

