package com.bogdan.sokoban.ai;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;

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
    public void readFromFileTest() {
        assertNotNull(graph.getVertices());
        assertEquals(25, graph.getVertices().size());
    }

    @Test
    public void startIsSetTest() {
        assertNotNull(graph.getStart());
    }

    @Test
    public void finishIsSetTest() {
        assertNotNull(graph.getFinish());
    }

}
