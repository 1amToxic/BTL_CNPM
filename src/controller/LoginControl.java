/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dao.BookedFieldDAO;
import controller.dao.UserDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Booking;
import model.User;
import view.LoginFrm;
import view.ManagerHomeFrm;

/**
 *
 * @author lamit
 */
public class LoginControl {
    private UserDAO dao;
    private LoginFrm loginFrm;
    private ManagerHomeFrm manageFrm;
    private User user;
//    private BookedFieldDAO dao1;
//    private UsedItemsDAO dao2;
    public LoginControl(LoginFrm loginFrm){
        dao = new UserDAO();
        this.loginFrm = loginFrm;
        loginFrm.setListener(new LoginListener());
    }
//    public LoginControl() {
////        dao = new UserDAO();
//        dao1 = new BookedFieldDAO();
//        dao2 = new UsedItemsDAO();
////        dao.checkLogin(new User("lam","123"));
//        ArrayList<Booking> listBk =  dao1.searchField("nghia");
//        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
//        for(Booking bk : listBk){
//            System.out.println(dao1.getIdBookedField(bk.getId()));
////               dao1.updateCheckout(dao1.getIdBookedField(bk.getId()), "20:00:00", "22:00:00");
//            dao2.searchItem(bk.getId(), "c");
//        }
//        
//    }
//    public static void main(String[] args) {
//        new LoginControl();
//    }
    class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            user = loginFrm.getUser();
            if(dao.checkLogin(user)){
                loginFrm.showMessage("Success");
                loginFrm.dispose();
                manageFrm = new ManagerHomeFrm();
                manageFrm.setVisible(true);
                ManagerControl managerControl = new ManagerControl(manageFrm);
            }
            else{
                loginFrm.showMessage("Failed");
            }
        }
        
    }
}
