package com.example.springproject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface utilisateurRepository extends CrudRepository<utilisateur, Long> {

    List<utilisateur> findByLastName(String lastName);
}
