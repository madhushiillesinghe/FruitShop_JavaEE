package lk.ijse.fruit_shop.bo.impl;

import lk.ijse.fruit_shop.bo.PlaceOrderBo;

import lk.ijse.fruit_shop.dao.DAOFactory;
import lk.ijse.fruit_shop.dao.ItemDao;
import lk.ijse.fruit_shop.dao.OrderDao;
import lk.ijse.fruit_shop.dao.OrderDetailDao;
import lk.ijse.fruit_shop.dao.impl.ItemDaoIMPL;
import lk.ijse.fruit_shop.dao.impl.OrderDaoIMPL;
import lk.ijse.fruit_shop.dao.impl.OrderDetailDaoIMPL;
import lk.ijse.fruit_shop.dto.ItemDto;
import lk.ijse.fruit_shop.dto.OrderDetailDto;
import lk.ijse.fruit_shop.dto.OrderDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PlaceOrderBoIMPL implements PlaceOrderBo {
    OrderDao orderDaoImpl= (OrderDao) DAOFactory.getDADFactory().getDao(DAOFactory.DADType.ORDER);
    OrderDetailDao orderDetailDaoImpl= (OrderDetailDao) DAOFactory.getDADFactory().getDao(DAOFactory.DADType.ORDERDETAIL);


    @Override
    public boolean saveOrder(OrderDto orderDto,Connection connection) throws SQLException {

        boolean isOrderSaved;
        boolean isItemUpdated = false;
        boolean isOrderDetailSaved = false;


        connection.setAutoCommit(false);
        isOrderSaved = orderDaoImpl.saveOrder(orderDto, connection);
        if (!(isOrderSaved)) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }
//        List<OrderDetailDto> orderDetails=orderDetailDaoImpl.getAllOrderDetail(connection);
        for (ItemDto itemDto: orderDto.getItemDtoList()) {
            isOrderDetailSaved = orderDetailDaoImpl.saveOrderDetail(new OrderDetailDto(
                    orderDto.getOrderId(),
                    itemDto.getQuantity() ,
                    itemDto.getCode(),
                    itemDto.getPrice()),connection);
            if (!(isOrderDetailSaved)) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
//            ItemDto itemDtoList = itemdaoimpl.getItem(itemDto.getCode(), connection);
//            itemDtoList.setQuantity(itemDtoList.getQuantity() - itemDto.getQuantity());
//            isItemUpdated = itemdaoimpl.updateItem(itemDto.getCode(), itemDto,connection);
//            if (!(isItemUpdated)) {
//                connection.rollback();
//                connection.setAutoCommit(true);
//                return false;
//            }
        }
        if (isOrderSaved && isOrderDetailSaved ) {
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        }
        return false;

    }

    @Override
    public List<OrderDto> getAllOrder(Connection connection) throws SQLException {
        var orderDaoIMPL = new OrderDaoIMPL();
        return orderDaoIMPL.getAll( connection);
    }

}
