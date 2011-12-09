package com.bogdan.sokoban.ai;

import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * @author Bogdan
 */
public class PathFinderTest {

    PathFinder pathFinder;

    @Test
    public void testThereIsPath() {
        Grid grid = createGridFromFile("/grid1.txt");
        pathFinder = new PathFinder(grid);
        Square start = grid.getAllSquaresByType(SquareType.START).get(0);
        Square finish = grid.getAllSquaresByType(SquareType.FINISH).get(0);
        assertTrue("There should be a path!", pathFinder.findPath(start, finish));
    }

    @Test
    public void testThereIsNoPath() {
        Grid grid = createGridFromFile("/grid2.txt");
        pathFinder = new PathFinder(grid);
        Square start = grid.getAllSquaresByType(SquareType.START).get(0);
        Square finish = grid.getAllSquaresByType(SquareType.FINISH).get(0);
        assertFalse("There should be no path!", pathFinder.findPath(start, finish));
    }

    @Test
    public void testThereIsPathAndParentsAreSet() {
        Grid grid = createGridFromFile("/grid1.txt");
        pathFinder = new PathFinder(grid);
        Square start = grid.getAllSquaresByType(SquareType.START).get(0);
        Square finish = grid.getAllSquaresByType(SquareType.FINISH).get(0);
        pathFinder.findPath(start, finish);
        Square current = finish;
        while(current != null && current != start) {
            System.out.println(current);
            current = current.getParent();
        }
        assertNotNull(current);
        assertEquals(start, current);

    }

    private Grid createGridFromFile(String fileName) {
        URL url = this.getClass().getResource(fileName);
        assertNotNull("Can't open input file!", url);
        File gridFile = new File(url.getFile());
        return new Grid(gridFile);
    }

}
