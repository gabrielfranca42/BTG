package btg.model;


import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderItemModel {

    private String product;
    private Integer quantity;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal price;

    // Construtor vazio
    public OrderItemModel() {
    }

    // Construtor com todos os campos
    public OrderItemModel(String product, Integer quantity, BigDecimal price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters e Setters
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // Builder manual
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String product;
        private Integer quantity;
        private BigDecimal price;

        public Builder product(String product) {
            this.product = product;
            return this;
        }

        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public OrderItemModel build() {
            return new OrderItemModel(product, quantity, price);
        }
    }

    // equals, hashCode e toString (opcional)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemModel)) return false;
        OrderItemModel that = (OrderItemModel) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, price);
    }

    @Override
    public String toString() {
        return "OrderItemModel{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
