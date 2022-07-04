package com.jecrc.cheggbookmanagement.model.requests;

import com.jecrc.cheggbookmanagement.model.entities.OrderStatus;
import com.jecrc.cheggbookmanagement.model.entities.Orders;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequestDto {

    @Positive
    double cost;

    @NotBlank
    String orderStatus;

    public Orders toOrder(){
        return Orders.builder()
                .orderReference(UUID.randomUUID().toString())
                .cost(cost)
                .orderStatus(OrderStatus.valueOf(orderStatus))
                .build();
    }
}
