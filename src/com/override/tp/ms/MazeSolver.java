package com.override.tp.ms;

import javafx.scene.paint.Color;

import java.util.Arrays;

public class MazeSolver {

    private Maze maze;
    private PossibleWay way = new PossibleWay();

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }


    public void solve(){
        Case start = maze.getStartCase();
        new Thread(() -> {
            try {
                handleCase(start);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void handleCase(Case cas) throws InterruptedException {
        cas.setFill(Color.BLUE);
        Thread.sleep(50);
        cas.setFill(cas.getType().getColor());
        if (cas.getType() == CaseType.END) return;
        checkCase(cas);
        if (maze.isDeadlyWay(cas))
            handleCase(maze.getCaseAt(way.lastIntersection()));
        handleCase(nextCaseOf(cas));
    }

    private Case nextCaseOf(Case cas){
        Point2D loc = cas.getLoc();
        Case right = maze.getCaseAt(loc.clone().add(1, 0));
        Case left = maze.getCaseAt(loc.clone().add(-1, 0));
        Case top = maze.getCaseAt(loc.clone().add(0, 1));
        Case bottom = maze.getCaseAt(loc.clone().add(0, -1));
        for (Case c : Arrays.asList(right, left, top, bottom)){
            if (c.getType() == CaseType.WAY || c.getType() == CaseType.END)
                return c;
        }
        return null;
    }

    private void checkCase(Case cas){
        way.addCase(cas);
        cas.setType(CaseType.POSSIBLE_WAY);
        int i = maze.getNumberOfValidWay(cas);
        if (i > 1) {
            way.addIntersection(cas.getLoc());
    //        System.out.println(cas);
        }
    }


}
