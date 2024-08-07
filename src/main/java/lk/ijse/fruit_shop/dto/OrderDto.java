package lk.ijse.fruit_shop.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class OrderDto {
    private String orderId;
    private String date;
    private String customerId;
    private List<ItemDto> itemDtoList;
    private double total;
    private String discount;
    private double subTotal;
    private double cash;
    private double balance;
}
