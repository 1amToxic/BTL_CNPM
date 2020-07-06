package controller_new;


import java.util.ArrayList;
import model.BookedField;
import model.BookedFieldSingle;
import model.Booking;
import model.Service;
import model.UsedService;
import model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamit
 */
public class RemoteModule {
    private static User user = null;
    private static Booking booking = null;
    private static BookedField bf = null;
    private static BookedFieldSingle bfs = null;
    private static ArrayList<UsedService> list ;
    private static Service service = null;

    public static Service getService() {
        return service;
    }

    public static void setService(Service service) {
        RemoteModule.service = service;
    }
    
    public static void init(){
        if(user==null){
            user = new User();
            booking = new Booking();
            bf = new BookedField();
            bfs = new BookedFieldSingle();
            list = new ArrayList<>();
            service = new Service();
        }
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        RemoteModule.user = user;
    }

    public static Booking getBooking() {
        return booking;
    }

    public static void setBooking(Booking booking) {
        RemoteModule.booking = booking;
    }

    public static BookedField getBf() {
        return bf;
    }

    public static void setBf(BookedField bf) {
        RemoteModule.bf = bf;
    }

    public static BookedFieldSingle getBfs() {
        return bfs;
    }

    public static void setBfs(BookedFieldSingle bfs) {
        RemoteModule.bfs = bfs;
    }

    public static ArrayList<UsedService> getList() {
        return list;
    }

    public static void setList(ArrayList<UsedService> list) {
        RemoteModule.list = list;
    }
    
}
