package btg.service;

import btg.listener.dto.OrderCreatedEvent;
import btg.model.OrderItemModel;
import btg.model.OrderModel;
import btg.repository.OrderRepository;
import btg.controller.dto.OrderResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MongoTemplate mongoTemplate;

    public OrderService(OrderRepository orderRepository, MongoTemplate mongoTemplate) {
        this.orderRepository = orderRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public void save(OrderCreatedEvent event) {
        var model = OrderModel.builder()
                .orderId(event.codigoPedido())
                .customerId(event.codigoCliente())
                .items(getOrderItems(event))
                .total(getTotal(event))
                .build();

        orderRepository.save(model);
    }

    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.items().stream()
                .map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private static List<OrderItemModel> getOrderItems(OrderCreatedEvent event) {
        return event.items().stream()
                .map(i -> OrderItemModel.builder()
                        .product(i.produto())
                        .quantity(i.quantidade())
                        .price(i.preco())
                        .build())
                .collect(Collectors.toList());
    }

    // New method to find paginated orders by customerId, mapped to OrderResponse
    public Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest) {
        Page<OrderModel> orderModels = orderRepository.findAllByCustomerId(customerId, pageRequest);
        List<OrderResponse> orderResponses = orderModels.getContent().stream()
                .map(OrderResponse::fromModel)
                .collect(Collectors.toList());
        return new PageImpl<>(orderResponses, pageRequest, orderModels.getTotalElements());
    }

    // New method to find total on orders by customerId using MongoDB aggregation
    public BigDecimal findTotalOnOrdersByCustomerId(Long customerId) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("customerId").is(customerId)),
                Aggregation.group().sum("total").as("totalSum")
        );
        AggregationResults<TotalResult> results = mongoTemplate.aggregate(aggregation, "orders", TotalResult.class);
        TotalResult result = results.getUniqueMappedResult();
        return result != null ? result.getTotalSum() : BigDecimal.ZERO;
    }

    // Helper class for aggregation result
    private static class TotalResult {
        private BigDecimal totalSum;

        public BigDecimal getTotalSum() {
            return totalSum;
        }

        public void setTotalSum(BigDecimal totalSum) {
            this.totalSum = totalSum;
        }
    }
}
