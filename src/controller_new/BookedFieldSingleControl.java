/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_new;

import model.dao.BookedFieldSingleDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.BookedFieldSingle;
import model.UsedService;
import view.ConfirmBookedFieldSingleFrm;

/**
 *
 * @author lamit
 */
public class BookedFieldSingleControl {
    private ConfirmBookedFieldSingleFrm bfsFrm;
    private BookedFieldSingleDAO dao;
    private BookedFieldSingle bfs;
    private ArrayList<UsedService> list = new ArrayList<>();
    private int idBookedFieldS;
    private int total = 0;
    public void setList(){
        bfsFrm.clearTable();
        list = RemoteModule.getList();
        if(list!=null){
            list.forEach(
                    (it) -> bfsFrm.addRow(it.toObjects())
            );
        }
    }
    public BookedFieldSingleControl(){
        bfsFrm  = new ConfirmBookedFieldSingleFrm();
        bfsFrm.setVisible(true);
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        bfsFrm.setDate(formater.format(date));
        setList();
        dao = new BookedFieldSingleDAO();
        
        this.idBookedFieldS = dao.getIdBookedFieldSingle(RemoteModule.getBf().getId());
        bfs = new BookedFieldSingle();
        bfs.setId(idBookedFieldS);
        RemoteModule.setBfs(bfs);
        bfsFrm.setListener(new ConfirmListener(),new UsedServiceListener());
    }
    class UsedServiceListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            bfsFrm.dispose();
            SearchUsedServiceControl usControl = new SearchUsedServiceControl();
        }
    }
    class ConfirmListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            bfsFrm.showMessage("Saved!!!");
            dao.updateTotalBookedFieldSingle(total, idBookedFieldS,bfsFrm.getCheckin(),bfsFrm.getCheckout(),bfsFrm.getPenalty());
            bfsFrm.dispose();
            ManagerHomeControl managerHomeControl = new ManagerHomeControl();
        }
        
    }
}
