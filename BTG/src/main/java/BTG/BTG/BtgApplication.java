package BTG.BTG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.OderItemModel;
import model.OderModel;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import repository.OderRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "repository")
public class BtgApplication {

    public static void main(String[] args) {
        SpringApplication.run(BtgApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(OderRepository repo) {
        return args -> {
            OderItemModel item = OderItemModel.builder()
                    .product("Produto Exemplo")
                    .quantity(2)
                    .price(new BigDecimal("59.90"))
                    .build();

            OderModel order = OderModel.builder()
                    .oderId(1L)
                    .customerId(100L)
                    .total(new BigDecimal("119.80"))
                    .items(List.of(item))
                    .build();

            repo.save(order);
            System.out.println("✅ Pedido salvo no MongoDB!");
        };
    }
}
