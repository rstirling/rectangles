package org.rectangles.classifiers;

import lombok.extern.slf4j.Slf4j;
import org.rectangles.model.RectangleAnalysis;

import java.awt.*;


@Slf4j
public class ClassifierService {

    private final ContainmentClassifier containmentClassifier = new ContainmentClassifier();
    private final IntersectionClassifier intersectionClassifier = new IntersectionClassifier();
    private final AdjacencyClassifier adjacencyClassifier = new AdjacencyClassifier();

    /**
     * Analyses rectangles for on the supported criterion: Containment, Intersection and Adjacency.
     *
     * @param rectangle1
     * @param rectangle2
     * @return RectangleAnalysis
     */
    public RectangleAnalysis getAnalysis(Rectangle rectangle1, Rectangle rectangle2) {

        return RectangleAnalysis.builder()
                .intersection(intersectionClassifier.classify(rectangle1, rectangle2))
                .containment(containmentClassifier.classify(rectangle1, rectangle2))
                .adjacency(adjacencyClassifier.classify(rectangle1, rectangle2))
                .build();
    }
}
