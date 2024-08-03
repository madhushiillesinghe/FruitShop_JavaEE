package lk.ijse.fruit_shop.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import lk.ijse.fruit_shop.bo.impl.CustomerBoIMPL;
import lk.ijse.fruit_shop.dto.CustomerDto;


import java.sql.Connection;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer" , loadOnStartup = 2)
public class CustomerController extends HttpServlet {
    static Logger logger= LoggerFactory.getLogger(CustomerController.class);
    Connection connection;


    @Override
    public void init() throws ServletException {
        logger.info("Init Method invoked");

        try{
            var ctx = new InitialContext(); // connection pool eken connection ekk arahnn ekt
            DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/fruitManagement"); // cast krl ek datasource ekk hdgnnwa // lookup => apit eken puluwn eke nm dila mokkhri gnna apit ona de lokup krl gann ek cast krgnn jenaric nida
            this.connection = pool.getConnection(); // DataSource (connection pool ekkt)=> walin getconnection ekk
            logger.info("Connection Inizialize",this.connection);
        } catch ( SQLException | NamingException e) {
            e.printStackTrace();
        }

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        try (var writer = resp.getWriter()){
            Jsonb jsonb = JsonbBuilder.create();
            var customerBOIMPL = new CustomerBoIMPL();
            CustomerDto customer = jsonb.fromJson(req.getReader(), CustomerDto.class);
           // customer.setId(lk.ijse.fruit_shop.util.Utill.idGenerated());
            //Save data in the DB
            writer.write(customerBOIMPL.saveCustomer(customer,connection));
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Todo: Update Student
        try (var writer = resp.getWriter()) {
            var customerBOIMPL = new CustomerBoIMPL();
            var customerId = req.getParameter("customerId");
            Jsonb jsonb = JsonbBuilder.create();
            CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);
            if(customerBOIMPL.updateCustomer(customerId,customerDto,connection)){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }else {
                writer.write("Update failed");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(var writer = resp.getWriter()) {
            var customerBOIMPL = new CustomerBoIMPL();
            Jsonb jsonb = JsonbBuilder.create();
            //DB Process
            var customerId = req.getParameter("customerId");;
            resp.setContentType("application/json");
            jsonb.toJson(customerBOIMPL.getCustomer(customerId,connection),writer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Todo: Delete Student
        try (var writer = resp.getWriter()) {
            var customerId = req.getParameter("customerId");
            var customerBOIMPL = new CustomerBoIMPL();
            if(customerBOIMPL.deleteCustomer(customerId,connection)){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }else {
                writer.write("Delete failed");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
