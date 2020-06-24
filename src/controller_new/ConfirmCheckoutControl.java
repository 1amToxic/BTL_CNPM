/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_new;

import controller.dao.BookedFieldSingleDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ConfirmCheckoutFrm;

/**
 *
 * @author lamit
 */
public class ConfirmCheckoutControl {
    private ConfirmCheckoutFrm checkoutFrm;
    private BookedFieldSingleDAO dao;
    private int idBookedField;
    public ConfirmCheckoutControl(int id){
        idBookedField = id;
        checkoutFrm = new ConfirmCheckoutFrm();
        checkoutFrm.setVisible(true);
        dao = new BookedFieldSingleDAO();
        checkoutFrm.setListener(new ConfirmCheckoutListener());
    }
    class ConfirmCheckoutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String checkin = checkoutFrm.getCheckin();
            String checkout = checkoutFrm.getCheckout();
            int penalty = Integer.parseInt(checkoutFrm.getPenalty().toString());
            String playDate = checkoutFrm.getDateToday();
            dao.updateCheckout(idBookedField, checkin, checkout, penalty, playDate);
            checkoutFrm.dispose();
            UsedServiceControl usControl = new UsedServiceControl(dao.getIdBookedFieldSingle(idBookedField));
        }
        
    }
}
