/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lamit
 */
public class Booking implements Serializable{
    private int id;
    private Date bookedDate;
    private int saleoff;
    private Client client;
    private User user;
    private int total; //add to database
    private String name;
    private String idcard,telephone;
    private ArrayList<BookedField> listBookedField;
    public Booking() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
   
    
    public Booking(int id,Date bookedDate, int saleoff,String name,String idcard,String telephone) {
        this.id = id;
        this.bookedDate = bookedDate;
        this.saleoff = saleoff;
        this.name = name;
        this.idcard = idcard;
        this.telephone = telephone;
    }
    public String changeTypeDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(bookedDate);
    }
    public Object[] toObjects(){
        return new Object[]{id,name,changeTypeDate(),saleoff,idcard,telephone};
    }
}
