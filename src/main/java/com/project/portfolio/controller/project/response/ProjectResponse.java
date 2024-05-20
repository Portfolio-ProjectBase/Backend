package com.project.portfolio.controller.project.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectResponse {
    int id;
    String title;
    String detail;
    LocalDate projectDate;
    String liveSiteLink;
    String githubLink;
    int skillId;
}
