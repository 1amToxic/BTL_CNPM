/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dao.ConfirmedUsedItemDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import model.UsedService;
import view.QuantityItemsFrm;
import view.SearchUsedItemFrm;

/**
 *
 * @author lamit
 */
public class QuantityItemControl{
    private QuantityItemsFrm quantityFrm;
    private ConfirmedUsedItemDAO dao;
    private UsedService us;
    private int idBookedField;
    private ArrayList<UsedService> list = new ArrayList<>();
    public QuantityItemControl(ArrayList<UsedService> list,UsedService us,int idBookedField) {
        this.idBookedField = idBookedField;
        this.us = us;
        this.quantityFrm = new QuantityItemsFrm();
        this.quantityFrm.setVisible(true);
        dao = new ConfirmedUsedItemDAO();
        this.quantityFrm.init(us.getService().getName(), us.getService().getPrice());
        this.quantityFrm.setListener(new ConfirmQuantityListener());
    }
    class ConfirmQuantityListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            us.setAmount(quantityFrm.getAmount());
            us.setSaleoff(quantityFrm.getSaleoff());
            us.setTotal(us.getPrice()*us.getAmount()-us.getSaleoff());
            dao.updateUsedItems(us,idBookedField);
            list.add(us);
            System.out.println(list.size());
            quantityFrm.dispose();
            UsedItemControl usedItemControl = new UsedItemControl(idBookedField);
            usedItemControl.setList(list);
//            usedItemControl.setList(list);
        }
        
    }
}
