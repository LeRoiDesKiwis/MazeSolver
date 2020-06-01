package com.override.tp.ms;

import java.util.Objects;

public class Point2D {

    private int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point2D add(int x, int y){
        this.x += x;
        this.y += y;
        return this;
    }

    @Override
    public Point2D clone(){
        return new Point2D(this.x, this.y);
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return x == point2D.x &&
                y == point2D.y;
    }

    @Override
    public int hashCode() {
        return x * 31 + y * 31;
    }
}
