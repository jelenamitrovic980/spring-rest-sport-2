package com.jelenamitrovic.springRestSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jelenamitrovic.springRestSport.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
