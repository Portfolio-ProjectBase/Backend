package com.project.portfolio.repository.card;

import com.project.portfolio.controller.card.response.CardResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.about.About;
import com.project.portfolio.repository.post.Post;
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
@Table(name = "Card")
@Entity
@SuperBuilder
public class Card extends Base {
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "about_id", nullable = false) // Ensure FK is set correctly
    private About about;
    public CardResponse toResponse() {
        return CardResponse.builder()
                .id(getId())
                .title(getTitle())
                .description(getDescription())
                .build();
    }


}
