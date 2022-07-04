package com.jecrc.cheggbookmanagement.model.requests;


import com.jecrc.cheggbookmanagement.model.entities.OrderStatus;
import com.jecrc.cheggbookmanagement.model.entities.Orders;
import lombok.*;

import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderRequestDto {

    @Positive
    double cost;

    String orderStatus;

    String orderReferenceId;


}
