package lk.ijse.fruit_shop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class CustomerDto {
    private String id;
    private String  name;
    private String address;
    private double salary;
}
