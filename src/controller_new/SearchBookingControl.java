/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_new;
import controller.dao.BookingDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import model.Booking;
import view.ChooseBookedFieldFrm;
import view.SearchBookingFrm;

/**
 *
 * @author lamit
 */
public class SearchBookingControl {
    private SearchBookingFrm sBookingFrm;
    private BookingDAO dao;
    ArrayList<Booking> list;
    public SearchBookingControl(){
        list = new ArrayList<>();
        sBookingFrm = new SearchBookingFrm();
        sBookingFrm.setVisible(true);
        dao = new BookingDAO();
        sBookingFrm.setListener(new BookingListener(), new TableBookingListener());
    }
    class BookingListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String key = sBookingFrm.getKeySearch();
            list = dao.searchBooking(key);
//            System.out.println(list.size());
            list.forEach(
                (it) -> sBookingFrm.addRow(it.toObjects())
            );
        }
        
    }
    class TableBookingListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            int index = sBookingFrm.getRowSelected();
            sBookingFrm.dispose();
            BookedFieldControl bfControl = new BookedFieldControl(list.get(index).getId());
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
