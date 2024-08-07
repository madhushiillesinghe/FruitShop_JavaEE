package lk.ijse.fruit_shop.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter

public class OrderRequestDto {
    private OrderDto order;
    private List<OrderDetailDto> orderDetails;

}
