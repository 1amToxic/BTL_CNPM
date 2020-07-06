/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_new;

import model.dao.BookedFieldDAO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import model.BookedField;
import model.Booking;
import view.ChooseBookedFieldFrm;

/**
 *
 * @author lamit
 */
public class BookedFieldControl {
    private ChooseBookedFieldFrm bfFrm;
    private BookedFieldDAO dao;
    private Booking booking;
    ArrayList<BookedField> list;
    public BookedFieldControl(){
        bfFrm = new ChooseBookedFieldFrm();
        booking = RemoteModule.getBooking();
        bfFrm.setVisible(true);
        dao = new BookedFieldDAO();
        list = new ArrayList<>();
        list = dao.getListBookedField(booking.getId());
        list.forEach(
                (it) -> bfFrm.addRow(it.toObjects())
        );
        bfFrm.setListener(new TableBookedFListener());
    }
    public class TableBookedFListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            int index = bfFrm.getSelectedRow();
            RemoteModule.setBf(list.get(index));
            bfFrm.dispose();
            BookedFieldSingleControl bfsControl = new BookedFieldSingleControl();
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
