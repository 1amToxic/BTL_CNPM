/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author lamit
 */
public class UserDAO extends DAO{

    public UserDAO() {
    }
    
    public boolean checkLogin(User u){
        boolean result = false;
        String sql = "select id, name, position from tblUser where username = ? and password = ?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, u.getUsername());
            pre.setString(2, u.getPassword());
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                if(rs.getString("position").equals("employee")){
                    u.setPos(rs.getString("position"));
                    u.setName(rs.getString("name"));
                    u.setId(rs.getInt("id"));
                    result = true;
                }
                else result = false;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }
}
