package com.bogdan.sokoban.ai;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author Bogdan
 */
public class GridTest {

    private Grid grid;

    @Before
    public void setUp() {
        URL url = this.getClass().getResource("/grid1.txt");
        assertNotNull("Can't open input file!", url);
        File gridFile = new File(url.getFile());
        grid = new Grid(gridFile);

    }

    @Test
    public void getRowCountTest() {
        assertEquals(4, grid.getRowCount());
    }

    @Test
    public void getColumnCountTest() {
        assertEquals(5, grid.getColumnCount());
    }

    @Test
    public void gridContentTest() {
        int[][] expectedGrid = {{0, 0, 0, 0, 0},
                                {0, 0, 3, 0, 0},
                                {1, 0, 3, 0, 2},
                                {0, 0, 3, 0, 0}};
        for (int i=0; i<grid.getRowCount(); i++) {
            for (int j=0; j<grid.getColumnCount(); j++) {
                assertEquals(expectedGrid[i][j], grid.get(i, j).getType().getCode());
                assertEquals("Square_" + i+ "_" + j, grid.get(i, j).getName());
            }
        }
    }

    @Test
    public void invalidAccessTooLowTest() {
        assertNull(grid.get(-1, -1));
    }

    @Test
    public void invalidAccessTooHighTest() {
        assertNull(grid.get(100, 100));
    }

    @Test
    public void getCornerNeighborsTest() {
        Square square = grid.get(0, 0);
        assertEquals(2, grid.getNeighborCount(square));
    }

    @Test
    public void getSideNeighborsTest() {
        Square square = grid.get(0, 1);
        assertEquals(3, grid.getNeighborCount(square));
    }

    @Test
    public void getMiddleNeighborsTest() {
        Square square = grid.get(1, 1);
        assertEquals(4, grid.getNeighborCount(square));
    }

    @Test
    public void getNeighborsTest() {
        Square square = grid.get(1, 1);
        assertEquals(4, grid.getNeighbors(square).size());
    }

    @Test
    public void getByTypeStartTest() {
        List<Square> candidates = grid.getAllSquaresByType(SquareType.START);
        assertNotNull(candidates);
        assertEquals(1, candidates.size());
        for (Square candidate : candidates) {
            assertEquals(SquareType.START, candidate.getType());
        }
    }

    @Test
    public void getByTypeFinishTest() {
        List<Square> candidates = grid.getAllSquaresByType(SquareType.FINISH);
        assertNotNull(candidates);
        assertEquals(1, candidates.size());
        for (Square candidate : candidates) {
            assertEquals(SquareType.FINISH, candidate.getType());
        }
    }

    @Test
    public void getByTypeWallTest() {
        List<Square> candidates = grid.getAllSquaresByType(SquareType.WALL);
        assertNotNull(candidates);
        assertEquals(3, candidates.size());
        for (Square candidate : candidates) {
            assertEquals(SquareType.WALL, candidate.getType());
        }
    }

    @Test
    public void getByTypeEmptyTest() {
        List<Square> candidates = grid.getAllSquaresByType(SquareType.EMPTY);
        assertNotNull(candidates);
        assertEquals(15, candidates.size());
        for (Square candidate : candidates) {
            assertEquals(SquareType.EMPTY, candidate.getType());
        }
    }

}
