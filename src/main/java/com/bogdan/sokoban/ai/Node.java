package com.bogdan.sokoban.ai;

/**
 * @author Bogdan
 */
class Node {

    private NodeType type;
    private Position position;
    private int g, h;

    public Node(NodeType type) {
        this.type = type;
    }

    public Node(NodeType type, int x, int y) {
        this(type);
        this.position = new Position(x, y);
    }

    public NodeType getType() {
        return type;
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
        return "Node (" + position.x + "," + position.y + "," + type + ")";
    }
}

class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

enum NodeType {

    EMPTY   (0),
    START   (1),
    FINISH  (2),
    WALL    (3);

    private int code;

    NodeType(int code) {
        this.code = code;
    }

    public static NodeType getNodeTypeByCode(int code) {
        for (NodeType nodeType : values()) {
            if (nodeType.code == code) {
                return nodeType;
            }
        }
        return null;
    }

}
