package com.override.tp.ms;


import javafx.scene.shape.Rectangle;

public class Case extends Rectangle {

    private CaseType type;
    private Point2D loc;

    public static final int CASE_SIZE = 15;

    public Case(CaseType type, Point2D loc) {
        super(CASE_SIZE, CASE_SIZE, type.getColor());
        this.type = type;
        this.loc = loc;
    }

    public CaseType getType() {
        return type;
    }

    public Point2D getLoc() {
        return loc;
    }

    public void setType(CaseType type) {
        this.type = type;
        setFill(type.getColor());
    }

    @Override
    public String toString() {
        return "Case{" +
                "type=" + type +
                ", loc=" + loc +
                '}';
    }
}
