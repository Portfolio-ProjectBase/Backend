package com.project.portfolio.controller.socialMedia.response;

import com.project.portfolio.controller.ImageBaseResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class SocialMediaResponse extends ImageBaseResponse {
    private String name;
    private String link;
}
