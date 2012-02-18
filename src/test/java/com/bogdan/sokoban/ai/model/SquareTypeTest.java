package com.bogdan.sokoban.ai.model;

import com.bogdan.sokoban.ai.model.SquareType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Bogdan
 */
public class SquareTypeTest {

    @Test
    public void getCountTest() {
         assertEquals(5, SquareType.values().length);
    }

    @Test
    public void getNodeTypeByCodeTest() {
        assertEquals(SquareType.EMPTY, SquareType.getNodeTypeByCode(0));
        assertEquals(SquareType.START, SquareType.getNodeTypeByCode(1));
        assertEquals(SquareType.FINISH, SquareType.getNodeTypeByCode(2));
        assertEquals(SquareType.WALL, SquareType.getNodeTypeByCode(3));
    }
    
}
