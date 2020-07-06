
import model.dao.UsedServiceDAO;
import java.util.ArrayList;
import junit.framework.Assert;
import model.Service;
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
public class UsedServiceDaoTest {
    UsedServiceDAO dao = new UsedServiceDAO();
    @Test
    public void testSearchServiceStandard1(){
        String key = "c";
        ArrayList<Service> list = dao.searchService(key);
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        list.forEach(
                (it) -> it.getName().toLowerCase().contains(key.toLowerCase())
        );
        return;
    }
    @Test
    public void testSearchServiceStandard2(){
        String key = "ch";
        ArrayList<Service> list = dao.searchService(key);
        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());
        list.forEach(
                (it) -> it.getName().toLowerCase().contains(key.toLowerCase())
        );
        return;
    }
    @Test
    public void testSearchServiceException1(){
        String key = "xxxxx";
        ArrayList<Service> list = dao.searchService(key);
        Assert.assertNotNull(list);
        Assert.assertEquals(0, list.size());
        return;
    }
    @Test
    public void testSearchServiceException2(){
        String key = "nuoc loc";
        ArrayList<Service> list = dao.searchService(key);
        Assert.assertNotNull(list);
        Assert.assertEquals(0, list.size());
        return;
    }
}
