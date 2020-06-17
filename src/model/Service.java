/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lamit
 */
public class Service {
    private int id;
    private String name;
    private int price;
    private String unity;
    private String des;
    
    public Service() {
    }

    public Service(int id,String name, int price, String unity, String des) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unity = unity;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    public Object[] toObjects(){
        return new Object[]{name,price,unity,des};
    }
    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", name=" + name + ", price=" + price + ", unity=" + unity + ", des=" + des + '}';
    }
    
}
