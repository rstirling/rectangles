package org.rectangles;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.rectangles.classifiers.ClassifierService;
import org.rectangles.util.TestPanel;

import javax.swing.*;
import java.awt.*;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        validateArgs(args);

        final var rectangle1 = getRectangle(args[0]);
        final var rectangle2 = getRectangle(args[1]);

        final var debug = Boolean.parseBoolean(args.length > 2 ? args[2] : "false");

        classify(rectangle1, rectangle2, debug);
    }

    /**
     * Validates mandatory input argument. Checks if the rectangles are
     * @param args
     */
    private static void validateArgs(String[] args) {
        if (args.length < 2 || StringUtils.isEmpty(args[0]) || StringUtils.isEmpty(args[1])
                || args[0].split(",").length != 4 || args[1].split(",").length != 4) {
            System.out.println("Input Error:\nThis application takes 2 rectangles expressed as \"x,y,width,height\" and an optional debug argument " +
                    "\ne.g. java -jar rectangles-1.0-SNAPSHOT-jar-with-dependencies.jar 0,0,100,200 20,20,100,200 true");
            System.exit(1);
        }
    }

    /**
     * Classify 2 given rectangles and displays the debug window according to the parameter
     *
     * @param rectangle1 First rectangle
     * @param rectangle2 Second rectangle
     * @param debug Enables debug window
     */
    private static void classify(Rectangle rectangle1, Rectangle rectangle2, boolean debug) {

        final var classifierService = new ClassifierService();
        final var analysis = classifierService.getAnalysis(rectangle1, rectangle2);
        log.info("Rectangle analysis:");
        log.info("Containment: [{}]", analysis.getContainment());
        log.info("Intersection: [{}]", analysis.getIntersection());
        log.info("Adjacency: [{}]", analysis.getAdjacency());
        if (debug) {
            debug(rectangle1, rectangle2);
        }
    }


    /** Parses the rectangle argument and creates a Rectangle object
     * @param rectangleArgument
     * @return Rectangle object
     */
    private static Rectangle getRectangle(String rectangleArgument) {

        final int x = Integer.parseInt(rectangleArgument.split(",")[0]);
        final int y = Integer.parseInt(rectangleArgument.split(",")[1]);
        final int width = Integer.parseInt(rectangleArgument.split(",")[2]);
        final int height = Integer.parseInt(rectangleArgument.split(",")[3]);

        return new Rectangle(x, y, width, height);
    }

    /**
     * This method creates a window and draws the rectangles. It is used for visual debug purposes.
     * @param rectangle1
     * @param rectangle2
     */
    @SneakyThrows
    private static void debug(Rectangle rectangle1, Rectangle rectangle2) {
        final var testPanel = new TestPanel(new Rectangle[]{rectangle1, rectangle2}, new Color[]{Color.RED, Color.BLUE});

        final JFrame frame = new JFrame();
        frame.getContentPane().add(testPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 400));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //just for debugging
        Thread.sleep(100000);
    }
}