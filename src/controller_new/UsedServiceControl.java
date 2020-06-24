/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_new;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import model.UsedService;
import view.ConfirmUsedServiceFrm;

/**
 *
 * @author lamit
 */
public class UsedServiceControl {
    private ConfirmUsedServiceFrm usFrm;
    private ArrayList<UsedService> list = new ArrayList<>();
    private int idBookedFieldS;
    public void setList(ArrayList<UsedService> list){
        this.list = list;
        list.forEach(
                (it) -> usFrm.addRow(it.toObjects())
        );
    }
    public UsedServiceControl(int id){
        this.idBookedFieldS = id;
        usFrm  = new ConfirmUsedServiceFrm();
        usFrm.setVisible(true);
        usFrm.setListener(new ConfirmListener(),new UsedServiceListener());
    }
    class UsedServiceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            usFrm.dispose();
            SearchUsedServiceControl usControl = new SearchUsedServiceControl(idBookedFieldS, list);
        }
    }
    class ConfirmListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            usFrm.showMessage("Saved!!!");
            usFrm.dispose();
            ManagerHomeControl managerHomeControl = new ManagerHomeControl();
        }
        
    }
}
