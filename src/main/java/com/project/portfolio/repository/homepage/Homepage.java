package com.project.portfolio.repository.homepage;

import com.project.portfolio.core.Base;
import com.project.portfolio.repository.socialMedia.SocialMedia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Homepage")
public class Homepage extends Base {
    @Column(name = "detail")
    private String detail;

    @ManyToOne
    @JoinColumn(name = "social_media_id")
    private SocialMedia socialMedia;

}
