package org.rectangles.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RectangleAnalysis {

    private String intersection;
    private String containment;
    private String adjacency;

    @Override
    public String toString() {
        return "Intersection: [" + intersection + "]\n" +
                "Containment: [" + containment + "]\n" +
                "Adjacency: [" + adjacency + "]\n";
    }
}
