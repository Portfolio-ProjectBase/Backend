package com.project.portfolio.repository.user;

import com.project.portfolio.controller.user.response.UserResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.certificate.Certificate;
import com.project.portfolio.repository.course.Course;
import com.project.portfolio.repository.education.Education;
import com.project.portfolio.repository.experience.Experience;
import com.project.portfolio.repository.hobby.Hobby;
import com.project.portfolio.repository.language.Language;
import com.project.portfolio.repository.post.Post;
import com.project.portfolio.repository.project.Project;
import com.project.portfolio.repository.reference.Reference;
import com.project.portfolio.repository.resume.Resume;
import com.project.portfolio.repository.skill.Skill;
import com.project.portfolio.repository.socialMedia.SocialMedia;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SuperBuilder
@Table(name = "Users")
public class User extends Base implements UserDetails {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "about_me")
    private String aboutMe;
    @Column(name = "detail")
    private String detail;
    @Column(name = "passwordCreatedAt")
    private LocalDateTime passwordCreatedAt;


    public UserResponse toResponse(){
        return UserResponse.builder()
                .id(getId())
                .name(getName())
                .surname(getSurname())
                .detail(getDetail())
                .emailAddress(getEmailAddress())
                .aboutMe(getAboutMe())
                .password(getPassword())
                .passwordCreatedAt(getPasswordCreatedAt())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
