package lk.ijse.fruit_shop.bo.impl;

import lk.ijse.fruit_shop.bo.CustomerBo;
import lk.ijse.fruit_shop.dao.impl.CustomerDaoIMPL;
import lk.ijse.fruit_shop.dto.CustomerDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerBoIMPL implements CustomerBo {
    @Override
    public String saveCustomer(CustomerDto customerDto, Connection connection) throws SQLException {
        var customerDaoIMPL = new CustomerDaoIMPL();
        return customerDaoIMPL.saveCustomer(customerDto, connection);
    }

    @Override
    public boolean updateCustomer(String id, CustomerDto customerDto, Connection connection) throws SQLException {
        var customerDAOIMPL = new CustomerDaoIMPL();
        return customerDAOIMPL.updateCustomer(id, customerDto, connection);
    }

    @Override
    public boolean deleteCustomer(String id, Connection connection) throws SQLException {
        var customerDAOIMPL = new CustomerDaoIMPL();
        return customerDAOIMPL.deleteCustomer(id, connection);
    }

    @Override
    public CustomerDto getCustomer(String id, Connection connection) throws SQLException {
        var customerDAOIMPL = new CustomerDaoIMPL();
        return customerDAOIMPL.getCustomer(id, connection);
    }

    @Override
    public List<CustomerDto> getAllCustomers(Connection connection) throws SQLException {
        var customerDAOIMPL = new CustomerDaoIMPL();
        return customerDAOIMPL.getAllCustomers( connection);
    }


}
