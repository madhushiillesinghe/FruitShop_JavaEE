package lk.ijse.fruit_shop.dao.impl;

import lk.ijse.fruit_shop.dao.CustomerDao;
import lk.ijse.fruit_shop.dto.CustomerDto;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerDaoIMPL implements CustomerDao {

    public  static String SAVE_CUSTOMER="INSERT INTO customer (id,name,address,salary) VALUES (?, ?, ?, ?)";
    public static String GET_CUSTOMER = "SELECT * FROM customer WHERE id = ?";
    public static  String UPDATE_CUSTOMER="UPDATE customer SET name= ?,address=?,salary=? WHERE id=?";
    public static String DELETE_CUSTOMER = "DELETE FROM customer WHERE id = ?";

    @Override
    public String saveCustomer(CustomerDto customerDto, Connection connection) throws SQLException {
        try {
            var ps = connection.prepareStatement(SAVE_CUSTOMER);
            ps.setString(1, customerDto.getId());
            ps.setString(2, customerDto.getName());
            ps.setString(3, customerDto.getAddress());
            ps.setDouble(4, customerDto.getSalary());
            if(ps.executeUpdate() != 0){
                return "Customer Save Successfully";
            }else {
                return "Failed to Save Customer";
            }
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public boolean updateCustomer(String id, CustomerDto customerDto, Connection connection) throws SQLException {
        try {
            var ps = connection.prepareStatement(UPDATE_CUSTOMER);
            ps.setString(1, customerDto.getName());
            ps.setString(2, customerDto.getAddress());
            ps.setDouble(3, customerDto.getSalary());
            ps.setString(4, id);
            return ps.executeUpdate() != 0;
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public boolean deleteCustomer(String id, Connection connection) throws SQLException {
        var ps = connection.prepareStatement(DELETE_CUSTOMER);
        ps.setString(1, id);
        return ps.executeUpdate() != 0;
    }

    @Override
    public CustomerDto getCustomer(String id, Connection connection) throws SQLException {
        try {
            CustomerDto customerDto= new CustomerDto();
            var ps = connection.prepareStatement(GET_CUSTOMER);
            ps.setString(1, id);
            var rst = ps.executeQuery();
            while (rst.next()){
                customerDto.setId(rst.getString("id"));
                customerDto.setName(rst.getString("name"));
                customerDto.setAddress(rst.getString("address"));
                customerDto.setSalary(rst.getDouble("salary"));
            }
            return customerDto;
        }catch (Exception e){
            throw new SQLException(e.getMessage());
        }
    }
    }
