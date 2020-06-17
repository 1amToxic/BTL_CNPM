/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Booking;

/**
 *
 * @author lamit
 */
public class BookedFieldDAO extends DAO{

    public BookedFieldDAO() {
    }
    
    public ArrayList<Booking> searchBooking(String key){
        ArrayList<Booking> list = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String sql = "select id,bookedDate,saleoff,name from tblbooking where name like ?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, "%" + key +"%");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                list.add(new Booking(rs.getInt("id"),formatter.parse(rs.getString("bookedDate")),rs.getInt("saleoff"),rs.getString("name")));
            }
        }catch(SQLException ex){
            
        } catch (ParseException ex) {
            Logger.getLogger(BookedFieldDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public void updateCheckout(int id,String checkIn, String checkOut, int penalty){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        System.out.println(sdf.format(date)+"-"+id);
        //tim kiem bookedfieldsingle phu hop
        String sql = "select * from tblbookedfieldsingle where idBookedField = ? and playDate = ?";
        String sql1  = "update tblbookedfieldsingle set checkin = ?, checkout = ?, penalty = ? where id = ?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,id);
            pre.setString(2, sdf.format(date));
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                System.out.println("Success");
                try{
                    PreparedStatement pre1 = con.prepareStatement(sql1);
                    pre1.setString(1, checkIn);
                    pre1.setString(2, checkOut);
                    pre1.setInt(3, penalty);
                    pre1.setInt(4,id);
                    pre1.executeUpdate();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public int getIdBookedField(int idBooking){
        String sql = "select id from tblbookedfield where idBooking = ?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,idBooking);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                return rs.getInt("id");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }
}
