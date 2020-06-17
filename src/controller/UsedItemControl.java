/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dao.UsedServiceDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.UsedService;
import view.ConfirmCheckoutFrm;
import view.ConfirmUsedItemsFrm;
import view.SearchUsedItemFrm;

/**
 *
 * @author lamit
 */
public class UsedItemControl{
    private ConfirmUsedItemsFrm usedItemsFrm;
    private ArrayList<UsedService> list;
    private UsedServiceDAO dao;
    private int idBookedField;
    private int total = 0;
    public void setList(ArrayList<UsedService> list){
        this.list = list;
        for(UsedService us : list){
            System.out.println("addR");
            usedItemsFrm.addRow(us);
            total += us.getTotal();
        }
        usedItemsFrm.setTotal(total);
    }
    public UsedItemControl(int idBookedField) {
        ConfirmUsedItemsFrm usedItemsFrm = new ConfirmUsedItemsFrm();
        usedItemsFrm.setVisible(true);
        this.usedItemsFrm = usedItemsFrm;
        this.idBookedField = idBookedField;
        dao = new UsedServiceDAO();
        System.out.println(idBookedField);
        
        usedItemsFrm.setListener(new ButtonConfirmListener(), new ButtonAddListener());
    }
    class ButtonAddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            usedItemsFrm.dispose();
            SearchUsedItemControl searchUsedItemControl = new SearchUsedItemControl(idBookedField, list);
        }
        
    }
    class ButtonConfirmListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            usedItemsFrm.showMessage("Complete!!!");
        }
        
    }
}
