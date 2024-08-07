package lk.ijse.fruit_shop.bo;

import lk.ijse.fruit_shop.dto.CustomerDto;
import lk.ijse.fruit_shop.dto.ItemDto;
import lk.ijse.fruit_shop.dto.OrderDetailDto;
import lk.ijse.fruit_shop.dto.OrderDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBo {
    boolean saveOrder(OrderDto orderDto, Connection connection) throws SQLException, ClassNotFoundException;
    List<OrderDto> getAllOrder(Connection connection) throws SQLException;

}
