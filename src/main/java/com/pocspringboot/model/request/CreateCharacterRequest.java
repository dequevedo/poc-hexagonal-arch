package com.pocspringboot.model.request;

import com.pocspringboot.enumeration.Gender;
import com.pocspringboot.enumeration.Race;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCharacterRequest {

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotBlank(message = "age is mandatory")
    private Integer age;

    @NotBlank(message = "race is mandatory")
    private Race race;

    @NotBlank(message = "gender is mandatory")
    private Gender gender;

}
