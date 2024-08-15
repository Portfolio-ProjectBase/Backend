package com.project.portfolio.repository.user;

import com.project.portfolio.core.Base;
import com.project.portfolio.repository.certificate.Certificate;
import com.project.portfolio.repository.course.Course;
import com.project.portfolio.repository.education.Education;
import com.project.portfolio.repository.experience.Experience;
import com.project.portfolio.repository.hobby.Hobby;
import com.project.portfolio.repository.language.Language;
import com.project.portfolio.repository.post.Post;
import com.project.portfolio.repository.project.Project;
import com.project.portfolio.repository.referance.Referance;
import com.project.portfolio.repository.resume.Resume;
import com.project.portfolio.repository.skill.Skill;
import com.project.portfolio.repository.socialMedia.SocialMedia;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Users")
public class User extends Base {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "password")
    private String password;
    @Column(name = "about_me")
    private String aboutMe;
    @Column(name = "interests")
    private List<String> interests;
    @Column(name = "detail")
    private String detail;

    @OneToMany(mappedBy = "user")
    private List<Certificate> certificates;

    @OneToMany(mappedBy = "user")
    private List<Course> courses;

    @OneToMany(mappedBy = "user")
    private List<Education> educations;

    @OneToMany(mappedBy = "user")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "user")
    private List<Hobby> hobbies;

    @OneToMany(mappedBy = "user")
    private List<Language> languages;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Project> projects;

    @OneToMany(mappedBy = "user")
    private List<Referance> referances;

    @OneToMany(mappedBy = "user")
    private List<Skill> skills;

    @OneToMany(mappedBy = "user")
    private List<SocialMedia> socialMedias;

    @OneToMany(mappedBy = "user")
    private List<Resume> resumes;

}
