package io.falcon.demo.persistance;

import io.falcon.demo.model.TheMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<TheMessage, String> {}