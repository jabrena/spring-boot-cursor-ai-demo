package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

class ActorRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private ActorRepository actorRepository;

    @Test
    void shouldSaveActor() {
        // given
        Actor actor = new Actor();
        actor.setFirst_name("Tom");
        actor.setLast_name("Hanks");
        actor.setLast_update(LocalDateTime.now());

        // when
        Actor savedActor = actorRepository.save(actor);

        // then
        assertThat(savedActor.getActor_id()).isNotNull();
        assertThat(savedActor.getFirst_name()).isEqualTo("Tom");
        assertThat(savedActor.getLast_name()).isEqualTo("Hanks");
    }

    @Test
    void shouldFindActorById() {
        // given
        Actor actor = new Actor();
        actor.setFirst_name("Morgan");
        actor.setLast_name("Freeman");
        actor.setLast_update(LocalDateTime.now());
        Actor savedActor = actorRepository.save(actor);

        // when
        Actor foundActor = actorRepository.findById(savedActor.getActor_id()).orElse(null);

        // then
        assertThat(foundActor).isNotNull();
        assertThat(foundActor.getFirst_name()).isEqualTo("Morgan");
        assertThat(foundActor.getLast_name()).isEqualTo("Freeman");
    }

    @Test
    void shouldFindAllActors() {
        // given
        Actor actor1 = new Actor();
        actor1.setFirst_name("Brad");
        actor1.setLast_name("Pitt");
        actor1.setLast_update(LocalDateTime.now());
        
        Actor actor2 = new Actor();
        actor2.setFirst_name("Leonardo");
        actor2.setLast_name("DiCaprio");
        actor2.setLast_update(LocalDateTime.now());

        actorRepository.saveAll(List.of(actor1, actor2));

        // when
        List<Actor> actors = actorRepository.findAll();

        // then
        assertThat(actors.size()).isGreaterThan(0);
    }

    @Test
    void shouldDeleteActor() {
        // given
        Actor actor = new Actor();
        actor.setFirst_name("Meryl");
        actor.setLast_name("Streep");
        actor.setLast_update(LocalDateTime.now());
        Actor savedActor = actorRepository.save(actor);

        // when
        actorRepository.deleteById(savedActor.getActor_id());

        // then
        assertThat(actorRepository.findById(savedActor.getActor_id())).isEmpty();
    }
} 