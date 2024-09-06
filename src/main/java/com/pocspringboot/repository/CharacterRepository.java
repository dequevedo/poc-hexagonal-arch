package com.pocspringboot.repository;

import com.pocspringboot.model.domain.CharacterDomain;
import com.pocspringboot.model.domain.items.ItemDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterDomain, Long> {

}
