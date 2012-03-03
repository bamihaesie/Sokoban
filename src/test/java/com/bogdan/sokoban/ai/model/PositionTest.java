package com.bogdan.sokoban.ai.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author bogdan
 */
public class PositionTest {

    @Test
    public void createTest() {
        Position position = new Position(1, 2);
        assertNotNull(position);
        assertPosition(position, 1, 2);
    }

    @Test
    public void incrementXTest() {
        Position position = new Position(4, 8);
        assertPosition(position, 4, 8);
        assertPosition(position.incrementX(), 5, 8);
    }

    @Test
    public void decrementXTest() {
        Position position = new Position(4, 8);
        assertPosition(position, 4, 8);
        assertPosition(position.decrementX(), 3, 8);
    }

    @Test
    public void incrementYTest() {
        Position position = new Position(4, 8);
        assertPosition(position, 4, 8);
        assertPosition(position.incrementY(), 4, 9);
    }

    @Test
    public void decrementYTest() {
        Position position = new Position(4, 8);
        assertPosition(position, 4, 8);
        assertPosition(position.decrementY(), 4, 7);
    }

    private void assertPosition(Position position, int x, int y) {
        assertNotNull(position);
        assertEquals(x, position.getX());
        assertEquals(y, position.getY());
    }

}
