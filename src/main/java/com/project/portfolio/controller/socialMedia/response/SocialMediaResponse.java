package com.project.portfolio.controller.socialMedia.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SocialMediaResponse {
    private int id;
    private String name;
    private String link;
}
