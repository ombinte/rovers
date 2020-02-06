package com.omb;

public class Matrix {

    private final Location LOWWER_LEFT = new Location(0,0);

    private Location upperRight;

    public Matrix(Integer upperRightX, Integer upperRightY) {
        this.upperRight = new Location(upperRightX, upperRightY);
    }

    public Location getLOWWER_LEFT() {
        return LOWWER_LEFT;
    }

    public Location getUpperRight() {
        return upperRight;
    }
}
