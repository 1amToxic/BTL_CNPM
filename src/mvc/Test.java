/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author lamit
 */
public class Test {
    public static void main(String[] args) {
        LoginView view = new LoginView();
        LoginControl control  = new LoginControl(view);
        view.setVisible(true);
    }
}
