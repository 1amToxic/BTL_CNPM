/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_new;

import controller.dao.UserDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.User;
import view.LoginFrm;

/**
 *
 * @author lamit
 */
public class LoginControl {
    private LoginFrm loginFrm;
    private UserDAO dao;
    public LoginControl(){
        loginFrm = new LoginFrm();
        loginFrm.setVisible(true);
        dao = new UserDAO();
        loginFrm.setListener(new UserListener());
    }
    public class UserListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            User user = loginFrm.getUser();
            if(dao.checkLogin(user)){
                loginFrm.showMessage("Success");
                loginFrm.dispose();
                ManagerHomeControl managerControl = new ManagerHomeControl();
            }
            else{
                loginFrm.showMessage("Failed");
            }
        }
        
    }
}
