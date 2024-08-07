package lk.ijse.fruit_shop.dao;

import lk.ijse.fruit_shop.dto.OrderDetailDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDao extends SuperDao{
    boolean saveOrderDetail( OrderDetailDto orderDetailDto, Connection connection) throws SQLException;
    List<OrderDetailDto> getAllOrderDetail(Connection connection) throws SQLException;

}
