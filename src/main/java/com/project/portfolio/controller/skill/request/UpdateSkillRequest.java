package com.project.portfolio.controller.skill.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateSkillRequest {
    @NotNull
    private int id;

    private String name;
    private byte[] image; // Resim dosyasını byte olarak almak için
}
