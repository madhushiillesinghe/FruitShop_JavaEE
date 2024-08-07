package lk.ijse.fruit_shop.bo.impl;

import lk.ijse.fruit_shop.bo.CustomerBo;
import lk.ijse.fruit_shop.dao.CustomerDao;
import lk.ijse.fruit_shop.dao.DAOFactory;
import lk.ijse.fruit_shop.dao.impl.CustomerDaoIMPL;
import lk.ijse.fruit_shop.dto.CustomerDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerBoIMPL implements CustomerBo {

    CustomerDao customerDaoIMPL= (CustomerDao) DAOFactory.getDADFactory().getDao(DAOFactory.DADType.CUSTOMER);

    @Override
    public String saveCustomer(CustomerDto customerDto, Connection connection) throws SQLException {
        return customerDaoIMPL.save(customerDto, connection);
    }

    @Override
    public boolean updateCustomer(String id, CustomerDto customerDto, Connection connection) throws SQLException {
        return customerDaoIMPL.update(id, customerDto, connection);
    }

    @Override
    public boolean deleteCustomer(String id, Connection connection) throws SQLException {
        return customerDaoIMPL.delete(id, connection);
    }

    @Override
    public CustomerDto getCustomer(String id, Connection connection) throws SQLException {
        return customerDaoIMPL.get(id, connection);
    }

    @Override
    public List<CustomerDto> getAllCustomers(Connection connection) throws SQLException {
        return customerDaoIMPL.getAll( connection);
    }


}
