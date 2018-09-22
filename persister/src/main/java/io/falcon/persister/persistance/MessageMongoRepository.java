package io.falcon.persister.persistance;


import io.falcon.persister.model.TheMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageMongoRepository extends MongoRepository<TheMessage, String> {
}