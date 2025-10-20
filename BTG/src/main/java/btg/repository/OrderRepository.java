package btg.repository;

import btg.model.OrderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderModel, Long> {

    Page<OrderModel> findAllByCustomerId(Long customerId, PageRequest pageRequest);
}
