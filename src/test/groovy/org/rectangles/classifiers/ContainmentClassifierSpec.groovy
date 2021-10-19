package org.rectangles.classifiers

import spock.lang.Specification
import spock.lang.Unroll

import java.awt.*

class ContainmentClassifierSpec extends Specification {

    ContainmentClassifier containmentClassifier;

    void setup() {
        containmentClassifier = new ContainmentClassifier();
    }

    @Unroll
    def "Class of #rectangle1 and #rectangle2 is #clas"() {

        expect:
        containmentClassifier.classify(rectangle1, rectangle2) == clas

        where:
        clas             | rectangle1                    | rectangle2
        "Containment"    | new Rectangle(0, 0, 5, 6)     | new Rectangle(0, 0, 5, 6) //equal
        "Containment"    | new Rectangle(0, 0, 5, 6)     | new Rectangle(0, 1, 4, 5) // inside
        "Containment"    | new Rectangle(0, 0, 5, 6)     | new Rectangle(0, 1, 4, 5) // inside
        "Containment"    | new Rectangle(0, 0, 5, 6)     | new Rectangle(1, 1, 4, 5) // inside
        "No Containment" | new Rectangle(0, 0, 5, 6)     | new Rectangle(1, 1, 5, 6) // intersection
        "No Containment" | new Rectangle(12, 12, 10, 12) | new Rectangle(0, 0, 10, 12) // out of range
    }
}
