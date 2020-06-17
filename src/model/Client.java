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
public class Client {
    private int id;
    private String name;
    private String address;
    private String idcard;
    private String telephone;
    private String des;

    public Client() {
    }

    public Client(String name, String address, String idcard, String telephone, String des) {
        this.name = name;
        this.address = address;
        this.idcard = idcard;
        this.telephone = telephone;
        this.des = des;
    }
    
}
