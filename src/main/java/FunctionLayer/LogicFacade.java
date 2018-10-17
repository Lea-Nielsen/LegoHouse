package FunctionLayer;

import FunctionLayer.exceptions.LoginException;
import FunctionLayer.exceptions.OrderException;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import FunctionLayer.exceptions.RegisterException;
import java.util.List;

public class LogicFacade {

    public static User login(String email, String password) throws LoginException {

        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws RegisterException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static Order createOrder(int length, int width, int layers, User user) throws OrderException {
        Order order = new Order(length, width, layers);
        OrderMapper.createOrder(order, user);
        return order;
    }

    public static LegoHouse getHouse(int length, int width, int layers) {
        Logic calc = new Logic();
        LegoHouse house = calc.getHouse(length, width, layers);
        return house;

    }

    public static Order getOrderById(int orderId, User user) throws OrderException {
        Order order = OrderMapper.getOrderById(orderId);
        return order;
    }

    public static int getAllBricksForLegoHouse(LegoHouseLayer layer, Order order) {
        Logic calc = new Logic();
        int allBricks = calc.getAllBricksForLegoHouse(layer, order);
        return allBricks;
    }

    public static List<Order> getUserOrder(User user) throws OrderException {
        List<Order> orders;
        orders = OrderMapper.getUserOrders(user);
        return orders;
    }

    public static LegoHouseLayer getSingleLayer(LegoHouse house) {
        Logic calc = new Logic();
        LegoHouseLayer layer = calc.getSingleLayer(house);
        return layer;

    }

    public static List<Order> getAllOrders() throws OrderException {
        List<Order> orders;
        orders = OrderMapper.getAllOrders();
        return orders;
    }

    public static Order shipOrder(Order order) throws OrderException {
        OrderMapper.shipOrder(order);
        return order;

    }

}
