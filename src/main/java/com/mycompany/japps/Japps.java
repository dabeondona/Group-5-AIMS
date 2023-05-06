package com.mycompany.japps;
import javax.swing.*;
import java.awt.*;
/**
 *
 * 
 * 
 * 
 */
public class Japps extends JFrame{
    
    public static String getGUIName() {
        return "Helix";
    }
    
    public static int getGUIWidth() {
        return 1500;
    }
    
    public static int getGUIHeight() {
        return 1000;
    }
    
    public static Color getJFrameColor() {
        return new Color(0x8a252c);
    }
    
    public static Color getJPanelColor() {
        return new Color(0xa83332);
    }
    public static void main(String[] args) {
    //new SplashPage();
    new LoginPage();
    }
}
