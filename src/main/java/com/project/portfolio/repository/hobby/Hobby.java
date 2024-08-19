package com.project.portfolio.repository.hobby;

import com.project.portfolio.controller.hobby.response.HobbyResponse;
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
@Table(name = "Hobbies")
public class Hobby extends Base {

    @Column(name = "name")
    private String name;


    public HobbyResponse toResponse(){
        return HobbyResponse.builder()
                .id(getId())
                .name(getName())
                .build();
    }
}
