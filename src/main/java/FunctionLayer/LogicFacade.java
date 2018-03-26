package FunctionLayer;

import javax.servlet.http.HttpSession;
import DBAccess.UserMapper;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
    public static Order createOrder(int lBricks, int mBricks, int sBricks, User u) throws LoginSampleException{
        Order order = new Order(sBricks, mBricks, lBricks, false);      
        UserMapper.createOrder( order, u );
        return order;
    }

}
