package org.rectangles.classifiers;

import java.awt.*;
import java.awt.geom.Line2D;

public class AdjacencyClassifier implements RectangleClassifier {

    /**
     * Classifies rectangles on Adjacency. Adjacency is defined as the sharing of at least one side.
     *
     * @param rectangle1
     * @param rectangle2
     * @return String containing "Adjacent" or "Not Adjacent"
     */
    @Override
    public String classify(Rectangle rectangle1, Rectangle rectangle2) {

        final var lines1 = getLines(rectangle1);
        final var lines2 = getLines(rectangle2);

        final var adjacentOnTop = intersects(lines1[0], lines2[2]);
        final var adjacentOnRight = intersects(lines1[1], lines2[3]);
        final var adjacentOnBottom = intersects(lines1[2], lines2[0]);
        final var adjacentOnLeft = intersects(lines1[3], lines2[1]);

        return adjacentOnTop || adjacentOnRight || adjacentOnBottom || adjacentOnLeft ? "Adjacent" : "Not Adjacent";
    }


    /**
     * Checks if the given lines are intersecting - "touching".
     *
     * @param line1
     * @param line2
     * @return true if they have a common point, otherwise false.
     */
    private boolean intersects(Line2D.Double line1, Line2D.Double line2) {
        return line1.intersectsLine(line2);
    }


    /**
     * Decomposes a given rectangle into lines. The returning array is composed by top, left, right and bottom.
     * The indexes are represented respectively.
     *
     * @param rectangle
     * @return An array of lines
     */
    private Line2D.Double[] getLines(Rectangle rectangle) {

        final var topLine = new Line2D.Double(
                rectangle.getX(),
                rectangle.getY(),
                rectangle.getX() + rectangle.getWidth(),
                rectangle.getY());

        final var rightLine = new Line2D.Double(
                rectangle.getX() + rectangle.getWidth(),
                rectangle.getY(),
                rectangle.getX() + rectangle.getWidth(),
                rectangle.getY() - rectangle.getHeight());

        final var bottomLine = new Line2D.Double(
                rectangle.getX(),
                rectangle.getY() + rectangle.getHeight(),
                rectangle.getX() + rectangle.getWidth(),
                rectangle.getY() + rectangle.getHeight()
        );

        final var leftLine = new Line2D.Double(
                rectangle.getX(),
                rectangle.getY(),
                rectangle.getX(),
                rectangle.getY() - rectangle.getHeight());

        return new Line2D.Double[]{topLine, rightLine, bottomLine, leftLine};
    }

}
