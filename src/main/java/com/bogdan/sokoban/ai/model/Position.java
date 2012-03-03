package com.bogdan.sokoban.ai.model;

/**
 * @author Bogdan
 */
public class Position {

    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position incrementX() {
        return new Position(x+1, y);
    }

    public Position decrementX() {
        return new Position(x-1, y);
    }

    public Position incrementY() {
        return new Position(x, y+1);
    }

    public Position decrementY() {
        return new Position(x, y-1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
