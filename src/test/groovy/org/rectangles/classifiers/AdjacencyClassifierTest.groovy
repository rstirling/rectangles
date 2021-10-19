package org.rectangles.classifiers

import spock.lang.Specification
import spock.lang.Unroll

import java.awt.*

class AdjacencyClassifierTest extends Specification {

    AdjacencyClassifier adjacencyClassifier = new AdjacencyClassifier();

    @Unroll
    def "Class of #rectangle1 and #rectangle2 is #className"() {

        expect:
        adjacencyClassifier.classify(rectangle1, rectangle2) == className

        where:
        className      | rectangle1                | rectangle2
        "Not Adjacent" | new Rectangle(0, 0, 2, 4) | new Rectangle(0, 0, 2, 4) // contained
        "Not Adjacent" | new Rectangle(0, 0, 2, 4) | new Rectangle(0, 0, 3, 5) // intersects
        "Not Adjacent" | new Rectangle(0, 0, 2, 4) | new Rectangle(0, 0, 1, 5) // intersects
        "Not Adjacent" | new Rectangle(0, 0, 2, 4) | new Rectangle(0, 1, 1, 5) // intersects
        "Not Adjacent" | new Rectangle(0, 0, 2, 4) | new Rectangle(10, 10, 3, 5) // far away - not connected
        "Adjacent"     | new Rectangle(0, 0, 1, 1) | new Rectangle(0, 1, 1, 1) // adjacent on top - proper
        "Adjacent"     | new Rectangle(0, 0, 1, 1) | new Rectangle(1, 0, 1, 1) // adjacent on right - proper
        "Adjacent"     | new Rectangle(0, 0, 1, 1) | new Rectangle(0, 1, 1, 1) // adjacent on bottom - proper
        "Adjacent"     | new Rectangle(0, 0, 1, 1) | new Rectangle(1, 0, 1, 1) // adjacent on left - proper
        "Adjacent"     | new Rectangle(1, 0, 2, 2) | new Rectangle(0, 0, 1, 1) // adjacent on top - sub-line
        "Adjacent"     | new Rectangle(0, 0, 2, 2) | new Rectangle(2, 0, 1, 1) // adjacent on right - sub-line
        "Adjacent"     | new Rectangle(0, 0, 2, 2) | new Rectangle(0, 2, 1, 1) // adjacent on bottom - sub-line
        "Adjacent"     | new Rectangle(1, 0, 2, 2) | new Rectangle(0, 0, 1, 1) // adjacent on left - sub-line
        "Adjacent"     | new Rectangle(0, 4, 3, 3) | new Rectangle(0, 0, 5, 4) // adjacent on top - partial
        "Adjacent"     | new Rectangle(0, 0, 3, 3) | new Rectangle(3, 0, 3, 3) // adjacent on right - partial
        "Adjacent"     | new Rectangle(0, 0, 5, 4) | new Rectangle(0, 4, 3, 3) // adjacent on bottom - partial
        "Adjacent"     | new Rectangle(3, 0, 3, 3) | new Rectangle(0, 1, 3, 4) // adjacent on left - partial
    }
}
