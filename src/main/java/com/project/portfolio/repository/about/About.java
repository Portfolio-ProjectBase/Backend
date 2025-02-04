package com.project.portfolio.repository.about;

import com.project.portfolio.controller.about.response.AboutResponse;
import com.project.portfolio.controller.post.response.PostResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.card.Card;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SuperBuilder
@Table(name = "About")
public class About extends Base{
    @Column(name = "about_text")
        private String aboutText;


    @OneToMany(mappedBy = "about", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards;

    public AboutResponse toResponse() {
        return AboutResponse.builder()
                .id(getId())
                .aboutText(getAboutText())
                .cards(getCards() != null
                        ? getCards().stream().map(Card::toResponse).collect(Collectors.toList())
                        : new ArrayList<>()
                )
                .build();
    }

}
