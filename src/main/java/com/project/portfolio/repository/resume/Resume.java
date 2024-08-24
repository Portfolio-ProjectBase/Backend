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

    @Lob
    @Column(name = "file_data", nullable = false)
    private byte[] fileData;


    public ResumeResponse toResponse(){
        return ResumeResponse.builder()
                .id(getId())
                .name(getName())
                .fileType(getFileType())
                .build();
    }

}
