/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lamit
 */
public class LoginDAO extends DAO{
    public boolean checkLogin(LoginModel user){
        boolean result = false;
		String sql = "SELECT name, position FROM tbluser WHERE username = ? AND password = ?";
//                String sql = "select * from tbluser";
		try {
                    System.out.println("Go");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
//                        System.out.println(user.getUsername() + " "+user.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				user.setUsername(rs.getString("name"));
//				user.setPosition(rs.getString("position"));
                                System.out.println(rs.getString(1));
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
    }
}
