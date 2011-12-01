package com.bogdan.sokoban.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Bogdan
 */
public class PathFinder {

    private Grid grid;
    private PriorityQueue<Square> openList;
    private List<Square> closedList;

    public PathFinder(Grid grid) {
        this.grid = grid;
        openList = new PriorityQueue<Square>();
        closedList = new ArrayList<Square>();
    }

    public boolean findPath(Square start, Square finish) {
        openList.add(start);
        while (!openList.isEmpty()) {
            Square current = openList.poll();

        }

        return true;
    }
}
