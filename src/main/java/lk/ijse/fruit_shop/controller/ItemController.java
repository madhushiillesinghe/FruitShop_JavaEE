package lk.ijse.fruit_shop.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.fruit_shop.bo.BOFactory;
import lk.ijse.fruit_shop.bo.CustomerBo;
import lk.ijse.fruit_shop.bo.ItemBo;
import lk.ijse.fruit_shop.bo.impl.CustomerBoIMPL;
import lk.ijse.fruit_shop.bo.impl.ItemBoIMPL;
import lk.ijse.fruit_shop.dto.CustomerDto;
import lk.ijse.fruit_shop.dto.ItemDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/item" , loadOnStartup = 2)
public class ItemController extends HttpServlet {

    static Logger logger= LoggerFactory.getLogger(ItemController.class);
    Connection connection;
    ItemBo itemBOIMPL= (ItemBo) BOFactory.getBoFactory().getBo(BOFactory.BOType.ITEM);

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
        if(req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        try (var writer = resp.getWriter()){
            Jsonb jsonb = JsonbBuilder.create();
            ItemDto item = jsonb.fromJson(req.getReader(), ItemDto.class);
           // item.setCode(lk.ijse.fruit_shop.util.Utill.idGenerated());
            //Save data in the DB
            writer.write(itemBOIMPL.saveItem(item,connection));
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
            var itemCode = req.getParameter("itemCode");
            Jsonb jsonb = JsonbBuilder.create();
            ItemDto itemDto = jsonb.fromJson(req.getReader(), ItemDto.class);
            if(itemBOIMPL.updateItem(itemCode,itemDto,connection)){
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
        var itemCode = req.getParameter("itemCode");
        try(var writer = resp.getWriter()) {

            Jsonb jsonb = JsonbBuilder.create();
            resp.setContentType("application/json");

            if (itemCode != null) {
                jsonb.toJson(itemBOIMPL.getItem(itemCode,connection), writer);
                resp.setStatus(HttpServletResponse.SC_OK);
                logger.info("Item Retrieved Successfully");
            } else {
                jsonb.toJson(itemBOIMPL.getAllItem(connection), writer);
                resp.setStatus(HttpServletResponse.SC_OK);
                logger.info("All Items Retrieved Successfully");
            }
        } catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error("Error while retrieving Customer", e);
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Todo: Delete Student
        try (var writer = resp.getWriter()) {
            var itemCode = req.getParameter("itemCode");
            if(itemBOIMPL.deleteItem(itemCode,connection)){
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
