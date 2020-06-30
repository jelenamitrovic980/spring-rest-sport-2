package com.jelenamitrovic.springRestSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jelenamitrovic.springRestSport.models.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

}
