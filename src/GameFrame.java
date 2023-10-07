import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameFrame {
    private GameGrid game;
    private JPanel panel;
    private JLabel scoreLabel;
    private Component[] tiles;

    public GameFrame(int size) {
        game = new GameGrid(size);
    }

    public GameFrame() {
        this(4);
    }

    public void start() {
        game.initialiseGrid();
        setupGUI();
    }

    public void setupGUI() {
        JFrame frame = new JFrame("Java 2048");

        // label for showing score
        scoreLabel = new JLabel("Score : " + game.score);
        scoreLabel.setFont(Theme.SCORELABEL_FONT);
        scoreLabel.setForeground(Theme.SCORELABEL_COLOR);
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));

        // create a panel with grid layout
        GridLayout layout = new GridLayout(game.GRID_SIZE, game.GRID_SIZE);
        layout.setHgap(Theme.TILE_GAP);
        layout.setVgap(Theme.TILE_GAP);

        panel = new JPanel(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(Theme.PANEL_BACKGROUND);
        panel.addKeyListener(new MyKeys());
        panel.setFocusable(true);

        for (int row = 0; row < game.GRID_SIZE; row++) {
            for (int col = 0; col < game.GRID_SIZE; col++) {
                JLabel tile;
                if (game.grid[row][col] == game.EMPTY) {
                    tile = new JLabel("");
                    tile.setBackground(Theme.TILE_BACKGROUND_COLOR_MAP.get(game.EMPTY));
                } else {
                    tile = new JLabel("" + game.grid[row][col]);
                    tile.setBackground(Theme.TILE_BACKGROUND_COLOR_MAP.get(game.grid[row][col]));
                }
                tile.setForeground(Theme.TILE_FOREGROUND);
                tile.setHorizontalAlignment(JLabel.CENTER);
                tile.setVerticalAlignment(JLabel.CENTER);
                tile.setFont(Theme.TILE_FONT);
                tile.setOpaque(true);
                panel.add(tile);
            }
        }

        tiles = panel.getComponents();

        frame.setJMenuBar(createMenuBar());
        frame.getContentPane().add(BorderLayout.NORTH, scoreLabel);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        frame.getContentPane().setBackground(Theme.FRAME_BACKGROUND);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500, 150);
        frame.setSize(game.GRID_SIZE * Theme.TILE_SIZE + 30, game.GRID_SIZE * Theme.TILE_SIZE + 55);
        frame.setVisible(true);
        panel.requestFocus();
    }

    private void updateGrid() {
        for (int i = 0; i < tiles.length; i++) {
            JLabel tile = (JLabel) tiles[i];
            int row = i / game.GRID_SIZE;
            int col = i % game.GRID_SIZE;
            if (game.grid[row][col] == game.EMPTY) {
                tile.setText("");
                tile.setBackground(Theme.TILE_BACKGROUND_COLOR_MAP.get(game.EMPTY));
            } else {
                tile.setText("" + game.grid[row][col]);
                tile.setBackground(Theme.TILE_BACKGROUND_COLOR_MAP.get(game.grid[row][col]));
            }
        }
    }

    public void gameOver(String msg) {
        JLabel lbl = new JLabel(msg);
        lbl.setFont(new Font("Ink Free", Font.BOLD, 30));
        lbl.setForeground(Color.BLUE);

        panel.removeAll();
        panel.repaint();
        panel.setLayout(new BorderLayout());
        panel.add(BorderLayout.CENTER, lbl);
        panel.repaint();
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu setLimitMenu = new JMenu("Set Game Limit");

        JMenuItem $128 = new JMenuItem("128");
        $128.addActionListener(event -> game.setLimit(128));
        $128.setBackground(Theme.TILE_BACKGROUND_COLOR_MAP.get(128));
        setLimitMenu.add($128);

        JMenuItem $256 = new JMenuItem("256");
        $256.addActionListener(event -> game.setLimit(256));
        $256.setBackground(Theme.TILE_BACKGROUND_COLOR_MAP.get(256));
        setLimitMenu.add($256);

        JMenuItem $512 = new JMenuItem("512");
        $512.addActionListener(event -> game.setLimit(512));
        $512.setBackground(Theme.TILE_BACKGROUND_COLOR_MAP.get(512));
        setLimitMenu.add($512);

        JMenuItem $1024 = new JMenuItem("1024");
        $1024.addActionListener(event -> game.setLimit(1024));
        $1024.setBackground(Theme.TILE_BACKGROUND_COLOR_MAP.get(1024));
        setLimitMenu.add($1024);

        menuBar.add(setLimitMenu);
        return menuBar;
    }

    class MyKeys extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_UP -> slide(game.UP);
                case KeyEvent.VK_DOWN -> slide(game.DOWN);
                case KeyEvent.VK_LEFT -> slide(game.LEFT);
                case KeyEvent.VK_RIGHT -> slide(game.RIGHT);
            }
        }
    }

    // whenever the user presses any game control key, the grid is slided in that
    // direction, score is updated, a new tile is created and finally the grid gets
    // updated
    public void slide(int dir) {
        game.move(dir);
        scoreLabel.setText("Score : " + game.score);
        boolean flag = game.createNewSquare();
        updateGrid();
        if (game.gameFinished) {
            gameOver("Congratulations !!!\n You won !!!");
        } else if (!flag) {
            gameOver("Better luck, next time !!!");
        }
    }
}