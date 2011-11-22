package com.bogdan.sokoban.ai;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Bogdan
 */
public class SquareTest {

    @Test
    public void createTest() {
        Square node = new Square(SquareType.EMPTY, 0, 1);
        assertNotNull(node);
        assertEquals("Square_0_1", node.getName());
        assertEquals(SquareType.EMPTY, node.getType());
    }

}
