package com.omb;

public class Rover {

    private Position position;
    private Integer number;

    public Rover() {
        Position position = new Position(new Location(), Cardinal.NORTH);
        this.position = position;
    }

    /**
     * Deplace le Rover en fonction de son orientation
     */
    public void move() {

        if(this.position.getCardinal().equals(Cardinal.NORTH)) {
            moveRoverToNorth();
        }else if(this.position.getCardinal().equals(Cardinal.SOUTH)) {
            moveRoverToSouth();
        } else if(this.position.getCardinal().equals(Cardinal.EST)) {
            moveRoverToEst();
        } else if(this.position.getCardinal().equals(Cardinal.WEST)) {
            moveRoverToWest();
        } else {
            throw  new IllegalArgumentException("Bad navigation argument " + this.position.getCardinal().getCode());
        }
    }

    /**
     * Effectue une rotation de 90° vers la gauche
     */
    public void spinToLeft() {

        Cardinal newCardianl = this.getPosition().getCardinal();
        if(this.getPosition().getCardinal().equals(Cardinal.NORTH)) {
            newCardianl = Cardinal.WEST;
        } else if(this.position.getCardinal().equals(Cardinal.SOUTH)) {
            newCardianl = Cardinal.EST;
        } else if(this.position.getCardinal().equals(Cardinal.EST)) {
            newCardianl = Cardinal.NORTH;
        }else if(this.position.getCardinal().equals(Cardinal.WEST)) {
            newCardianl = Cardinal.SOUTH;
        }

        this.position.setCardinal(newCardianl);
    }

    /**
     * Effectue une rotation de 90° vers la droite
     */
    public void spinToRight() {
        Cardinal newCardianl = this.position.getCardinal();
        if(this.position.getCardinal().equals(Cardinal.NORTH)) {
            newCardianl = Cardinal.EST;
        } else if(this.position.getCardinal().equals(Cardinal.SOUTH)) {
            newCardianl = Cardinal.WEST;
        } else if(this.position.getCardinal().equals(Cardinal.EST)) {
            newCardianl = Cardinal.SOUTH;
        }else if(this.position.getCardinal().equals(Cardinal.WEST)) {
            newCardianl = Cardinal.NORTH;
        }

        this.position.setCardinal(newCardianl);
    }

    /**
     * Verifie que le Rover est toujours sur le plateau
     * @param matrix
     * @return
     */
    public boolean checkCoordinate(Matrix matrix) throws BadCoordinateException{
        if(this.getPosition().getLocation().getX() < matrix.getLOWWER_LEFT().getX()) {
            throw new BadCoordinateException("Mauvaise coordonnee, position " +
                    "minimale en X : 0, rover.x : " + this.getPosition().getLocation().getX());
        }

        if(this.getPosition().getLocation().getX() > matrix.getUpperRight().getX()) {
            throw new BadCoordinateException("Mauvaise coordonnee, position " +
                    "maximale en X : "+ matrix.getUpperRight().getX() +
                    "rover.x : "  +  this.getPosition().getLocation().getX());
        }

        if(this.getPosition().getLocation().getY() < matrix.getLOWWER_LEFT().getY()) {
            throw new BadCoordinateException("Mauvaise coordonnee, position " +
                    "minimale en Y : 0, rover.Y : " + this.getPosition().getLocation().getY());
        }

        if(this.getPosition().getLocation().getY() > matrix.getUpperRight().getY()) {
            throw new BadCoordinateException("Mauvaise coordonnee, position " +
                    "maximale en Y : "+ matrix.getUpperRight().getY() +
                    "rover.x : "  +  this.getPosition().getLocation().getY());
        }

        return true;
    }

    /**
     * Déplace le Rover d'une position en direction du nord.
     */
    private void moveRoverToNorth() {
        Integer newXValue = this.position.getLocation().getY() + 1 ;
        this.position.getLocation().setY(newXValue);
    }

    /**
     * Déplace le Rover d'une position en direction du sud.
     */
    private void moveRoverToSouth() {
        Integer newXValue = this.position.getLocation().getY() - 1 ;
        this.position.getLocation().setY(newXValue);
    }

    /**
     * Déplace le Rover d'une position en direction de l'est.
     */
    private void moveRoverToEst() {
        Integer newYValue = this.position.getLocation().getX() + 1 ;
        this.position.getLocation().setX(newYValue);
    }

    /**
     * Déplace le Rover d'une position en direction de l'ouest.
     */
    private void moveRoverToWest() {
        Integer newYValue = this.position.getLocation().getX() - 1 ;
        this.position.getLocation().setX(newYValue);
    }

    @Override
    public String toString() {

        StringBuilder sb =
                new StringBuilder("Rover (").append(this.position.getLocation()
                        .getX()).append(",").append(this.position.getLocation()
                        .getY()).append(", ").append(this.position.getCardinal().getCode())
                        .append(")");

        return sb.toString();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
