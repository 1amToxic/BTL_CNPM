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
public class BookedField implements Serializable{
    private int id;
    private String startmatch;
    private String endmatch;
    private Date starttime;
    private Date endtime;
    private int price;
    private int saleoff;
    private Field field;
    private String des;
    private String nameField;

    public BookedField(int id, String startmatch, String endmatch, Date starttime, Date endtime, String name) {
        this.id = id;
        this.startmatch = startmatch;
        this.endmatch = endmatch;
        this.starttime = starttime;
        this.endtime = endtime;
        this.nameField = name;
    }
    public String changeDatetoString(Date d){
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         return formatter.format(d);
    }
    public Object[] toObjects(){
        return new Object[]{startmatch,endmatch,changeDatetoString(starttime),changeDatetoString(endtime),nameField};
    }
    public BookedField() {
    }
    
    public int getId(){
        return id;
    }
    
   
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSaleoff() {
        return saleoff;
    }

    public void setSaleoff(int saleoff) {
        this.saleoff = saleoff;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
   
    
}
