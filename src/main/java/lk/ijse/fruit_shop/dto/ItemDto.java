package lk.ijse.fruit_shop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ItemDto {
    private String code;
    private String description;
    private int quantity;
    private double price;
}
