/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import static model.dao.DAO.con;
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
    public void updateTotalBookedFieldSingle(int total, int idBFs,String checkin, String checkout,String penalty){
        String sql = "update tblbookedfieldsingle set total = ?, checkin =?, checkout = ?, penalty = ? where id = ?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, total);
            pre.setInt(5, idBFs);
            pre.setString(2, checkin);
            pre.setString(3, checkout);
            pre.setInt(4, Integer.parseInt(penalty));
            pre.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
