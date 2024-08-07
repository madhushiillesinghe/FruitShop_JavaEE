package lk.ijse.fruit_shop.dao;

import lk.ijse.fruit_shop.dto.CustomerDto;
import lk.ijse.fruit_shop.dto.ItemDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ItemDao {
    String saveItem(ItemDto itemDto, Connection connection) throws SQLException;
    boolean updateItem(String code,ItemDto itemDto,Connection connection) throws SQLException;
    boolean deleteItem(String code,Connection connection) throws SQLException;
    ItemDto getItem(String code,Connection connection) throws SQLException;
    List<ItemDto> getAllItems(Connection connection) throws SQLException;

}
