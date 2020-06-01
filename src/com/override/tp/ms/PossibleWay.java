package com.override.tp.ms;

import java.util.Deque;
import java.util.LinkedList;

public class PossibleWay {

    private Deque<Point2D> intersections = new LinkedList<>();
    private Deque<Case> validCases = new LinkedList<>();

    public void addIntersection(Point2D point2D){
        System.out.println("intersection marked in " + point2D.getX() + ", " + point2D.getY());
        intersections.addLast(point2D);
    }

    public void addCase(Case cas){
        validCases.addLast(cas);
    }

    public Point2D lastIntersection() {
        Point2D lastIntersection = intersections.pollLast();
        removeInValidCases(lastIntersection);
        System.out.println("last intersection is " + lastIntersection);
        return lastIntersection;
    }

    private void removeInValidCases(Point2D intersection) {
        Case invalid;
        System.out.println(validCases);
        while ((invalid = validCases.pollLast()) != null && !invalid.getLoc().equals(intersection)){
            invalid.setType(CaseType.CHECKED_INVALID);
        }
    }
}
