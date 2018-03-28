/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Morten
 */
public class OrderMapper {

    public static void createOrder(Order order, User user) throws SQLException, ClassNotFoundException {

        Connection con = Connector.connection();
        String SQL = "INSERT INTO orders (id, SBrick, MBrick, LBrick, status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, user.getId());
        ps.setInt(2, order.getSBrick());
        ps.setInt(3, order.getMBrick());
        ps.setInt(4, order.getLBrick());
        ps.setBoolean(5, order.getStatus());
        ps.executeUpdate();
        ResultSet ids = ps.getGeneratedKeys();
        ids.next();
        int id = ids.getInt(1);
        order.setId(id);
    }

    public static ArrayList<Order> getOrders() throws ClassNotFoundException, SQLException {
        ArrayList<Order> orders = new ArrayList();
        Connection con = Connector.connection();
        String SQL = "SELECT * FROM orders";
        PreparedStatement ps = con.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("order_id");
            int SBricks = rs.getInt("SBrick");
            int MBricks = rs.getInt("MBrick");
            int LBricks = rs.getInt("LBrick");
            boolean status = rs.getBoolean("status");
            Order order = new Order(id, SBricks, MBricks, LBricks, status);
            orders.add(order);
        }
        return orders;
    }

    public static ArrayList<Order> getOrders(User u) throws ClassNotFoundException, SQLException {
        int id = u.getId();
        ArrayList<Order> orders = new ArrayList();
        Connection con = Connector.connection();
        String SQL = "SELECT * FROM orders " + "WHERE id=?";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int orderId = rs.getInt("id");
            int SBricks = rs.getInt("SBrick");
            int MBricks = rs.getInt("MBrick");
            int LBricks = rs.getInt("LBrick");
            boolean status = rs.getBoolean("status");
            Order order = new Order(orderId, SBricks, MBricks, LBricks, status);
            orders.add(order);
        }
        return orders;
    }

    public static void updateOrder(int id) throws ClassNotFoundException, SQLException {
        Connection con = Connector.connection();
        String SQL = "update orders set status = ? where order_id = ?";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setBoolean(1, true);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

}
