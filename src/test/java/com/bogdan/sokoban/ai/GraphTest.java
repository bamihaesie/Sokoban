package com.bogdan.sokoban.ai;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Bogdan
 */
public class GraphTest {

    private Graph graph;

    @Before
    public void setUp() {
        URL url = this.getClass().getResource("/graph1.txt");
        assertNotNull("Can't open input file!", url);
        File graphFile = new File(url.getFile());
        graph = new Graph(graphFile);
    }

    @Test
    public void numberOfNodesTest() {
        assertNotNull(graph.getVertices());
        assertEquals(25, graph.getVertices().size());
    }

    @Test
    public void startIsSetTest() {
        Node start = graph.getStart();
        assertNotNull(start);
        assertEquals(NodeType.START, start.getType());
    }

    @Test
    public void finishIsSetTest() {
        assertNotNull(graph.getFinish());
    }

    @Test
    public void getNeighborsForStartTest() {
        Node start = graph.getStart();
        List<Node> neighbors = graph.getNeighbors(start);
        assertNotNull(neighbors);
        assertEquals(3, neighbors.size());
        for (Node neighbor : neighbors) {
            assertEquals(NodeType.EMPTY, neighbor.getType());
        }
    }

    @Test
    public void getNeighborsForFinishTest() {
        Node finish = graph.getFinish();
        List<Node> neighbors = graph.getNeighbors(finish);
        assertNotNull(neighbors);
        assertEquals(3, neighbors.size());
        for (Node neighbor : neighbors) {
            assertEquals(NodeType.EMPTY, neighbor.getType());
        }
    }

}
