package lk.ijse.fruit_shop.bo;

import lk.ijse.fruit_shop.bo.impl.CustomerBoIMPL;
import lk.ijse.fruit_shop.bo.impl.ItemBoIMPL;
import lk.ijse.fruit_shop.bo.impl.PlaceOrderBoIMPL;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }

    public static SuperBo getBo(BOType boType){
        switch (boType){
            case CUSTOM:return new CustomerBoIMPL();
            case ITEM:return  new ItemBoIMPL();
            case PLACEORDER:return  new PlaceOrderBoIMPL();
            default: return null;
        }

    }
    public enum BOType{
        CUSTOM,ITEM,PLACEORDER
    }
}
