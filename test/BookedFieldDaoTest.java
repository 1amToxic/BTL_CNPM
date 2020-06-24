/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.dao.BookingDAO;
import java.util.ArrayList;
import junit.framework.Assert;
import model.Booking;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lamit
 */
public class BookedFieldDaoTest {
    BookingDAO bf = new BookingDAO();
    public BookedFieldDaoTest() {
    }
    @Test
    public void testSearchFieldStandard1(){
        String key = "ng";
        ArrayList<Booking> listBooking = bf.searchBooking(key);
        Assert.assertNotNull(listBooking);
        Assert.assertEquals(2, listBooking.size());
        listBooking.forEach((bk) -> {
            Assert.assertTrue(bk.getName().toLowerCase().contains(key.toLowerCase()));
        });
        return;
    }
    @Test
    public void testSearchFieldStandard2(){
        String key = "tr";
        ArrayList<Booking> listBooking = bf.searchBooking(key);
        Assert.assertNotNull(listBooking);
        Assert.assertEquals(1, listBooking.size());
        listBooking.forEach((bk) -> {
            Assert.assertTrue(bk.getName().toLowerCase().contains(key.toLowerCase()));
        });
        return;
    }
    //Exception
    @Test
    public void testSearchFieldException1(){
        String key = "m";
        ArrayList<Booking> listBooking = bf.searchBooking(key);
        Assert.assertNotNull(listBooking);
        Assert.assertEquals(0, listBooking.size());
        return;
    }
    @Test
    public void testSearchFieldException2(){
        String key = "xxxxxxxx";
        ArrayList<Booking> listBooking = bf.searchBooking(key);
        Assert.assertNotNull(listBooking);
        Assert.assertEquals(0, listBooking.size());
        return;
    }
    
}
