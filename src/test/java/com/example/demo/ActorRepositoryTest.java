package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ActorRepositoryTest extends AbstractIntegrationTest2 {

    @Autowired
    private ActorRepository actorRepository;

    @Test
    void shouldFindActorsWithPagination() {
        // When
        Pageable pageRequest = PageRequest.of(0, 1);
        List<Actor> result = actorRepository.findAllBy(pageRequest);

        // Then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getFirstName()).isEqualTo("PENELOPE");
    }
} 