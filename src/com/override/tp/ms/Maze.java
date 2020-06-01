package com.override.tp.ms;

import javafx.scene.layout.GridPane;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Maze extends GridPane {

    private final Map<Point2D, Case> cases = new HashMap<>();
    private int numOfXCases, numOfYCases;
    private Case startCase;

    public Maze(){
    //    fillAll();
      /*  setOnMouseClicked(event -> {
            int x = (int) event.getX();
            int y = (int) event.getY();
            int caseX = x / 25;
            int caseY = y / 25;
            System.out.println(x + ", " + y);
            System.out.println(caseX + ", " + caseY);
            addWall(caseX, caseY);
        });
       */
      buildMaze(getMaze());
    }

    private void buildMaze(String pattern) {
        int x = 0;
        int y = 0;
        for (char c : pattern.toCharArray()){
            switch (c){
                case '1': addCase(new Case(CaseType.WALL, new Point2D(x, y))); break;
                case '0': addCase(new Case(CaseType.WAY, new Point2D(x, y))); break;
                case 'E': addCase(new Case(CaseType.END, new Point2D(x, y))); break;
                case 'S': Case start =  new Case(CaseType.START, new Point2D(x, y));
                    addCase(start);
                    this.startCase = start;
                    break;
                case '\n': y++; x=-1; break;
                default: throw new IllegalArgumentException('\'' + Character.toString(c) + " is not authorized !");
            }
            x++;
        }
        numOfXCases = x;
        numOfYCases = y + 1;
    }

    public int getNumOfXCases() {
        return numOfXCases;
    }

    public int getNumOfYCases() {
        return numOfYCases;
    }


    private void addCase(Case mazeCase){
        Point2D caseLoc = mazeCase.getLoc();
        cases.put(caseLoc, mazeCase);
        GridPane.setConstraints(mazeCase, caseLoc.getX(), caseLoc.getY());
        getChildren().add(mazeCase);
    }

    public Case getCaseAt(int x, int y){
        return getCaseAt(new Point2D(x, y));
    }

    public Case getCaseAt(Point2D point2D){
        return cases.get(point2D);
    }

    /**
     * this method check if a case is in a deadWay.
     * it will check if this case have less than 1 exit issue;
     * */
    public boolean isDeadlyWay(Case mazeCase){
        return getNumberOfValidWay(mazeCase) < 1;
    }

    public int getNumberOfValidWay(Case mazeCase){
        Point2D loc = mazeCase.getLoc();
        Case right = getCaseAt(loc.clone().add(1, 0));
        Case left = getCaseAt(loc.clone().add(-1, 0));
        Case top = getCaseAt(loc.clone().add(0, 1));
        Case bottom = getCaseAt(loc.clone().add(0, -1));
        int wayValue = 0;
        for (Case nextMazeCase : Arrays.asList(right, left, top, bottom)){
            if (nextMazeCase != null && nextMazeCase.getType() == CaseType.WAY)
                wayValue++;
        }
        return wayValue;
    }

    public Case getStartCase(){
        return startCase;
    }


    private String getMaze() {
        return "1111111111111S11111111111111111111111111111111111\n" +
                "1000100000100000000010000000001000000010000000101\n" +
                "1010111010101111101010101111101111101110101110101\n" +
                "1010001010001000001010100000100000100000101000001\n" +
                "1011101111111011101110111110111110111111101111101\n" +
                "1000100000100010101000100010000010000000001000101\n" +
                "1010111110101110101011101011111011111111101010111\n" +
                "1010100010101000001000101000001010000000101010001\n" +
                "1110101110101111111110101110111010111011101011101\n" +
                "1000100010101000000000101010100010001000001000101\n" +
                "1011111010101011111111101010101111101111111110101\n" +
                "1000100010100000001000001000100000100000100000101\n" +
                "1110101010111111101111101111111110111111101111101\n" +
                "1000101010001010001000100000000010100000101000101\n" +
                "1111101011101010111010101111111010101110101011101\n" +
                "1010001010001000100010100000001010101000101010001\n" +
                "1010101110111110111010111111111010101010101010111\n" +
                "1010100010000010000010000000001010001010100010001\n" +
                "1010111011111010111111111111101011111011101111101\n" +
                "1010101000001010100000100000001000001000001000101\n" +
                "1010101011101011101110101111111011111111111010101\n" +
                "1010101010001010001010100010001000001000000010101\n" +
                "1010101010111010111010111010101110101011111110101\n" +
                "1000001010001010100010001000100010101000000010001\n" +
                "1011111011111010101111101111111010101111111011111\n" +
                "1010100010001000101000101000100010100000001000001\n" +
                "1010101110101111101010101110101111111111101111101\n" +
                "1000100010100000001010100010001000000000001000001\n" +
                "1110111010111110111010111010111011111111111011101\n" +
                "1000101000100010000010001010000010000000001000101\n" +
                "1011101111101011101111101010111110111111101110101\n" +
                "1000101000001000100000101010100010001000101000101\n" +
                "1110101011111110111110101011101010101011101011101\n" +
                "1000001000000010100010101000001010101000100010001\n" +
                "1011111111111010101011101111111011101010111110111\n" +
                "1010000000100010001000001000000010001010100000001\n" +
                "1010111110101111111111101011111110111010101111111\n" +
                "1010000010100010000010001000001000100010000010001\n" +
                "1011111010111010111110111111101110111111111110101\n" +
                "1010001010000010000000100000100010100010001000101\n" +
                "1010101011111110111111111110111010101010101011101\n" +
                "1010100010000010000000100000001010001000100010001\n" +
                "1110111110111011111110101111111011111011111010101\n" +
                "1000100000101010000010001000001000001010001010101\n" +
                "1010101111101010111010111011101111101110101110101\n" +
                "1010100010001010001010100010100000100000100010101\n" +
                "1011111010101011101011101110101111111111111010101\n" +
                "1000000000101000001000000000100000000000000000101\n" +
                "111111111E111111111111111111111111111111111111111";
    }
}
