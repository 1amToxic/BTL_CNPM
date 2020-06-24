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
import model.BookedField;

/**
 *
 * @author lamit
 */
public class BookedFieldDAO extends DAO{
    public ArrayList<BookedField> getListBookedField(int id){
        ArrayList<BookedField> list = new ArrayList<>();
        String sql = "select bf.id,bf.startmatch, bf.endmatch,bf.starttime,bf.endtime,f.name as name"
                + " from tblbookedfield as bf, tblfield as f where bf.idBooking = ? and bf.idField = f.id";
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
            SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss");
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                System.out.println("Tes");
                list.add(new BookedField(rs.getInt("bf.id"),
                        rs.getString("bf.startmatch"),
                        rs.getString("bf.endmatch"),
                        formatter.parse(rs.getString("bf.starttime")),
                        formatter.parse(rs.getString("bf.endtime")),
                        rs.getString("f.name")));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}