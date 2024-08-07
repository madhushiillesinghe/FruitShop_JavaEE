package lk.ijse.fruit_shop.dao;

import lk.ijse.fruit_shop.dto.OrderDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderDao {
    OrderDto selectOrderId(String orderId,Connection connection) throws SQLException;
    boolean saveOrder(OrderDto orderDto, Connection connection) throws SQLException;

    List<OrderDto> getAllOrder(Connection connection) throws SQLException;
}
