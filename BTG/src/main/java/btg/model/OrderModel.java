package btg.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Document
public class OrderModel {

    @MongoId
    private Long orderId;

    @Indexed(name = "customer_id_index")
    private Long customerId;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal total;

    private List<OrderItemModel> items;

    // Construtor vazio
    public OrderModel() {
    }

    // Construtor completo
    public OrderModel(Long orderId, Long customerId, BigDecimal total, List<OrderItemModel> items) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.total = total;
        this.items = items;
    }

    // Getters e Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<OrderItemModel> getItems() {
        return items;
    }

    public void setItems(List<OrderItemModel> items) {
        this.items = items;
    }

    // Builder manual
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long orderId;
        private Long customerId;
        private BigDecimal total;
        private List<OrderItemModel> items;

        public Builder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder customerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder total(BigDecimal total) {
            this.total = total;
            return this;
        }

        public Builder items(List<OrderItemModel> items) {
            this.items = items;
            return this;
        }

        public OrderModel build() {
            return new OrderModel(orderId, customerId, total, items);
        }
    }

    // equals, hashCode e toString (opcional)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderModel)) return false;
        OrderModel that = (OrderModel) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(total, that.total) &&
                Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, total, items);
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", total=" + total +
                ", items=" + items +
                '}';
    }
}
