/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dao.BookedFieldDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.BookedFieldSingle;
import view.ConfirmCheckoutFrm;
import view.ConfirmUsedItemsFrm;

/**
 *
 * @author lamit
 */
public class ConfirmCheckoutControl {
    private ConfirmCheckoutFrm checkoutFrm;
    private BookedFieldDAO dao;
    private int idBookedField;
    public ConfirmCheckoutControl(ConfirmCheckoutFrm checkoutFrm, int idBookedField) {
        this.checkoutFrm = checkoutFrm;
        this.idBookedField = idBookedField;
        dao = new BookedFieldDAO();
        checkoutFrm.setListener(new CheckoutListener());
        Date date = new Date();
        SimpleDateFormat formmater = new SimpleDateFormat("yyyy-MM-dd");
        checkoutFrm.setPlayDate(formmater.format(date));
    }
    class CheckoutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            BookedFieldSingle single = checkoutFrm.confirmBookedField();
            dao.updateCheckout(idBookedField, single.getCheckin(), single.getCheckout(),single.getPenalty());
//            ConfirmUsedItemsFrm confirmUsedItemsFrm = new ConfirmUsedItemsFrm();
//            confirmUsedItemsFrm.setVisible(true);
            checkoutFrm.dispose();
            UsedItemControl usedItemControl = new UsedItemControl(idBookedField);
        }
        
    }
}
