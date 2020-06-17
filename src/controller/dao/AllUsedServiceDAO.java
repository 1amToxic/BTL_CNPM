/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.UsedService;

/**
 *
 * @author lamit
 */
public class AllUsedServiceDAO extends DAO{
    //use for update in total of bookedfield 
    public AllUsedServiceDAO() {
    }
    public ArrayList<UsedService> getAllUsedService(int idBookedField){
        ArrayList<UsedService> list = new ArrayList<>();
        String sql = "select * from tblusedservice where idBookedField = ?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, idBookedField);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                list.add(new UsedService(rs.getInt("price"),rs.getInt("amount"),rs.getInt("saleoff")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return list;
    }
}
