package com.pocspringboot.model.response;

import com.pocspringboot.enumeration.Gender;
import com.pocspringboot.enumeration.Race;
import com.pocspringboot.model.domain.CharacterDomain;
import com.pocspringboot.model.domain.ProductDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterResponse {

    private Long id;
    private String name;
    private Integer age;
    private Race race;
    private Gender gender;

    public static CharacterResponse valueOf(CharacterDomain characterDomain) {
        return CharacterResponse.builder()
                .id(characterDomain.getId())
                .name(characterDomain.getName())
                .age(characterDomain.getAge())
                .race(characterDomain.getRace())
                .gender(characterDomain.getGender())
                .build();
    }

}