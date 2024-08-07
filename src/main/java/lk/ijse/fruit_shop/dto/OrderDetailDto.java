package lk.ijse.fruit_shop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class OrderDetailDto {
    private String orderId;
    private  int order_qty;
    private String itemCode;
    private double unitPrice;
}
