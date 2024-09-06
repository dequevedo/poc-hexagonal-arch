package com.pocspringboot.model.domain;

import com.pocspringboot.enumeration.Gender;
import com.pocspringboot.enumeration.Race;
import com.pocspringboot.model.domain.items.ItemDomain;
import com.pocspringboot.model.request.CreateCharacterRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "characters")
public class CharacterDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "race")
    private Race race;

    @Column(name = "gender")
    private Gender gender;

    @OneToMany(mappedBy="character")
    private List<ItemDomain> items;

    public static CharacterDomain valueOf(CreateCharacterRequest createCharacterRequest) {
        return CharacterDomain.builder()
                .name(createCharacterRequest.getName())
                .age(createCharacterRequest.getAge())
                .race(createCharacterRequest.getRace())
                .gender(createCharacterRequest.getGender())
                .build();
    }

}
