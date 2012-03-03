package com.bogdan.sokoban.ai.model;

/**
 * @author Bogdan
 */
public class Square implements Comparable<Square> {

    private String name;
    private SquareType type;
    private Position position;
    private int g, h;
    private Square parent;
    private boolean deadEnd;

    public Square(SquareType type, int x, int y) {
        this.type = type;
        this.position = new Position(x, y);
        this.name = "Square_" + x + "_" + y;
    }

    public SquareType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return getG() + getH();
    }

    public Square getParent() {
        return parent;
    }

    public void setParent(Square parent) {
        this.parent = parent;
    }

    public boolean isDeadEnd() {
        return deadEnd;
    }

    public void setDeadEnd(boolean deadEnd) {
        this.deadEnd = deadEnd;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Square) {
            Square anotherSquare = (Square) object;
            return compareTo(anotherSquare) == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Square\n");
        stringBuilder.append("\t name = " + name + " \n");
        stringBuilder.append("\t type = " + type + " \n");
        stringBuilder.append("\t g = " + g + " \n");
        stringBuilder.append("\t h = " + h + " \n");
        return stringBuilder.toString();
    }

    public int compareTo(Square anotherSquare) {
        if (getF() > anotherSquare.getF()) {
            return 1;
        }
        if (getF() < anotherSquare.getF()) {
            return -1;
        }
        return 0;
    }
}


