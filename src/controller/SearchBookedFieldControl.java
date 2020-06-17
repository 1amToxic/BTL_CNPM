/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dao.BookedFieldDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import model.Booking;
import org.w3c.dom.events.MouseEvent;
import view.ConfirmCheckoutFrm;
import view.SearchBookedFieldFrm;

/**
 *
 * @author lamit
 */
public class SearchBookedFieldControl {
    private SearchBookedFieldFrm bfFrm;
    private BookedFieldDAO dao;
    ArrayList<Booking> list;
    public SearchBookedFieldControl(SearchBookedFieldFrm bfFrm) {
        this.bfFrm = bfFrm;
        dao = new BookedFieldDAO();
        bfFrm.setListener(new SearchBookedFieldListener());
    }
    class SearchBookedFieldListener implements ActionListener,MouseListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String key = bfFrm.getKeySearch();
            list =  dao.searchBooking(key);
            for(Booking bk : list){
                bfFrm.addRow(bk.toObjects());
            }
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent me) {
            int index = bfFrm.getRowSelected();
            Booking booking = list.get(index);
            bfFrm.dispose();
            ConfirmCheckoutFrm checkoutFrm = new ConfirmCheckoutFrm();
            checkoutFrm.setVisible(true);
            ConfirmCheckoutControl checkoutControl = new ConfirmCheckoutControl(checkoutFrm,dao.getIdBookedField(booking.getId()));
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent me) {
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent me) {
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent me) {
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent me) {
        }

        
        
    }
}
