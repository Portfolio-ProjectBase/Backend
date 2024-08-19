package com.project.portfolio.repository.experience;

import com.project.portfolio.controller.experience.response.ExperienceResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SuperBuilder
@Table(name = "Experiences")
public class Experience extends Base {
    @Column(name = "department_title")
    private String departmentTitle;
    @Column(name = "workplace")
    private String workplace;
    @Column(name = "detail")
    private String detail;
    @Column(name = "position")
    private String position;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "finish_date")
    private LocalDate finishDate;


    public ExperienceResponse toResponse(){
        return ExperienceResponse.builder()
                .id(getId())
                .departmentTitle(getDepartmentTitle())
                .workplace(getWorkplace())
                .detail(getDetail())
                .position(getPosition())
                .startDate(getStartDate())
                .finishDate(getFinishDate())
                .build();
    }
    public Experience fromRepository(ExperienceResponse response){
        return Experience.builder()
                .id(getId())
                .departmentTitle(getDepartmentTitle())
                .workplace(getWorkplace())
                .detail(getDetail())
                .position(getPosition())
                .startDate(getStartDate())
                .finishDate(getFinishDate())
                .build();
    }
}
