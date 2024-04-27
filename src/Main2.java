
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author puser
 */
public class Main2 {
    public static void main(String[] args)
    {
        
        welcomeScreen welcomeScreen = new welcomeScreen();
        welcomeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeScreen.setVisible(true);
        welcomeScreen.setSize(600,180);
       
        
    }
}
