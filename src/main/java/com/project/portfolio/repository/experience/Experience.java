package com.project.portfolio.repository.experience;

import com.project.portfolio.core.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Experiences")
public class Experience extends Base {
    @Column(name = "department_title")
    private String departmentTitle;
    @Column(name = "workplace")
    private String workplace;
    @Column(name = "detail")
    private String detail;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
}
