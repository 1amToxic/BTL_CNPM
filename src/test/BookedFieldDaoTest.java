/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controller.dao.BookedFieldDAO;
import java.util.ArrayList;
import junit.framework.Assert;
import model.Booking;
import org.junit.Test;

/**
 *
 * @author lamit
 */
public class BookedFieldDaoTest {
    BookedFieldDAO bf = new BookedFieldDAO();
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
    public void testSearchFieldException1(){
        String key = "m";
        ArrayList<Booking> listBooking = bf.searchBooking(key);
        Assert.assertNotNull(listBooking);
        Assert.assertEquals(0, listBooking.size());
        return;
    }
    
}
