# 2048 in Java

Get ready to challenge your strategic thinking and number skills with 2048! This addictive and engaging puzzle game puts your mind to the test as you slide and merge numbered tiles to reach the elusive 2048 tile.

In 2048, your goal is simple: combine tiles of the same number to create a new tile with double the value of combining tiles. Starting with two tiles valued at 2, you must strategically move the tiles across the grid, merging them as you go. Each move shifts all the tiles in one direction, and a new tile appear randomly on the board.

Plan your moves carefully to create larger and larger numbers. Merge two '2' tiles to form a '4,' combine two '4' tiles to make an '8,' and keep going until you reach the ultimate goal of the '2048' tile. But beware, as the board fills up and options become limited, each move becomes critical.

With its simple yet challenging gameplay, 2048 offers endless hours of fun and excitement. Sharpen your logical thinking, improve your number sense, and strive for the highest score possible. Can you conquer the 2048 tile and become the ultimate puzzle master?

## Features

- Addictive gameplay that is easy to learn, yet hard to master
- You can play either the console version or the GUI version
- Slide tiles in four directions: LEFT (0), RIGHT (1), UP (2), DOWN (3)
- Merge tiles with the same number to create higher-valued tiles
- Strive to reach the coveted '2048' tile and beyond
- Track your progress with a high score system
- Enjoy sleek and minimalist graphics for a clean and immersive experience
- Challenge your mind and embark on a journey of number mastery with 2048. Prepare to be captivated by this addictive puzzle game and see how far you can go!

### Files in the project

- `GameGrid.java`
    - contains most of the game code
    - has two constructors: 
        - the default one creates a 4*4 grid
        - you can pass your own desired size in the constructor
    - has the `startConsole()`, which is the entry point of the program
      this sets up the grid and calls the `playConsole()` mehtod
    - user choice is collected using `takeInput()`
    - based on the user choice, the `move()` calls the coressponding slide method
    - `createNewSquare()` creates a new tile randomly at some empty location and returns a boolean
      depending on whether the operation was successfull or not
    
- `GameFrame.java`
    - contains the GUI version of the game
    - create an instance of this class and call the `start()` on it
      this will set up the grid and the GUI
    - user inputs are listened in the form of key press events by using the MyKeys inner class
    - if the game reaches the end stage (having a tile with value `ENDING_TILE`), or if no empty tiles are left,
      the `gameOver()` is called. It updates the panel and game ends.

- `Main.java`
    - demonstrates how a client can use the `GameGrid` and `GameFrame` to play the game 

- `GameTestCases.java`
    - contains some test cases for the four slide methods { `slideLeft()`, `slideRight()`, `slideUp()`, `slideDown()`}

- `Theme.java`
    - contains static final variables like color, font etc. used for the GUI of the game.

### Libraries

For the test cases, I have used two jar files, included inside the `lib` directory

## Playing the game:
- The code was written using VS Code as IDE. If you are using this IDE, then - 
    - click on the `Run & Debug` option and then the coressponding button.

## Future Modifications

- Add a menu item on the menu bar that allows user to select the size of the grid.

- As of now, the user can select the ending tile only from those available in the menu. Allow user to set a value of their choice.

- Allow users to change the base value of the grid. For now, it is set to 2.