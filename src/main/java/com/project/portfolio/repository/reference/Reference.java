package com.project.portfolio.repository.reference;

import com.project.portfolio.controller.reference.response.ReferenceResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SuperBuilder
@Table(name = "Reference")
public class Reference extends Base {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email_address")
    private String emailAddress;


    public ReferenceResponse toResponse(){
        return ReferenceResponse.builder()
                .name(getName())
                .surname(getSurname())
                .emailAddress(getEmailAddress())
                .build();
    }
    public Reference fromResponse(ReferenceResponse response){
        return Reference.builder()
                .name(response.getName())
                .surname(response.getSurname())
                .emailAddress(response.getEmailAddress())
                .build();
    }

}
