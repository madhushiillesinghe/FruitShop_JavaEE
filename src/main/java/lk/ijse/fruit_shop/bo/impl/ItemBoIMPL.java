package lk.ijse.fruit_shop.bo.impl;

import lk.ijse.fruit_shop.bo.ItemBo;
import lk.ijse.fruit_shop.dao.impl.CustomerDaoIMPL;
import lk.ijse.fruit_shop.dao.impl.ItemDaoIMPL;
import lk.ijse.fruit_shop.dto.ItemDto;

import java.sql.Connection;
import java.sql.SQLException;

public class ItemBoIMPL implements ItemBo {
    @Override
    public String saveItem(ItemDto itemDto, Connection connection) throws SQLException {
        var itemDaoIMPL = new ItemDaoIMPL();
        return itemDaoIMPL.saveItem(itemDto, connection);
    }

    @Override
    public boolean updateItem(String code, ItemDto itemDto, Connection connection) throws SQLException {
        var itemDaoIMPL = new ItemDaoIMPL();
        return itemDaoIMPL.updateItem(code, itemDto, connection);
    }

    @Override
    public boolean deleteItem(String code, Connection connection) throws SQLException {
        var itemDaoIMPL = new ItemDaoIMPL();
        return itemDaoIMPL.deleteItem(code, connection);
    }

    @Override
    public ItemDto getItem(String code, Connection connection) throws SQLException {
        var itemDaoIMPL = new ItemDaoIMPL();
        return itemDaoIMPL.getItem(code, connection);
    }
}
