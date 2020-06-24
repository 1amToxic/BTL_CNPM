/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_new;

import controller.dao.UsedServiceDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import model.Service;
import model.UsedService;
import view.SearchUsedServiceFrm;

/**
 *
 * @author lamit
 */
public class SearchUsedServiceControl {
    private SearchUsedServiceFrm searchUSFrm;
    private UsedServiceDAO dao;
    private int idBookedFieldS;
    private ArrayList<Service> list;
    private ArrayList<UsedService> list1 = new ArrayList<>();
    public SearchUsedServiceControl(int id,ArrayList<UsedService> list){
        this.list1 = list;
        this.idBookedFieldS = id;
        searchUSFrm = new SearchUsedServiceFrm();
        searchUSFrm.setVisible(true);
        dao = new UsedServiceDAO();
        searchUSFrm.setListener(new ButtonSearchListener(), new TableListener());
    }
    class ButtonSearchListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            list = dao.searchService(searchUSFrm.getKeySearch());
            list.forEach(
                    (it) -> searchUSFrm.addRow(it.toObjects())
            );
        }
        
    }
    class TableListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            int index = searchUSFrm.getSelectedRow();
            searchUSFrm.dispose();
            QuantityServiceControl quantityControl = new QuantityServiceControl(list.get(index),idBookedFieldS,list1);
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
