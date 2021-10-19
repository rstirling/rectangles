package org.rectangles.classifiers

import spock.lang.Specification
import spock.lang.Unroll

import java.awt.*

class IntersectionClassifierTest extends Specification {

    IntersectionClassifier intersectionClassifier

    void setup() {
        intersectionClassifier = new IntersectionClassifier();
    }

    @Unroll
    def "Class of #rectangle1 and #rectangle2 is #className"() {

        expect:
        intersectionClassifier.classify(rectangle1, rectangle2) == className

        where:
        className         | rectangle1                    | rectangle2
        "No Intersection"    | new Rectangle(0, 0, 2, 4)     | new Rectangle(0, 0, 2, 4) // equal
        "No Intersection"    | new Rectangle(0, 0, 2, 4)     | new Rectangle(0, 0, 1, 3) // smaller contained
        "Intersection"    | new Rectangle(0, 0, 2, 4)     | new Rectangle(0, 0, 3, 5) // larger
        "Intersection"    | new Rectangle(0, 0, 2, 4)     | new Rectangle(1, 1, 2, 4) // inside same
        "Intersection"    | new Rectangle(1, 1, 2, 4)     | new Rectangle(0, 0, 2, 4) // slided
        "No Intersection" | new Rectangle(0, 0, 5, 7)     | new Rectangle(5, 5, 5, 7) // outside
        "No Intersection" | new Rectangle(5, 5, 5, 7)     | new Rectangle(0, 0, 5, 7) // outside
        "No Intersection" | new Rectangle(12, 12, 10, 12) | new Rectangle(0, 0, 8, 10) //outside
        "No Intersection" | new Rectangle(0, 0, 1, 1)     | new Rectangle(1, 0, 1, 1) //outside
    }
}
