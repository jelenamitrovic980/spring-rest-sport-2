package com.jelenamitrovic.springRestSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jelenamitrovic.springRestSport.models.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {

}
