/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 *
 * @author lamit
 */
public class LoginControl {
    private LoginDAO dao;
    private LoginModel model;
    private LoginView view;
    public LoginControl(LoginView view){
        this.view = view;
        view.addLoginListener(new LoginListener());
        dao = new LoginDAO();
    }
    class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                model = view.getUser();
                if(dao.checkLogin(model)){
                    view.showMessage("Login Succcessfully");
                }
                else view.showMessage("Invalid username and password");
            }catch(Exception ex){
                view.showMessage(Arrays.toString(ex.getStackTrace()));
            }
        }
        
    }
    
            
}
