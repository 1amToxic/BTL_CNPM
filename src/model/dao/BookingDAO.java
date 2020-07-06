/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Booking;

/**
 *
 * @author lamit
 */
public class BookingDAO extends DAO{

    public BookingDAO() {
    }
    
    public ArrayList<Booking> searchBooking(String key){
        ArrayList<Booking> list = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String sql = "select bk.id,bk.bookedDate,bk.saleoff,c.name,c.idcard,c.telephone from tblbooking as bk, tblclient as c"
                + " where c.name like ? and bk.idClient = c.id";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, "%" + key +"%");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                list.add(new Booking(rs.getInt("id"),formatter.parse(rs.getString("bookedDate")),rs.getInt("saleoff"),rs.getString("name"),
                rs.getString("idcard"),rs.getString("telephone")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
