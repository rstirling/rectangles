package org.rectangles.classifiers;

import java.awt.*;

public class IntersectionClassifier implements RectangleClassifier {


    /**
     * Classifies rectangles on intersection criteria: "Two rectangles intersect if their intersection is nonempty".
     * @param rectangle1
     * @param rectangle2
     * @return A String with "Intersection" if intersects, otherwise "No Intersection"
     */
    @Override
    public String classify(Rectangle rectangle1, Rectangle rectangle2) {
        if (!rectangle1.contains(rectangle2) && rectangle1.intersects(rectangle2)) {
            return "Intersection";
        } else {
            return "No Intersection";
        }
    }
}
