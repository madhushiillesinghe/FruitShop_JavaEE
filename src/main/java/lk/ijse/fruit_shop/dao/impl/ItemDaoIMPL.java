package lk.ijse.fruit_shop.dao.impl;

import lk.ijse.fruit_shop.dao.ItemDao;
import lk.ijse.fruit_shop.dto.ItemDto;

import java.sql.Connection;
import java.sql.SQLException;

public class ItemDaoIMPL implements ItemDao {
    @Override
    public String saveItem(ItemDto itemDto, Connection connection) throws SQLException {
        return null;
    }

    @Override
    public boolean updateItem(String code, ItemDto itemDto, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteItem(String code, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public ItemDto getItem(String code, Connection connection) throws SQLException {
        return null;
    }
}
