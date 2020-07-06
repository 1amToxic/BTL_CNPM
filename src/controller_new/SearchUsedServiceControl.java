/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_new;

import model.dao.UsedServiceDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import model.Service;
import model.UsedService;
import model.dao.ServiceDAO;
import view.SearchUsedServiceFrm;

/**
 *
 * @author lamit
 */
public class SearchUsedServiceControl {
    private SearchUsedServiceFrm searchUSFrm;
    private ServiceDAO dao;
    private int idBookedFieldS;
    private ArrayList<Service> list;
    public SearchUsedServiceControl(){
        searchUSFrm = new SearchUsedServiceFrm();
        searchUSFrm.setVisible(true);
        dao = new ServiceDAO();
        searchUSFrm.setListener(new ButtonSearchListener(), new TableListener());
    }
    class ButtonSearchListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            list = dao.searchService(searchUSFrm.getKeySearch());
            searchUSFrm.clearTable();
            list.forEach(
                    (it) -> searchUSFrm.addRow(it.toObjects())
            );
        }
        
    }
    class TableListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            int index = searchUSFrm.getSelectedRow();
            RemoteModule.setService(list.get(index));
            searchUSFrm.dispose();
            QuantityServiceControl quantityControl = new QuantityServiceControl();
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
