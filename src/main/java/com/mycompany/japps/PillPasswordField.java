package com.mycompany.japps;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
/**
 *
 * @author ondon
 */
public class PillPasswordField extends JPasswordField {
    private Shape shape;

    public PillPasswordField(int size) {
        super(size);
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
