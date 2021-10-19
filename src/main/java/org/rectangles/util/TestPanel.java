package org.rectangles.util;

import javax.swing.*;
import java.awt.*;

/**
 * Utility class to draw rectangles in a JFrame window.
 */
public class TestPanel extends JPanel {

    private final Rectangle[] rectangle;
    private final Color[] color;

    public TestPanel(Rectangle[] rectangle, Color[] color) {
        this.rectangle = rectangle;
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < rectangle.length; i++) {
            draw(g, i);
        }
    }

    public void draw(Graphics g, int i) {
        g.setColor(color[i]);
        g.drawRect((int) rectangle[i].getX(),
                (int) rectangle[i].getY(),
                (int) rectangle[i].getWidth(),
                (int) rectangle[i].getHeight());
    }

}