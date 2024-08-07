package lk.ijse.fruit_shop.bo.impl;

import lk.ijse.fruit_shop.bo.ItemBo;
import lk.ijse.fruit_shop.dao.DAOFactory;
import lk.ijse.fruit_shop.dao.ItemDao;
import lk.ijse.fruit_shop.dao.impl.CustomerDaoIMPL;
import lk.ijse.fruit_shop.dao.impl.ItemDaoIMPL;
import lk.ijse.fruit_shop.dto.ItemDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ItemBoIMPL implements ItemBo {

    ItemDao itemDaoIMPL= (ItemDao) (ItemDao) DAOFactory.getDADFactory().getDao(DAOFactory.DADType.ITEM);

    @Override
    public String saveItem(ItemDto itemDto, Connection connection) throws SQLException {
        return itemDaoIMPL.save(itemDto, connection);
    }

    @Override
    public boolean updateItem(String code, ItemDto itemDto, Connection connection) throws SQLException {
        return itemDaoIMPL.update(code, itemDto, connection);
    }

    @Override
    public boolean deleteItem(String code, Connection connection) throws SQLException {
        return itemDaoIMPL.delete(code, connection);
    }

    @Override
    public ItemDto getItem(String code, Connection connection) throws SQLException {
        return itemDaoIMPL.get(code, connection);
    }

    @Override
    public List<ItemDto> getAllItem(Connection connection) throws SQLException {
        return itemDaoIMPL.getAll( connection);
    }
}
