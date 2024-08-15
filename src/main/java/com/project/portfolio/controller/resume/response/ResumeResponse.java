package com.project.portfolio.controller.resume.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumeResponse {

    private int id;
    private String name;
    private String fileUrl;
    private String fileType;

}
