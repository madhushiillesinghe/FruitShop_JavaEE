package lk.ijse.fruit_shop.dao.impl;

import lk.ijse.fruit_shop.dao.ItemDao;
import lk.ijse.fruit_shop.dto.CustomerDto;
import lk.ijse.fruit_shop.dto.ItemDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoIMPL implements ItemDao {

    public  static String SAVE_ITEM="INSERT INTO item (code,description,quantity,price) VALUES (?, ?, ?, ?)";
    public static String GET_ITEM = "SELECT * FROM item WHERE code = ?";
    public static  String UPDATE_ITEM="UPDATE item SET description= ?,quantity=?,price=? WHERE code=?";
    public static String DELETE_ITEM = "DELETE FROM item WHERE code= ?";
    public static String GET_ALL_ITEM="SELECT * FROM item";

    @Override
    public String save(ItemDto itemDto, Connection connection) throws SQLException {
        try {
            var ps = connection.prepareStatement(SAVE_ITEM);
            ps.setString(1, itemDto.getCode());
            ps.setString(2, itemDto.getDescription());
            ps.setInt(3, itemDto.getQuantity());
            ps.setDouble(4, itemDto.getPrice());
            if(ps.executeUpdate() != 0){
                return "Item Save Successfully";
            }else {
                return "Failed to Save Item";
            }
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public boolean update(String code, ItemDto itemDto, Connection connection) throws SQLException {
        try {
            var ps = connection.prepareStatement(UPDATE_ITEM);
            ps.setString(1, itemDto.getDescription());
            ps.setInt(2, itemDto.getQuantity());
            ps.setDouble(3, itemDto.getPrice());
            ps.setString(4, code);
            return ps.executeUpdate() != 0;
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public boolean delete(String code, Connection connection) throws SQLException {
        var ps = connection.prepareStatement(DELETE_ITEM);
        ps.setString(1, code);
        return ps.executeUpdate() != 0;
    }

    @Override
    public ItemDto get(String code, Connection connection) throws SQLException {
        try {
                ItemDto itemDto= new ItemDto();
            var ps = connection.prepareStatement(GET_ITEM);
            ps.setString(1, code);
            var rst = ps.executeQuery();
            while (rst.next()){
                itemDto.setCode(rst.getString("code"));
                itemDto.setDescription(rst.getString("description"));
                itemDto.setQuantity(rst.getInt("quantity"));
                itemDto.setPrice(rst.getDouble("price"));
            }
            return itemDto;
        }catch (Exception e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public List<ItemDto> getAll(Connection connection) throws SQLException {
        try {
            List<ItemDto> itemDtolist = new ArrayList<>();
            var ps = connection.prepareStatement(GET_ALL_ITEM);
            var rst = ps.executeQuery();
            while (rst.next()) {
                ItemDto itemDto = new ItemDto();
                itemDto.setCode(rst.getString("code"));
                itemDto.setDescription(rst.getString("description"));
                itemDto.setQuantity(rst.getInt("quantity"));
                itemDto.setPrice(rst.getDouble("price"));
                itemDtolist.add(itemDto);

            }
            System.out.println("Item"+itemDtolist);
            return itemDtolist;

        } catch (Exception e) {
            throw new SQLException(e.getMessage());

        }
    }
}
