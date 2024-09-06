package com.pocspringboot.model.request;

import com.pocspringboot.enumeration.ItemType;
import com.pocspringboot.enumeration.Rarity;
import com.pocspringboot.model.domain.CharacterDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemRequest {

    @NotBlank(message = "itemType is mandatory")
    private ItemType itemType;

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotBlank(message = "value is mandatory")
    private String value;

    @NotBlank(message = "weight is mandatory")
    private Float weight;

    @NotBlank(message = "rarity is mandatory")
    private Rarity rarity;

    @NotBlank(message = "character_id is mandatory")
    private CharacterDomain character_id;

    private String image;

    private String description;

    private Integer defense;

    private Integer damage;

}
