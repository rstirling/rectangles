package org.rectangles.classifiers;

import java.awt.*;

public interface RectangleClassifier {

    /**
     * This interface method should be implemented by a rectangle classifier and return an analysis.
     * @param rectangle1
     * @param rectangle2
     * @return String value according to classification
     */
    String classify(Rectangle rectangle1, Rectangle rectangle2);

}
