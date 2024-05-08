package com.project.portfolio.repository.socialMedia;

import com.project.portfolio.core.Base;
import com.project.portfolio.repository.homepage.Homepage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Social_Medias")
public class SocialMedia extends Base {
    @Column(name = "link")
    private String link;

    @OneToMany(mappedBy = "socialMedia")
    private List<Homepage> homepages;

}
