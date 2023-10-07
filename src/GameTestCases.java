import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTestCases {

        private GameGrid game;

        @Before
        public void setUp() {
                game = new GameGrid();
        }

        @Test
        public void testSlideUp() {
                int[][] grid = {
                                { 2, 0, 0, 0 },
                                { 2, 0, 0, 0 },
                                { 0, 0, 0, 0 },
                                { 0, 0, 0, 0 }
                };
                game.setGrid(grid);
                game.slideUp();
                int[][] expectedGrid = {
                                { 4, 0, 0, 0 },
                                { 0, 0, 0, 0 },
                                { 0, 0, 0, 0 },
                                { 0, 0, 0, 0 }
                };
                Assert.assertArrayEquals(expectedGrid, game.getGrid());
        }

        @Test
        public void testSlideDown() {
                int[][] grid = {
                                { 0, 0, 0, 0 },
                                { 0, 0, 0, 0 },
                                { 2, 0, 0, 0 },
                                { 2, 0, 0, 0 }
                };
                game.setGrid(grid);
                game.slideDown();
                int[][] expectedGrid = {
                                { 0, 0, 0, 0 },
                                { 0, 0, 0, 0 },
                                { 0, 0, 0, 0 },
                                { 4, 0, 0, 0 }
                };
                Assert.assertArrayEquals(expectedGrid, game.getGrid());
        }

        @Test
        public void testSlideLeft() {
                int[][] grid = new int[][] {
                                { 2, 0, 4, 4 },
                                { 0, 0, 8, 4 },
                                { 0, 0, 8, 16 },
                                { 0, 32, 0, 32 }
                };
                game.setGrid(grid);
                game.slideLeft();
                int[][] expectedGrid = new int[][] {
                                { 2, 8, 0, 0 },
                                { 8, 4, 0, 0 },
                                { 8, 16, 0, 0 },
                                { 64, 0, 0, 0 }
                };
                Assert.assertArrayEquals(expectedGrid, game.getGrid());
        }

        @Test
        public void testSlideRight() {
                int[][] grid = new int[][] {
                                { 0, 0, 0, 0 },
                                { 2, 0, 0, 2 },
                                { 0, 0, 0, 0 },
                                { 2, 2, 2, 4 }
                };
                game.setGrid(grid);
                game.slideRight();
                int[][] expectedGrid = new int[][] {
                                { 0, 0, 0, 0 },
                                { 0, 0, 0, 4 },
                                { 0, 0, 0, 0 },
                                { 0, 2, 4, 4 }
                };
                Assert.assertArrayEquals(expectedGrid, game.getGrid());
        }
}
