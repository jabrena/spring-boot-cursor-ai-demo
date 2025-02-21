package com.example.demo;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends ListCrudRepository<Actor, Long> { }