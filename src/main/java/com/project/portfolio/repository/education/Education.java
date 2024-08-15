package com.project.portfolio.repository.education;

import com.project.portfolio.controller.education.response.EducationResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.service.user.UserService;
import com.project.portfolio.service.user.UserServiceImpl;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@SuperBuilder
@Table(name = "Education")
public class Education extends Base {
    @Column(name = "name")
    private String name;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "finishDate")
    private Date finishDate;
    @Column(name = "major")
    private String major;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public EducationResponse toResponse(){
        return EducationResponse.builder()
                .id(getId())
                .name(getName())
                .startDate(getStartDate())
                .finishDate(getFinishDate())
                .major(getMajor())
                .build();
    }
    public Education fromResponse(EducationResponse response){
        return Education.builder()
                .id(response.getId())
                .name(response.getName())
                .startDate(response.getStartDate())
                .finishDate(response.getFinishDate())
                .major(response.getMajor())
                .build();

    }
}
