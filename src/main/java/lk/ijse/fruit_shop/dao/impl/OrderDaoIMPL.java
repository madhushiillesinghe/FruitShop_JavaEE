package lk.ijse.fruit_shop.dao.impl;

import lk.ijse.fruit_shop.dao.OrderDao;
import lk.ijse.fruit_shop.dto.OrderDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoIMPL implements OrderDao {

    public  static String GET_ORDER="SELECT order_id FROM orders  WHERE order_id= ?";
    public  static String GET_ALL_ORDER="SELECT * FROM orders";

    public static String SAVE_ORDER="INSERT INTO  orders (order_id,date,customer_id,total,discount,sub_total, cash,balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";

    @Override
    public String save(OrderDto dto, Connection connection) throws SQLException {
        return null;
    }

    @Override
    public boolean update(String code, OrderDto dto, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String code, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public OrderDto get(String orderId,Connection connection) throws SQLException {
        try{
            OrderDto orderDto=new OrderDto();
            var ps=connection.prepareStatement(GET_ORDER);
            ps.setString(1,orderId);
            var rst=ps.executeQuery();
            while (rst.next()){
                orderDto.setOrderId(rst.getString("order_id "));
                orderDto.setDate(rst.getString("date "));
                orderDto.setCustomerId(rst.getString("customer_id"));
                orderDto.setTotal(rst.getDouble("total "));
                orderDto.setDiscount(rst.getString("discount"));
                orderDto.setSubTotal(rst.getDouble("sub_total "));
                orderDto.setCash(rst.getDouble("cash"));
                orderDto.setBalance(rst.getDouble("balance"));
            }
            return orderDto;
        } catch (Exception e) {
            throw new SQLException(e.getMessage());

        }
    }

    @Override
    public boolean saveOrder(OrderDto orderDto, Connection connection) throws SQLException {
        System.out.println(orderDto + " =====DtoInDAO=====");
        try{
            var ps=connection.prepareStatement(SAVE_ORDER);
            ps.setString(1,orderDto.getOrderId());
            ps.setString(2, orderDto.getDate());
            ps.setString(3,orderDto.getCustomerId());
            ps.setDouble(4,orderDto.getTotal());
            ps.setString(5,orderDto.getDiscount());
            ps.setDouble(6,orderDto.getSubTotal());
            ps.setDouble(7,orderDto.getCash());
            ps.setDouble(8,orderDto.getBalance());
            if(ps.executeUpdate() !=0) {
                System.out.println("Save success");
                return true;

            }else {

                return false;
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public List<OrderDto> getAll(Connection connection) throws SQLException {
        try{
            List<OrderDto> orderDtoList=new ArrayList<>();
            var ps=connection.prepareStatement(GET_ALL_ORDER);
            var rst=ps.executeQuery();
            while (rst.next()){
                OrderDto orderDto=new OrderDto();
                orderDto.setOrderId(rst.getString("order_id"));
                orderDto.setDate(rst.getString("date"));
                orderDto.setCustomerId(rst.getString("customer_id"));
                orderDto.setTotal(rst.getDouble("total"));
                orderDto.setDiscount(rst.getString("discount"));
                orderDto.setSubTotal(rst.getDouble("sub_total"));
                orderDto.setCash(rst.getDouble("cash"));
                orderDto.setBalance(rst.getDouble("balance"));

                orderDtoList.add(orderDto);
            }
            System.out.println("Order"+orderDtoList);
            return orderDtoList;
        } catch (Exception e) {
            throw new SQLException(e.getMessage());

        }
    }


}
