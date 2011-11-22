package com.bogdan.sokoban.ai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bogdan
 */
public class PathFinder {

    private Grid grid;
    private List<Square> openList, closedList;

    public PathFinder(Grid grid) {
        this.grid = grid;
        openList = new ArrayList<Square>();
        closedList = new ArrayList<Square>();
    }

    public boolean findPath(Square start, Square finish) {
        openList.add(start);
        while (!openList.isEmpty()) {
            openList.remove(0);
        }

        return true;
    }
}
