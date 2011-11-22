package com.bogdan.sokoban.ai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bogdan
 */
public class PathFinder {

    private Graph graph;
    private List<Node> openList, closedList;

    public PathFinder(Graph graph) {
        this.graph = graph;
        openList = new ArrayList<Node>();
        closedList = new ArrayList<Node>();
    }

    public boolean findPath(Node start, Node finish) {
        openList.add(start);
        while (!openList.isEmpty()) {

        }


        return true;
    }
}
