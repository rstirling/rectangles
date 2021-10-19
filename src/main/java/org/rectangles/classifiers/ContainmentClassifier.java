package org.rectangles.classifiers;

import java.awt.*;

public class ContainmentClassifier implements RectangleClassifier {

    /**
     * Classifies rectangles on Containment.
     * @param rectangle1
     * @param rectangle2
     * @return A String with "Containment" if contained otherwise "No Containment"
     */
    @Override
    public String classify(Rectangle rectangle1, Rectangle rectangle2) {
        if (rectangle1.contains(rectangle2)) {
            return "Containment";
        } else {
            return "No Containment";
        }
    }
}
