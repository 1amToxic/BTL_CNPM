/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_new;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ManagerHomeFrm;

/**
 *
 * @author lamit
 */
public class ManagerHomeControl {
    private ManagerHomeFrm homeFrm;
    public ManagerHomeControl(){
        homeFrm = new ManagerHomeFrm();
        homeFrm.setVisible(true);
        homeFrm.setListener(new ManagerListener());
    }
    public class ManagerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            homeFrm.dispose();
            SearchBookingControl bookingControl = new SearchBookingControl();
        }
        
    }
}
