package com.project.portfolio.repository.resume;

import com.project.portfolio.controller.resume.response.ResumeResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "Resumes")
public class Resume extends Base {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_url", nullable = false)
    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ResumeResponse toResponse(){
        return ResumeResponse.builder()
                .id(getId())
                .name(getName())
                .fileUrl(getFileUrl())
                .fileType(getFileType())
                .build();
    }

}
