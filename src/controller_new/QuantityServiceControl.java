/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_new;

import controller.dao.ConfirmedUsedServiceDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Service;
import model.UsedService;
import view.QuantityServiceFrm;

/**
 *
 * @author lamit
 */
public class QuantityServiceControl {
    private QuantityServiceFrm quantityFrm;
    private ConfirmedUsedServiceDAO dao;
    private Service s;
    ArrayList<UsedService> list = new ArrayList<>();
    private int idBookedFieldS;
    public QuantityServiceControl(Service s,int id,ArrayList<UsedService> list){
        this.list = list;
        this.s = s;
        this.idBookedFieldS = id;
        quantityFrm = new QuantityServiceFrm();
        quantityFrm.setVisible(true);
        quantityFrm.init(s.getName(), s.getPrice());
        dao = new ConfirmedUsedServiceDAO();
        quantityFrm.setListener(new ButtonListener());
    }
    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            UsedService us = new UsedService(s);
            us.setAmount(quantityFrm.getAmount());
            us.setSaleoff(quantityFrm.getSaleoff());
            us.setTotal(us.getAmount()*us.getPrice()-us.getSaleoff());
            list.add(us);
            dao.updateUsedItems(us, idBookedFieldS);
            
            quantityFrm.dispose();
            UsedServiceControl usControl = new UsedServiceControl(idBookedFieldS);
            usControl.setList(list);
        }
        
    }
}
