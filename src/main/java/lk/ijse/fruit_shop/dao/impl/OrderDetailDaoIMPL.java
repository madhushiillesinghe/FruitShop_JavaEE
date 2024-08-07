package lk.ijse.fruit_shop.dao.impl;

import lk.ijse.fruit_shop.dao.OrderDetailDao;
import lk.ijse.fruit_shop.dto.OrderDetailDto;
import lk.ijse.fruit_shop.dto.OrderDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoIMPL implements OrderDetailDao {
    public  static String SAVE_ORDER_DETAIL="INSERT INTO order_detail (order_id,order_qty,item_code,unit_price) VALUES (?, ?, ?, ?)";
    public static String GET_ALL_ORDER_DETAIL="SELECT * FROM order_detail";

    @Override
    public boolean saveOrderDetail( OrderDetailDto orderDetailDto, Connection connection) throws SQLException {
        try{
            var ps=connection.prepareStatement(SAVE_ORDER_DETAIL);
            ps.setString(1,orderDetailDto.getOrderId());
            ps.setInt(2,orderDetailDto.getOrder_qty());
            ps.setString(3,orderDetailDto.getItemCode());
            ps.setDouble(4,orderDetailDto.getUnitPrice());
            if(ps.executeUpdate() != 0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public List<OrderDetailDto> getAllOrderDetail(Connection connection) throws SQLException {
        try{
            List<OrderDetailDto> orderDetailDtoList=new ArrayList<>();
            var ps=connection.prepareStatement(GET_ALL_ORDER_DETAIL);
            var rst=ps.executeQuery();
            while (rst.next()){
                OrderDetailDto orderDetailDto=new OrderDetailDto();
                orderDetailDto.setOrderId(rst.getString("order_id"));
                orderDetailDto.setOrder_qty(rst.getInt("order_qty "));
                orderDetailDto.setItemCode(rst.getString("item_code"));
                orderDetailDto.setUnitPrice(rst.getDouble("unit_price"));
                orderDetailDtoList.add(orderDetailDto);
            }
            System.out.println("Order Detail"+orderDetailDtoList);
            return orderDetailDtoList;
        } catch (Exception e) {
            throw new SQLException(e.getMessage());

        }    }
}
