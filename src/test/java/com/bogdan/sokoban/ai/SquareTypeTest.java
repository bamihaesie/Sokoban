package com.bogdan.sokoban.ai;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Bogdan
 */
public class SquareTypeTest {

    @Test
    public void getCountTest() {
         assertEquals(4, SquareType.values().length);
    }

    @Test
    public void getNodeTypeByCodeTest() {
        assertEquals(SquareType.EMPTY, SquareType.getNodeTypeByCode(0));
        assertEquals(SquareType.START, SquareType.getNodeTypeByCode(1));
        assertEquals(SquareType.FINISH, SquareType.getNodeTypeByCode(2));
        assertEquals(SquareType.WALL, SquareType.getNodeTypeByCode(3));
    }
    
}
