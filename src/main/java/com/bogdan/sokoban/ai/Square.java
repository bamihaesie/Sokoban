package com.bogdan.sokoban.ai;

/**
 * @author Bogdan
 */
class Square {

    private String name;
    private SquareType type;
    private Position position;
    private int g, h;

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

    @Override
    public String toString() {
        return "Square (" + name + "," + type + ")";
    }
}

enum SquareType {

    EMPTY   (0),
    START   (1),
    FINISH  (2),
    WALL    (3);

    private int code;

    SquareType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static SquareType getNodeTypeByCode(int code) {
        for (SquareType nodeType : values()) {
            if (nodeType.code == code) {
                return nodeType;
            }
        }
        return null;
    }

}
