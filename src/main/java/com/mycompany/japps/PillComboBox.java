/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.japps;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class PillComboBox extends JComboBox<String> {
    private Shape shape;

    public PillComboBox(String[] items) {
        super(items);
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        Graphics2D g2 = (Graphics2D) g;
        g2.setClip(shape);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(shape);
    }
}


