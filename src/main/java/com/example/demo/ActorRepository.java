package com.example.demo;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface ActorRepository extends ListCrudRepository<Actor, Long> {
    List<Actor> findAllBy(Pageable pageable);
}