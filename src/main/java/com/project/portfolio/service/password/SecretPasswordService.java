package com.project.portfolio.service.password;

import com.project.portfolio.repository.user.User;
import com.project.portfolio.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SecretPasswordService {

    private final UserRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(SecretPasswordService.class);
    private int sayac = 1;

    @Scheduled(fixedRate = 60000) // 60 saniyede bir çalışır
    public void deleteExpiredPasswords() {
        //logger.info("Planlanmış görev " + sayac + " kez çağırıldı");
        //sayac++;

        // Tüm kullanıcıların bilgilerini alıyoruz
        List<User> users = repository.findAll();

        for (User user : users) {
            if (user.getPasswordCreatedAt() != null) {
                boolean isExpired = isPasswordExpired(user.getPasswordCreatedAt());
                logger.info("Kullanıcı: " + user.getUsername() + ", şifre süresi dolmuş mu? " + isExpired);

                if (isExpired && user.getPassword() != null) {
                    // Şifre süresi dolmuşsa, şifreyi sıfırlıyoruz
                    resetUserPassword(user);
                }
            }
        }
    }

    // Şifre süresi dolmuş mu? (10 dk)
    private boolean isPasswordExpired(LocalDateTime passwordCreatedAt) {
        return passwordCreatedAt.plusHours(1).isBefore(LocalDateTime.now());
    }

    // Kullanıcının şifresini sıfırlama işlemi
    private void resetUserPassword(User user) {
        logger.info("Şifre sıfırlanıyor: " + user.getUsername());

        // Şifre ve şifre oluşturulma tarihini sıfırlıyoruz
        repository.updateUser(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getAboutMe(),
                null, // Şifreyi sıfırlıyoruz
                user.getEmailAddress(),
                null,
                user.getDetail()
        );
    }
}
