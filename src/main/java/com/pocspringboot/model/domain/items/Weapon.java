package com.pocspringboot.model.domain.items;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Weapon extends ItemDomain {

    public Integer damage;

}
