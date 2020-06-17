/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ManagerHomeFrm;
import view.SearchBookedFieldFrm;

/**
 *
 * @author lamit
 */
public class ManagerControl {
    private ManagerHomeFrm managerFrm;

    public ManagerControl(ManagerHomeFrm managerFrm) {
        this.managerFrm = managerFrm;
        managerFrm.setListener(new ManagerListener());
    }
    
    class ManagerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            managerFrm.dispose();
            SearchBookedFieldFrm searchFrm = new SearchBookedFieldFrm();
            searchFrm.setVisible(true);
            SearchBookedFieldControl searchBookedFieldControl = new SearchBookedFieldControl(searchFrm);
        }
        
    }
}
