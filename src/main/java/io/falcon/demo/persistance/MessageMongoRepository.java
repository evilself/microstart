package io.falcon.demo.persistance;

import io.falcon.demo.model.TheMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageMongoRepository extends MongoRepository<TheMessage, String> {
}