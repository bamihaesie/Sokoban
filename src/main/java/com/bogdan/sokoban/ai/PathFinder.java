package com.bogdan.sokoban.ai;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.logging.Logger;

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

    /**
     *
     * A* algorithm to find the shortest path between two squares
     *
     * @param start the starting square
     * @param finish the finish square
     * @return true if there is a path between two given squares
     */
    public boolean findPath(Square start, Square finish) {

        start.setH(computeH(start, finish));
        start.setG(0);
        openList.add(start);

        while (!openList.isEmpty()) {

            Square current = openList.poll();

            closedList.add(current);
            if (current.getType() == SquareType.FINISH) {
                return true;
            }

            List<Square> neighbors =  grid.getNeighbors(current);
            for (Square neighbor : neighbors) {
                if (!closedList.contains(neighbor) && isWalkable(neighbor)) {
                    if (!openList.contains(neighbor)) {
                        neighbor.setParent(current);
                        neighbor.setH(computeH(neighbor, finish));
                        neighbor.setG(computeG(current));
                        openList.add(neighbor);
                    } else {
                        if (neighbor.getG() > current.getG() + 1) {
                            neighbor.setParent(current);
                            neighbor.setH(computeH(neighbor, finish));
                            neighbor.setG(computeG(current));
                        }
                    }
                }
            }
        }

        return false;
    }

    /**
     *
     * Decides if the given square can be walked on
     *
     * @param square the given square
     * @return true if the square can be walked on
     */
    private boolean isWalkable(Square square) {
        if (square.getType() == SquareType.EMPTY ||
                square.getType() == SquareType.FINISH) {
            return true;
        }
        return false;
    }

    /**
     *
     * H is the estimated distance to the finish square
     *
     * @param a the starting square
     * @param b the finish square
     * @return the estimated distance (x difference plus y difference for example)
     */
    private int computeH(Square a, Square b) {
        Position pos1 = a.getPosition();
        Position pos2 = b.getPosition();

        int xDiff = pos1.getX() - pos2.getX();
        if (xDiff < 0) {
            xDiff = -xDiff;
        }

        int yDiff = pos1.getY() - pos2.getY();
        if (yDiff < 0) {
            yDiff = -yDiff;
        }

        return xDiff + yDiff;
    }

    /**
     *
     * G is the distance from the starting point to the given square
     *
     * @param a given square
     * @return computed distance
     */
    private int computeG(Square a) {
        return a.getG() + 1;
    }

}
