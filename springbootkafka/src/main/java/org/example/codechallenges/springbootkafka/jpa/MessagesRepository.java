package org.example.codechallenges.springbootkafka.jpa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends CrudRepository<Message, Long> {
    Message findById(String id);
}
