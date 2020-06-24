/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import static controller.dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lamit
 */
public class BookedFieldSingleDAO extends DAO{
    public void updateCheckout(int id,String checkIn, String checkOut, int penalty,String playDate){
//        
//        
//        System.out.println(sdf.format(date)+"-"+id);
        //tim kiem bookedfieldsingle phu hop
//        String sql = "select * from tblbookedfieldsingle where idBookedField = ? and playDate = ?";
        String sql  = "update tblbookedfieldsingle set checkin = ?, checkout = ?, penalty = ? where playDate = ? and idBookedField = ?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(5,id);
            pre.setString(4, playDate);
            pre.setString(1, checkIn);
            pre.setString(2, checkOut);
            pre.setInt(3, penalty);
            pre.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public int getIdBookedFieldSingle(int id){
        int result = 0;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "select id from tblbookedfieldsingle where idBookedField = ? and playDate = ?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, id);
            pre.setString(2, sdf.format(date));
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                int idBFS = rs.getInt("id");
                result = idBFS;
            }
        }catch(Exception e){
        }   
        return result;
    }
}
