
import controller.dao.UserDAO;
import model.User;
import org.junit.Assert;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamit
 */
public class LoginDaoTest {
    UserDAO dao = new UserDAO();
    @Test
    public void testLoginStandard(){
        String username = "lam";
        String pass = "123";
        boolean isSuccess = dao.checkLogin(new User(username, pass));
        Assert.assertEquals(true,isSuccess);
        return;
    }
     @Test
    public void testLoginException(){
        String username = "lam1";
        String pass = "123";
        boolean isSuccess = dao.checkLogin(new User(username, pass));
        Assert.assertEquals(false,isSuccess);
        return;
    }
}
