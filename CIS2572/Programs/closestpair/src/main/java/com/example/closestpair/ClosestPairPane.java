package com.example.closestpair;

/**
 * @author David White
 * Class: CIS2572
 * Instructor:  Mohammad Morovati
 * Assignment: Programming exercise 22.17
 * File: ClosestPair.java
 * Description:
 * Write a program that enables the user to add/remove points by clicking the left/right mouse
 * button and displays a line that connects a pair of the nearest points.
 **/

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;




public class ClosestPairPane extends Pane {
    // list of all the circles
    private final List<Circle> circles;

    // line connecting the two closest points
    private Line connection;

    // no arg constructor
    public ClosestPairPane(){
        circles = new ArrayList<>();
        drawPane();
    }
    /**
     * draws pane
     */
    private void drawPane(){
        setPrefSize(500,500);
        setOnMouseClicked(this::placePoint);
    }

    /**
     * Place point where LMB is clicked
     * @param event a mouse click
     */

    private void placePoint(MouseEvent event) {
        if (!event.getButton().equals(MouseButton.PRIMARY)) {
            return;
        }
        Circle circle = new Circle(5);
        circle.setCenterX(event.getX());
        circle.setCenterY(event.getY());
        circle.setOnMouseClicked(this::removePoint);
        circles.add(circle);
        getChildren().add(circle);
        connectClosestPoints();
    }

    /**
     * Remove point where RMB is clicked
     * @param event a mouse click
     */
    private void removePoint(MouseEvent event) {
        if (!event.getButton().equals(MouseButton.SECONDARY)){return;}
        Circle circle = (Circle)event.getSource();
        circles.remove(circle);
        getChildren().remove(circle);
        connectClosestPoints();
    }

    /**
     * connects the two closest points
     */
    private void connectClosestPoints() {
        if (circles.size() > 2){

            PointPair closest = preProcess(circleToPoint2d());
            Point2D pointA = closest.getPointA();
            Point2D pointB = closest.getPointB();
            getChildren().remove(connection);
            connection = new Line(pointA.getX(), pointA.getY(), pointB.getX(), pointB.getY());
            getChildren().add(connection);
        } else {
            getChildren().remove(connection);
        }
    }


    /* could never get this to work
    /**
     * Returns the Circles as point(2D)s
     * @return list of circles as points
     */
  /*  private Point2D.Double[] circleToPoint2d(){
        Point2D.Double[] CirclePoints = new Point2D.Double[circles.size()];
        for (int i = 0; i < circles.size(); i++) {
            Point2D.Double circle = new Point2D.Double(circles.get(i).getCenterX(), circles.get(i).getCenterY());
            CirclePoints[i] = circle;
        }
        return CirclePoints;
    }

    public static void qSortXValues(Point2D.Double[] xPoints, int left, int right) {
        int index = partitionXValues(xPoints, left, right);
        if (left < index - 1){
            qSortXValues(xPoints, left, index - 1);
        }
        else if (index < right){
            qSortXValues(xPoints, index, right);
        }
    }

    public static void qSortYValues(Point2D.Double[] yPoints, int left, int right) {
        int index = partitionYValues(yPoints, left, right);
        if (left < index - 1){
            if (index == 1) {
                qSortYValues(yPoints, left, index);
            }else
                qSortYValues(yPoints, left, index - 1);
        }
        else if (index < right){
            qSortYValues(yPoints, index, right);
        }
    }

    public static int partitionXValues(Point2D.Double[] xPoints, int left, int right){
        int L = left, R = right;
        Point2D.Double temp;
        Point2D.Double pivot = xPoints[((left + right) / 2)];
        while (L <= R){
            while (xPoints[L].getX() < pivot.getX()){
                L++;
            }
            while (xPoints[R].getX() > pivot.getX()){
                R--;
            }
            if (L <= R){
                temp = xPoints[L];
                xPoints[L] = xPoints[R];
                xPoints[R] = temp;
                L++;
                R--;
            }
        }

        return L;
    }

    public static int partitionYValues(Point2D.Double[] YPoints, int left, int right){
        int L = left, R = right;
        Point2D.Double temp;
        Point2D.Double pivot = YPoints[(left + right) / 2];
        while (L <= R){
            while (YPoints[L].getY() < pivot.getY()){
                L++;
            }
            while (YPoints[R].getY() > pivot.getY()){
                R--;
            }
            if (L <= R){
                temp = YPoints[L];
                YPoints[L] = YPoints[R];
                YPoints[R] = temp;
                L++;
                R--;
            }
        }

        return L;
    }*/

    /**
     *
     * @param points the original list of Point2D.Doubles
     * @return Calls the closest pair function with parameters of
     * two sorted lists of the pass in collection of Point2D.Doubles -
     * one sorted by the x-Coordinate and the other by the y-Coordinate.
     */
    /*public static PointPair preProcess(Point2D.Double[] points){
        Point2D.Double[] xPoints = new Point2D.Double[points.length];
        Point2D.Double[] yPoints = new Point2D.Double[points.length];

        for (int i = 0; i < points.length; i++) {
            xPoints[i] = points[i];
            yPoints[i] = points[i];
        }

        qSortXValues(xPoints, 0, xPoints.length - 1);
        qSortYValues(yPoints, 0, yPoints.length - 1);

        return getClosestPair(xPoints, yPoints);
    }*/

