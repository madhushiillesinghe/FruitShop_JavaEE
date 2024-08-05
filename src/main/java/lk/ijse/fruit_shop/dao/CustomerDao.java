package lk.ijse.fruit_shop.dao;

import lk.ijse.fruit_shop.dto.CustomerDto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
        String saveCustomer(CustomerDto customerDto, Connection connection) throws SQLException;

        boolean updateCustomer(String id, CustomerDto customerDto, Connection connection) throws SQLException;

        boolean deleteCustomer(String id, Connection connection) throws SQLException;

        CustomerDto getCustomer(String id, Connection connection) throws SQLException;

        List<CustomerDto> getAllCustomers(Connection connection) throws SQLException;
}