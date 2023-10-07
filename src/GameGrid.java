import java.util.*;

public class GameGrid {
    public final int LEFT = 0, RIGHT = 1, UP = 2, DOWN = 3, EMPTY = 0;
    private int ENDING_TILE;
    private final Random rand;
    public final int[][] grid;
    private final Scanner sc;
    public final int GRID_SIZE;
    public int score;

    public boolean gameFinished = false;

    public GameGrid() {
        this(4);
    }

    public GameGrid(int size) {
        GRID_SIZE = size;
        grid = new int[GRID_SIZE][GRID_SIZE];
        sc = new Scanner(System.in);
        rand = new Random();
        ENDING_TILE = 2048;
    }

    public void setGrid(int[][] arr) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                grid[row][col] = arr[row][col];
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return GRID_SIZE;
    }

    public void setLimit(int limit){
        ENDING_TILE = limit;
    }

    public void initialiseGrid() {
        int row1 = rand.nextInt(GRID_SIZE);
        int col1 = rand.nextInt(GRID_SIZE);
        grid[row1][col1] = 2;

        int row2 = rand.nextInt(GRID_SIZE);
        int col2 = rand.nextInt(GRID_SIZE);
        while (row2 == row1 && col2 == col1) {
            row2 = row2 == row1 ? rand.nextInt(GRID_SIZE) : row2;
            col2 = col2 == col1 ? rand.nextInt(GRID_SIZE) : col2;
        }
        grid[row2][col2] = 2;
    }

    public void startConsole() {
        initialiseGrid();
        playConsole();
    }

    private void playConsole() {
        boolean flag = true;
        while (flag && !gameFinished) {
            displayGrid();
            int dir = takeInput();
            move(dir);
            flag = createNewSquare();
        }

        if (gameFinished) {
            System.out.println("\nCongratulations !!! You won !!! XD");
        } else {
            System.out.println("\nGame Over :-(");
        }
    }

    private void displayGrid() {
        System.out.println("\033[H\033[2J");
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[row][col] == EMPTY) {
                    System.out.printf("%5c", '-');
                } else {
                    System.out.printf("%5d", grid[row][col]);
                }
            }
            System.out.println();
        }
    }

    public int takeInput() {
        System.out.print("\nEnter the direction : ");
        return sc.nextInt();
    }

    public void move(int dir) {
        switch (dir) {
            case LEFT -> slideLeft();
            case RIGHT -> slideRight();
            case UP -> slideUp();
            case DOWN -> slideDown();
        }
    }

    public void slideLeft() {
        for (int row = 0; row < GRID_SIZE; row++) {
            int sq1 = -1;
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[row][col] == EMPTY)
                    continue;
                if (sq1 == -1) {
                    sq1 = col;
                } else {
                    if (grid[row][sq1] == grid[row][col]) {
                        grid[row][sq1] *= 2;
                        score += grid[row][sq1];
                        grid[row][col] = EMPTY;
                        sq1 = -1;
                    } else {
                        sq1 = col;
                    }
                }
            }
        }

        for (int row = 0; row < GRID_SIZE; row++) {
            int temp = -1;
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[row][col] != EMPTY) {
                    gameFinished = grid[row][col] == ENDING_TILE;
                    temp++;
                    int val = grid[row][col];
                    grid[row][col] = EMPTY;
                    grid[row][temp] = val;
                }
            }
        }
    }

    public void slideRight() {
        for (int row = 0; row < GRID_SIZE; row++) {
            int sq1 = -1;
            for (int col = GRID_SIZE - 1; col >= 0; col--) {
                if (grid[row][col] == EMPTY)
                    continue;
                if (sq1 == -1) {
                    sq1 = col;
                } else {
                    if (grid[row][sq1] == grid[row][col]) {
                        grid[row][sq1] *= 2;
                        score += grid[row][sq1];
                        grid[row][col] = EMPTY;
                        sq1 = -1;
                    } else {
                        sq1 = col;
                    }
                }
            }
        }

        for (int row = 0; row < GRID_SIZE; row++) {
            int temp = GRID_SIZE;
            for (int col = GRID_SIZE - 1; col >= 0; col--) {
                if (grid[row][col] != EMPTY) {
                    gameFinished = grid[row][col] == ENDING_TILE;
                    temp--;
                    int val = grid[row][col];
                    grid[row][col] = EMPTY;
                    grid[row][temp] = val;
                }
            }
        }
    }

    public void slideUp() {
        for (int col = 0; col < GRID_SIZE; col++) {
            int sq1 = -1;
            for (int row = 0; row < GRID_SIZE; row++) {
                if (grid[row][col] == EMPTY)
                    continue;
                if (sq1 == -1) {
                    sq1 = row;
                } else {
                    if (grid[sq1][col] == grid[row][col]) {
                        grid[sq1][col] *= 2;
                        score += grid[sq1][col];
                        grid[row][col] = EMPTY;
                        sq1 = -1;
                    } else {
                        sq1 = row;
                    }
                }
            }
        }

        for (int col = 0; col < GRID_SIZE; col++) {
            int temp = -1;
            for (int row = 0; row < GRID_SIZE; row++) {
                if (grid[row][col] != EMPTY) {
                    gameFinished = grid[row][col] == ENDING_TILE;
                    temp++;
                    int val = grid[row][col];
                    grid[row][col] = EMPTY;
                    grid[temp][col] = val;
                }
            }
        }
    }

    public void slideDown() {
        for (int col = 0; col < GRID_SIZE; col++) {
            int sq1 = -1;
            for (int row = GRID_SIZE - 1; row >= 0; row--) {
                if (grid[row][col] == EMPTY)
                    continue;
                if (sq1 == -1) {
                    sq1 = row;
                } else {
                    if (grid[sq1][col] == grid[row][col]) {
                        grid[sq1][col] *= 2;
                        score += grid[sq1][col];
                        grid[row][col] = EMPTY;
                        sq1 = -1;
                    } else {
                        sq1 = row;
                    }
                }
            }
        }

        for (int col = 0; col < GRID_SIZE; col++) {
            int temp = GRID_SIZE;
            for (int row = GRID_SIZE - 1; row >= 0; row--) {
                if (grid[row][col] != EMPTY) {
                    gameFinished = grid[row][col] == ENDING_TILE;
                    temp--;
                    int val = grid[row][col];
                    grid[row][col] = EMPTY;
                    grid[temp][col] = val;
                }
            }
        }
    }

    // select a random empty tile and fill it with 2
    public boolean createNewSquare() {
        ArrayList<Cell> cells = new ArrayList<>();
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[row][col] == EMPTY) {
                    cells.add(new Cell(row, col));
                }
            }
        }

        if (cells.isEmpty())
            return false;

        Cell cell = cells.get(rand.nextInt(cells.size()));
        grid[cell.row][cell.col] = 2;

        return true;
    }

    class Cell {
        int row;
        int col;

        public Cell(int x, int y) {
            this.row = x;
            this.col = y;
        }
    }
}
