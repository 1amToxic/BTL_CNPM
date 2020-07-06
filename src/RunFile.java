
import controller_new.LoginControl;
import controller_new.RemoteModule;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamit
 */
public class RunFile {
    public static void main(String[] args) {
        LoginControl loginControl = new LoginControl();
        RemoteModule.init();
    }
}
