package com.bogdan.sokoban.ai.model;

/**
 * @author Bogdan
 */
public enum SquareType {

    EMPTY   (0),
    START   (1),
    FINISH  (2),
    WALL    (3),
    MAN     (4);

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