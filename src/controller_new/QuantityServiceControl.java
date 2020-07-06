/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_new;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Service;
import model.UsedService;
import model.dao.UsedServiceDAO;
import view.QuantityServiceFrm;

/**
 *
 * @author lamit
 */
public class QuantityServiceControl {
    private QuantityServiceFrm quantityFrm;
    private UsedServiceDAO dao;
    private Service s;
    ArrayList<UsedService> list = new ArrayList<>();
    private int idBookedFieldS;
    public QuantityServiceControl(){
        this.s = RemoteModule.getService();
        this.idBookedFieldS = RemoteModule.getBfs().getId();
        quantityFrm = new QuantityServiceFrm();
        quantityFrm.setVisible(true);
        quantityFrm.init(s.getName(), s.getPrice());
        dao = new UsedServiceDAO();
        quantityFrm.setListener(new ButtonListener());
    }
    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            UsedService us = new UsedService(s);
            us.setAmount(quantityFrm.getAmount());
            us.setSaleoff(quantityFrm.getSaleoff());
            us.setTotal(us.getAmount()*us.getPrice()-us.getSaleoff());
            list = RemoteModule.getList();
            list.add(us);
            RemoteModule.setList(list);
            dao.updateUsedItems(us, RemoteModule.getBfs().getId());
            quantityFrm.dispose();
            BookedFieldSingleControl usControl = new BookedFieldSingleControl();
        }
        
    }
}