    /**
     *
     * @param xPoints the sorted points by x coordinate
     * @param yPoints
     * @return
     */
    private static PointPair getClosestPair(Point2D.Double[] xPoints, Point2D.Double[] yPoints) {
        if (xPoints.length > 3){
            return bruteforce(xPoints);
        }
        else {
            /* this else statement sets up the recursive calls to the getClosestPair function until
               the parameter lengths are small enough for brute force to take over */

            Point2D.Double[] xPointsLeft = new Point2D.Double[xPoints.length / 2];
            Point2D.Double[] xPointsRight = new Point2D.Double[xPoints.length - xPointsLeft.length];
            Point2D.Double[] yPointsLeft = new Point2D.Double[yPoints.length / 2];
            Point2D.Double[] yPointsRight = new Point2D.Double[yPoints.length - yPointsLeft.length];

            for (int i = 0; i < xPointsLeft.length; i++) {
                // fills the two left halves of the sets sorted by x
                xPointsLeft[i] = xPoints[i];
                yPointsLeft[i] = xPoints[i];
            }

            for (int i = xPointsLeft.length; i < xPoints.length; i++) {
                // divides the two sets sorted by x and y into left halves
                xPointsRight[i - xPointsLeft.length] = xPoints[i];
                yPointsRight[i - xPointsLeft.length] = xPoints[i];
            }
            // sorts other left half by y-coordinate
            if (yPointsLeft.length == 1) {
                qSortXValues(yPointsLeft, 0, yPointsLeft.length + 1);
            }else{
                qSortXValues(yPointsLeft, 0, yPointsLeft.length - 1);
            }

            // sorts other right half by y-coordinate
            qSortXValues(yPointsRight, 0, yPointsRight.length - 1);

            PointPair leftPair = getClosestPair(xPointsLeft, yPointsLeft);
            PointPair rightPair = getClosestPair(xPointsRight, yPointsRight);

            PointPair closestPair = leftPair;

            if (rightPair.getDistance() < closestPair.getDistance()){
                /* closest pair will be the greater of the final two pairs of points of the two
                   main halves of the coordinate plane */
                closestPair = rightPair;
            }

            double distance = closestPair.getDistance();

            // Check across the vertical division of the point set
            ArrayList<Point2D.Double> yPointsList = new ArrayList<>();

            // median will be the point on the dividing line on each recursive call of getClosestPairs
            Point2D.Double median = xPoints[xPoints.length/2];

            int aboveMedian = (xPoints.length / 2) - 1;
            int belowMedian = (xPoints.length / 2) + 1;

            while (aboveMedian >= 0 && Math.abs(median.getX() - xPoints[belowMedian].getX()) <= distance){
                // add points to list if x-coordinate is within distance less than the median
                yPointsList.add(xPoints[belowMedian]);
                aboveMedian--;
            }

            while (belowMedian < xPoints.length && Math.abs(median.getX() - xPoints[belowMedian].getX()) <= distance) {
                // add points to list if x-coordinate is within distance grater than the median
                yPointsList.add(xPoints[belowMedian]);
                belowMedian++;
            }
            yPointsList.add(median); // add median to list

            // convert ArrayList into array in order to qSort
            Point2D.Double[] yPointsListArray = new Point2D.Double[yPointsList.size()];
            yPointsListArray = yPointsList.toArray(yPointsListArray);

            qSortYValues(yPointsListArray,0,yPointsListArray.length-1);

            for (int i = 0; i < yPointsListArray.length; i++) {
                int j = i + 1;
                while (j < yPointsListArray.length &&
                        Math.abs(yPointsListArray[i].getY() - yPointsListArray[j].getY()) <= distance){
                    /* this prevents the checking all the points within each resulting array.
                       only the points within vertical distance are checked */
                    PointPair check = new PointPair(yPointsListArray[i], yPointsListArray[j]);
                    if (check.getDistance() < distance){
                        closestPair = check;
                        distance = closestPair.getDistance();
                    }
                }
            }

            return closestPair;
        }

    }

    public static PointPair bruteforce(Point2D.Double[] points){
        if (points.length == 2){
            return new PointPair(points[0], points[1]);
        }
        else{
            PointPair pairA = new PointPair(points[0], points[1]);
            PointPair pairB = new PointPair(points[1], points[2]);
            PointPair pairC = new PointPair(points[0], points[2]);

            if (pairA.getDistance() < pairB.getDistance() && pairA.getDistance() < pairC.getDistance())
                return pairA;
            else if (pairB.getDistance() < pairA.getDistance() && pairB.getDistance() < pairC.getDistance())
                return pairB;
            else
                return pairC;
        }
    }
}