package com.project.portfolio.repository.about;

import com.project.portfolio.core.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="About")
public class About extends Base {
    @Column(name = "detail")
    private String detail;
}
