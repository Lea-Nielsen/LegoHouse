package DBAccess;

import FunctionLayer.Order;
import FunctionLayer.exceptions.OrderException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leage
 */
public class OrderMapper {

    public static void createOrder(Order order, User user) throws OrderException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `order` (length, width, layers, user_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getLength());
            ps.setInt(2, order.getWidth());
            ps.setInt(3, order.getLayers());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static List<Order> getUserOrders(User user) throws OrderException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM `order` WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (rs.next()) {
                int orderId = rs.getInt("id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int layers = rs.getInt("layers");

                Order order = new Order(length, width, layers);
                order.setId(orderId);
                orders.add(order);
            }
            return orders;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static List<Order> getAllOrders() throws OrderException {

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM `order`";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (rs.next()) {
                int orderId = rs.getInt("id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int layers = rs.getInt("layers");

                Order order = new Order(length, width, layers);
                order.setId(orderId);
                orders.add(order);
            }
            return orders;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }

    }

    public static Order getOrderById(int orderId) throws OrderException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM `order` WHERE id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            Order order = null;
            while (rs.next()) {

                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int layers = rs.getInt("layers");
                boolean shipped = rs.getBoolean("shipped");

                order = new Order(length, width, layers, shipped);
                order.setId(orderId);
            }

            return order;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static Order shipOrder(Order order) throws OrderException {
        try {
            Connection con = Connector.connection();
            String sql = "UPDATE `order` SET `shipped`=? WHERE `id`=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, order.getId());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
        
        return order;
    }

}
