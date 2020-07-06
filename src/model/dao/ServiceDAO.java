/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Service;
import model.UsedService;

/**
 *
 * @author lamit
 */
public class ServiceDAO extends DAO{

    public ServiceDAO() {
    }
    public ArrayList<Service> searchService(String key){
        ArrayList<Service> list = new ArrayList<>();
        String sql = "select * from tblservice where name like ?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,"%" + key + "%");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Service s = new Service(rs.getInt("id"),rs.getString("name"),rs.getInt("price"),rs.getString("unity"),rs.getString("des"));
                list.add(s);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return list;
    }
}
