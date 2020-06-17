/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lamit
 */
public class BookedFieldSingle implements Serializable{
    private int id;
    private int idBookedField;
    private Date playDate;
    private String checkin;
    private String checkout;
    private int penalty;

    public BookedFieldSingle() {
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
    
    public BookedFieldSingle(Date playDate, String checkin, String checkout, int penalty) {
        this.playDate = playDate;
        this.checkin = checkin;
        this.checkout = checkout;
        this.penalty = penalty;
    }
    
   
}
