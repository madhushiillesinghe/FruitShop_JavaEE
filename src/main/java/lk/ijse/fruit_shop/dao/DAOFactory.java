package lk.ijse.fruit_shop.dao;

import lk.ijse.fruit_shop.dao.impl.CustomerDaoIMPL;
import lk.ijse.fruit_shop.dao.impl.ItemDaoIMPL;
import lk.ijse.fruit_shop.dao.impl.OrderDaoIMPL;
import lk.ijse.fruit_shop.dao.impl.OrderDetailDaoIMPL;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getDADFactory (){
        return (daoFactory==null) ? daoFactory=new DAOFactory():daoFactory;
    }
    public enum DADType{
        CUSTOMER,ITEM,ORDER,ORDERDETAIL
    }
    public SuperDao getDao(DADType dadType) {
        switch (dadType) {
            case CUSTOMER: return new CustomerDaoIMPL();
            case  ITEM:return new ItemDaoIMPL();
            case ORDER:return new OrderDaoIMPL();
            case ORDERDETAIL:return new OrderDetailDaoIMPL();
            default:return null;
        }
    }
}
