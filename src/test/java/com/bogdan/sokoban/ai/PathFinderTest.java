package com.bogdan.sokoban.ai;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Bogdan
 */
public class PathFinderTest {

    PathFinder pathFinder;

    @Test
    public void thereIsAPathTest() {
        Graph graph1 = buildGraphFromFile("/graph1.txt");
        pathFinder = new PathFinder(graph1);
        assertTrue("There should be a path in this graph!", pathFinder.findPath(graph1.getStart(), graph1.getFinish()));
    }

    @Test
    public void thereIsNoPathTest() {
        Graph graph2 = buildGraphFromFile("/graph2.txt");
        pathFinder = new PathFinder(graph2);
        assertFalse("There should be no path in this graph!", pathFinder.findPath(graph2.getStart(), graph2.getFinish()));
    }

    private Graph buildGraphFromFile(String fileName) {
        URL url = this.getClass().getResource(fileName);
        assertNotNull("Can't open input file!", url);
        File graphFile = new File(url.getFile());
        return new Graph(graphFile);
    }

}
