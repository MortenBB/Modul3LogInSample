package FunctionLayer;

import DBAccess.OrderMapper;
import javax.servlet.http.HttpSession;
import DBAccess.UserMapper;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static Order createOrder(int lBricks, int mBricks, int sBricks, User u) throws SQLException, ClassNotFoundException {
        Order order = new Order(sBricks, mBricks, lBricks, false);
        OrderMapper.createOrder(order, u);
        return order;
    }

    public static ArrayList<Order> getOrders() throws ClassNotFoundException, SQLException {
        return OrderMapper.getOrders();
    }

    public static ArrayList<Order> getOrders(User u) throws ClassNotFoundException, SQLException {
        return OrderMapper.getOrders(u);
    }

    public static void updateOrder(int id) throws ClassNotFoundException, SQLException {
        OrderMapper.updateOrder(id);
    }
}
