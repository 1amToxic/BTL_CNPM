/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_new;

import controller.dao.BookedFieldDAO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import model.BookedField;
import view.ChooseBookedFieldFrm;

/**
 *
 * @author lamit
 */
public class BookedFieldControl {
    private ChooseBookedFieldFrm bfFrm;
    private BookedFieldDAO dao;
    private int idBooking;
    ArrayList<BookedField> list;
    public BookedFieldControl(int id){
        bfFrm = new ChooseBookedFieldFrm();
        bfFrm.setVisible(true);
        idBooking = id;
        dao = new BookedFieldDAO();
        list = new ArrayList<>();
        list = dao.getListBookedField(id);
        list.forEach(
                (it) -> bfFrm.addRow(it.toObjects())
        );
        bfFrm.setListener(new TableBookedFListener());
    }
    public class TableBookedFListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            int index = bfFrm.getSelectedRow();
            bfFrm.dispose();
            ConfirmCheckoutControl checkoutControl = new ConfirmCheckoutControl(list.get(index).getId());
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
        
    }
}
