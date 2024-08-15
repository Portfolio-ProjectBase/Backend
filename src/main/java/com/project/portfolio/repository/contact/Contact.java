package com.project.portfolio.repository.contact;

import com.project.portfolio.controller.contact.response.ContactResponse;
import com.project.portfolio.core.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "Contacts")
public class Contact extends Base {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "message")
    private String message;

    public ContactResponse toResponse(){
        return ContactResponse.builder()
                .id(getId())
                .name(getName())
                .surname(getSurname())
                .emailAddress(getEmailAddress())
                .message(getMessage())
                .build();
    }

}
