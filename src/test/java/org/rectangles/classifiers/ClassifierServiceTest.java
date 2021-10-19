package org.rectangles.classifiers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.rectangles.util.TestPanel;

import javax.swing.*;
import java.awt.*;

class ClassifierServiceTest {

    ClassifierService classifierService = new ClassifierService();

    @Test
    @DisplayName("Intersection")
    void classify() throws InterruptedException {

        final var rectangle1 = new Rectangle(0, 0, 300, 120);
        final var rectangle2 = new Rectangle(100, 100, 100, 150);

        final var analysis = classifierService.getAnalysis(rectangle1, rectangle2);
//        debug(rectangle1, rectangle2);

        Assertions.assertEquals("Intersection", analysis.getIntersection());
        Assertions.assertEquals("No Containment", analysis.getContainment());
        Assertions.assertEquals("Not Adjacent", analysis.getAdjacency());

    }

    @Test
    @DisplayName("No Intersection")
    void classifyNoIntersection() throws InterruptedException {

        final var rectangle1 = new Rectangle(0, 0, 300, 200);
        final var rectangle2 = new Rectangle(310, 50, 300, 200);

        final var analysis = classifierService.getAnalysis(rectangle1, rectangle2);
//        debug(rectangle1, rectangle2);

        Assertions.assertEquals("No Intersection", analysis.getIntersection());
        Assertions.assertEquals("No Containment", analysis.getContainment());
        Assertions.assertEquals("Not Adjacent", analysis.getAdjacency());

    }

    @Test
    @DisplayName("Contained")
    void classifyContained() throws InterruptedException {

        final var rectangle1 = new Rectangle(0, 0, 100, 100);
        rectangle1.setBounds(rectangle1);

        final var rectangle2 = new Rectangle(10, 10, 50, 50);
        rectangle2.setBounds(rectangle2);

        final var analysis = classifierService.getAnalysis(rectangle1, rectangle2);
//        debug(rectangle1, rectangle2);

        Assertions.assertEquals("No Intersection", analysis.getIntersection());
        Assertions.assertEquals("Containment", analysis.getContainment());
        Assertions.assertEquals("Not Adjacent", analysis.getAdjacency());

    }

    @Test
    @DisplayName("Not connected")
    void classifyNotConnected() throws InterruptedException {

        final var rectangle1 = new Rectangle(0, 0, 2, 4);
        final var rectangle2 = new Rectangle(10, 10, 3, 5);

        final var analysis = classifierService.getAnalysis(rectangle1, rectangle2);
//        debug(rectangle1, rectangle2);

        Assertions.assertEquals("No Intersection", analysis.getIntersection());
        Assertions.assertEquals("No Containment", analysis.getContainment());
        Assertions.assertEquals("Not Adjacent", analysis.getAdjacency());

    }

    @Test
    @DisplayName("Adjacent Top")
    void classifyAdjacentTop() throws InterruptedException {

        final var rectangle1 = new Rectangle(0, 0, 100, 200);
        final var rectangle2 = new Rectangle(100, 50, 100, 100);

        final var analysis = classifierService.getAnalysis(rectangle1, rectangle2);
        //debug(rectangle1, rectangle2);

        Assertions.assertEquals("No Intersection", analysis.getIntersection());
        Assertions.assertEquals("No Containment", analysis.getContainment());
        Assertions.assertEquals("Adjacent", analysis.getAdjacency());

    }

    @Test
    @DisplayName("Adjacent Right")
    void classifyAdjacentRight() throws InterruptedException {

        final var rectangle1 = new Rectangle(0, 0, 100, 200);
        final var rectangle2 = new Rectangle(100, 50, 100, 100);

        final var analysis = classifierService.getAnalysis(rectangle1, rectangle2);
        //debug(rectangle1, rectangle2);

        Assertions.assertEquals("No Intersection", analysis.getIntersection());
        Assertions.assertEquals("No Containment", analysis.getContainment());
        Assertions.assertEquals("Adjacent", analysis.getAdjacency());

    }

    @Test
    @DisplayName("Adjacent Bottom")
    void classifyAdjacentBottom() throws InterruptedException {

        final var rectangle1 = new Rectangle(0, 0, 100, 200);
        final var rectangle2 = new Rectangle(50, 200, 100, 100);

        final var analysis = classifierService.getAnalysis(rectangle1, rectangle2);
//        debug(rectangle1, rectangle2);

        Assertions.assertEquals("No Intersection", analysis.getIntersection());
        Assertions.assertEquals("No Containment", analysis.getContainment());
        Assertions.assertEquals("Adjacent", analysis.getAdjacency());

    }

    @Test
    @DisplayName("Adjacent Left")
    void classifyAdjacentLeft() throws InterruptedException {

        final var rectangle1 = new Rectangle(100, 50, 100, 100);
        final var rectangle2 = new Rectangle(0, 0, 100, 200);

        final var analysis = classifierService.getAnalysis(rectangle1, rectangle2);
        //debug(rectangle1, rectangle2);

        Assertions.assertEquals("No Intersection", analysis.getIntersection());
        Assertions.assertEquals("No Containment", analysis.getContainment());
        Assertions.assertEquals("Adjacent", analysis.getAdjacency());

    }

    @Test
    @DisplayName("Adjacent Right - Sub-line")
    void classifyAdjacentRightSubline() throws InterruptedException {

        final var rectangle1 = new Rectangle(0, 0, 100, 200);
        final var rectangle2 = new Rectangle(100, 50, 100, 100);

        final var analysis = classifierService.getAnalysis(rectangle1, rectangle2);
        //debug(rectangle1, rectangle2);

        Assertions.assertEquals("No Intersection", analysis.getIntersection());
        Assertions.assertEquals("No Containment", analysis.getContainment());
        Assertions.assertEquals("Adjacent", analysis.getAdjacency());
    }

    @Test
    @DisplayName("Adjacent Right - Proper")
    void classifyAdjacentRightProper() throws InterruptedException {

        final var rectangle1 = new Rectangle(0, 0, 100, 200);
        final var rectangle2 = new Rectangle(100, 0, 50, 200);

        final var analysis = classifierService.getAnalysis(rectangle1, rectangle2);
        //debug(rectangle1, rectangle2);

        Assertions.assertEquals("No Intersection", analysis.getIntersection());
        Assertions.assertEquals("No Containment", analysis.getContainment());
        Assertions.assertEquals("Adjacent", analysis.getAdjacency());
    }

    @Test
    @DisplayName("Adjacent Right - Partial")
    void classifyAdjacentRightPartial() throws InterruptedException {

        final var rectangle1 = new Rectangle(0, 50, 100, 200);
        final var rectangle2 = new Rectangle(100, 0, 50, 200);

        final var analysis = classifierService.getAnalysis(rectangle1, rectangle2);
        //debug(rectangle1, rectangle2);

        Assertions.assertEquals("No Intersection", analysis.getIntersection());
        Assertions.assertEquals("No Containment", analysis.getContainment());
        Assertions.assertEquals("Adjacent", analysis.getAdjacency());

    }

    private void debug(Rectangle rectangle1, Rectangle rectangle2) throws InterruptedException {
        final var testPanel = new TestPanel(new Rectangle[]{rectangle1, rectangle2}, new Color[]{Color.RED, Color.BLUE});

        final JFrame frame = new JFrame();
        frame.getContentPane().add(testPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 400));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Thread.sleep(100000);
    }



}