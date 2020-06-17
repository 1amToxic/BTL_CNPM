/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dao.ConfirmedUsedItemDAO;
import controller.dao.UsedServiceDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import model.UsedService;
import view.QuantityItemsFrm;
import view.SearchUsedItemFrm;

/**
 *
 * @author lamit
 */
public class SearchUsedItemControl{
    private SearchUsedItemFrm searchItemFrm;
    private UsedServiceDAO dao;
    ArrayList<UsedService> list;
    ArrayList<UsedService> list1;
    private int idBookedField;
    public SearchUsedItemControl(int idBookedField,ArrayList<UsedService> list) {
        this.list1 = list;
        SearchUsedItemFrm searchItemFrm = new SearchUsedItemFrm();
        searchItemFrm.setVisible(true);
        this.idBookedField = idBookedField;
        this.searchItemFrm = searchItemFrm;
        dao = new UsedServiceDAO();
        searchItemFrm.setListener(new SearchItemListener(), new TableItemListener());
    }
    class SearchItemListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            list =  dao.searchItem(idBookedField, searchItemFrm.getKeySearch());
            for(UsedService us : list){
                searchItemFrm.addRow(us);
            }
        }
        
    }
    class TableItemListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            int index = searchItemFrm.getSelectedRow();
            UsedService us = new UsedService();
            us = list.get(index);
            searchItemFrm.dispose();
           
            QuantityItemControl quantityItem = new QuantityItemControl(list1,us,idBookedField);           
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
