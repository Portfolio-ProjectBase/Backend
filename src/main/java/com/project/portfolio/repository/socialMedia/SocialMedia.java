package com.project.portfolio.repository.socialMedia;

import com.project.portfolio.controller.socialMedia.response.SocialMediaResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.core.ImageBase;
import com.project.portfolio.repository.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Social_Medias")
@SuperBuilder
public class SocialMedia extends ImageBase {
    @Column(name = "name")
    private String name;

    @Column(name = "link")
    private String link;

    public SocialMediaResponse toResponse(){
        return SocialMediaResponse.builder()
                .id(getId())
                .name(getName())
                .link(getLink())
                .imageBase64(getImageBase64())
                .build();
    }

}
