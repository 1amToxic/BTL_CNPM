/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author lamit
 */
public class UsedService implements Serializable{
    private int id;
    private int price;
    //add property
    private Service service;
    private int amount;
    private int saleoff;
    private int total;
    public UsedService() {
    }

    @Override
    public String toString() {
        return "UsedService{" + "price=" + price + ", service=" + service + ", amount=" + amount + ", saleoff=" + saleoff + ", total=" + total + '}';
    }
    
    public UsedService(Service s){
        this.service = s;
        this.price = this.service.getPrice();
    }

    public void setService(Service service) {
        this.service = service;
    }
    
    public UsedService(int price, int amount, int saleoff) {
        this.price = price;
        this.amount = amount;
        this.saleoff = saleoff;
    }

    public Service getService() {
        return service;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSaleoff() {
        return saleoff;
    }

    public void setSaleoff(int saleoff) {
        this.saleoff = saleoff;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public Object[] toObjects(){
        return new Object[]{service.getName(),service.getPrice(),amount,saleoff};
    }
}
