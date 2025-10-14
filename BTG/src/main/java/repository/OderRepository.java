package repository;

import model.OderModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OderRepository extends MongoRepository<OderModel , Long> {
}
