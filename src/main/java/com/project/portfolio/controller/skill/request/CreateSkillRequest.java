package com.project.portfolio.controller.skill.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateSkillRequest {
    private String name;
    private byte[] image; // Resim dosyasını byte olarak almak için
}
