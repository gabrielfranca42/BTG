package repository;

import model.OrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OderRepository extends MongoRepository<OrderModel, Long> {
}
