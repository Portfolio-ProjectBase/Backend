package com.project.portfolio.controller.project.response;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProjectResponse {
    int id;
    String title;
    String detail;
    LocalDate projectDate;
    String liveSiteLink;
    String githubLink;
}
