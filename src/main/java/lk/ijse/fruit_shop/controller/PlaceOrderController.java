package lk.ijse.fruit_shop.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import lk.ijse.fruit_shop.bo.BOFactory;
import lk.ijse.fruit_shop.bo.PlaceOrderBo;
import lk.ijse.fruit_shop.bo.impl.PlaceOrderBoIMPL;
import lk.ijse.fruit_shop.dto.OrderDetailDto;
import lk.ijse.fruit_shop.dto.OrderDto;
import lk.ijse.fruit_shop.dto.OrderRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@WebServlet(urlPatterns = "/placeOrder",loadOnStartup = 2)
public class PlaceOrderController extends HttpServlet {
    static Logger logger= LoggerFactory.getLogger(PlaceOrderController.class);
    Connection connection;
    PlaceOrderBo placeOrderBoImpl= (PlaceOrderBo) BOFactory.getBoFactory().getBo(BOFactory.BOType.PLACEORDER);

    @Override
    public void init() throws ServletException {
        logger.info("Init Method invoked");

        try{
            var ctx = new InitialContext(); // connection pool eken connection ekk arahnn ekt
            DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/fruitManagement"); // cast krl ek datasource ekk hdgnnwa // lookup => apit eken puluwn eke nm dila mokkhri gnna apit ona de lokup krl gann ek cast krgnn jenaric nida
            this.connection = pool.getConnection(); // DataSource (connection pool ekkt)=> walin getconnection ekk
            logger.info("Connection Inizialize",this.connection);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getContentType() ==null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            logger.info("Request not matches");
        }
        try(var writer=resp.getWriter()){
           Jsonb jsonb=JsonbBuilder.create();
           OrderDto orderDto=jsonb.fromJson(req.getReader(), OrderDto.class);
            System.out.println(orderDto + "====In=Controller");
            writer.write(String.valueOf(placeOrderBoImpl.saveOrder(orderDto,connection)));
           resp.setStatus(HttpServletResponse.SC_CREATED);
           logger.info("Order Successfully");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.info("Error while saving order");
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try(var writer=resp.getWriter()){
            Jsonb jsonb=JsonbBuilder.create();
            resp.setContentType("application/json");

            jsonb.toJson(placeOrderBoImpl.getAllOrder(connection), writer);
            resp.setStatus(HttpServletResponse.SC_OK);
            logger.info("All order Retrieved Successfully");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.info("Error while get order");
            e.printStackTrace();
        }
    }
}
