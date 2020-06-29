
import controller.dao.BookingDAO;
import java.util.ArrayList;
import junit.framework.Assert;
import model.Booking;
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
public class BookingDaoTest {
    BookingDAO dao = new BookingDAO();
    @Test
    public void testSearchBookingStandard1(){
        String key = "tr";
        ArrayList<Booking> list = dao.searchBooking(key);
        Assert.assertNotNull(list);
        Assert.assertEquals(1, list.size());
        list.forEach(
                (it) -> Assert.assertTrue(it.getName().toLowerCase().contains(key.toLowerCase()))
        );
        return;
    }
    @Test
    public void testSearchBookingStandard2(){
        String key = "ng";
        ArrayList<Booking> list = dao.searchBooking(key);
        Assert.assertNotNull(list);
        Assert.assertEquals(2, list.size());
        list.forEach(
                (it) -> Assert.assertTrue(it.getName().toLowerCase().contains(key.toLowerCase()))
        );
        return;
    }
    @Test
    public void testSearchBookingException1(){
        String key = "xxxxx";
        ArrayList<Booking> list = dao.searchBooking(key);
        Assert.assertNotNull(list);
        Assert.assertEquals(0, list.size());
        return;
    }
    @Test
    public void testSearchBookingException2(){
        String key = "nam";
        ArrayList<Booking> list = dao.searchBooking(key);
        Assert.assertNotNull(list);
        Assert.assertEquals(0, list.size());
        return;
    }
}
