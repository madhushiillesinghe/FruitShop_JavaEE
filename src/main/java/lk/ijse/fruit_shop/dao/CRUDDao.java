package lk.ijse.fruit_shop.dao;

import lk.ijse.fruit_shop.dto.ItemDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CRUDDao <T> extends SuperDao{
    String save(T dto, Connection connection) throws SQLException;
    boolean update(String code,T dto,Connection connection) throws SQLException;
    boolean delete(String code,Connection connection) throws SQLException;
    T get(String code,Connection connection) throws SQLException;
    List<T> getAll(Connection connection) throws SQLException;
}
