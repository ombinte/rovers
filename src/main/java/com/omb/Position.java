package com.omb;

public class Position {

    private Location location;
    private Cardinal cardinal;

    public Position() {

    }

    public Position(Location location, Cardinal cardinal) {
        this.location=location;
        this.cardinal = cardinal;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Cardinal getCardinal() {
        return cardinal;
    }

    public void setCardinal(Cardinal cardinal) {
        this.cardinal = cardinal;
    }
}
