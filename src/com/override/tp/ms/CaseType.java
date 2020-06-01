package com.override.tp.ms;

import javafx.scene.paint.Color;

public enum CaseType {

    WALL(Color.BLACK),
    WAY(Color.WHITE),
    START(Color.GREEN),
    END(Color.RED),
    CHECKED_INVALID(Color.ORANGE),
    POSSIBLE_WAY(Color.MAGENTA);

    private Color color;

    CaseType(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
