package lk.ijse.fruit_shop.bo;

import lk.ijse.fruit_shop.dto.CustomerDto;
import lk.ijse.fruit_shop.dto.ItemDto;

import java.sql.Connection;
import java.sql.SQLException;

public interface ItemBo {
    String saveItem(ItemDto itemDto, Connection connection) throws SQLException;
    boolean updateItem(String code,ItemDto itemDto,Connection connection) throws SQLException;
    boolean deleteItem(String code,Connection connection) throws SQLException;
    ItemDto getItem(String code,Connection connection) throws SQLException;
}
