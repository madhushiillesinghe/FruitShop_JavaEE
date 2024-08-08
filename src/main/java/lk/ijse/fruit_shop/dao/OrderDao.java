package lk.ijse.fruit_shop.dao;

import lk.ijse.fruit_shop.dto.ItemDto;
import lk.ijse.fruit_shop.dto.OrderDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderDao extends CRUDDao<OrderDto>  {
      boolean saveOrder(OrderDto orderDto, Connection connection) throws SQLException;
}
