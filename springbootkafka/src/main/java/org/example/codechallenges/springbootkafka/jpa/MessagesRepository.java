package org.example.codechallenges.springbootkafka.jpa;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<Message, Long> {
    Message findById(String id);
}
