package com.pocspringboot.model.domain.items;

import com.pocspringboot.enumeration.Rarity;
import com.pocspringboot.model.domain.CharacterDomain;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type")
@Table(name = "items")
public abstract class ItemDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;
    private String value;
    private Float weight;
    private String image;
    private String description;
    private Rarity rarity;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private CharacterDomain character;

}
