package org.tastefuljava.noodleauth;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import javax.swing.Icon;

public class ClockIcon implements Icon {
    private double angle;
    private final int width;
    private final int height;
    private Color fillColor = Color.CYAN;
    private Color strokeColor = null;

    public ClockIcon(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double newValue) {
        angle = newValue;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D)g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
            arc.setFrame(x+1, y+1, width-2, height-2);
            arc.setAngleStart(90);
            arc.setAngleExtent(angle);
            if (fillColor != null) {
                g2.setColor(fillColor);
                g2.fill(arc);
            }
            if (strokeColor != null) {
                g2.setColor(strokeColor);
                g2.drawOval(x+1, y+1, width-2, height-2);
            }
        } finally {
            g2.dispose();
        }
    }
}
