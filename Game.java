/**
 * The Game class represents the main game logic and state.
 * This class is implemented by Amgad Elrashid Gurashi Eltayeb
 */

public class Game {
    private Player black; // The black player
    private Player white; // The white player
    private int turn = 0; // The current turn number
    private Board board; // The game board


    /**
     * Initializes the game by creating player instances and game board.
     */
    private void init(){
        board = Board.getInstance();
        black = new Player();
        white = new Player();
    }

    /**
     * Moves a player's piece from the current tile to the new tile.
     *
     * @param currentTile The current tile of the player's piece.
     * @param newTile     The new tile where the player's piece will be moved.
     */
    private void move(Tile currenTile, Tile newTile){
        // implementation
    }


    /**
     * Starts the game by initializing the game state and starting the first turn.
     */
    public void startGame(){
        init();

        //implementation
    };

    /**
     * Handles the logic when the game is over.
     */
    public void gameOver(){
        // implementation
    };


    /**
     * Advances the game to the next turn, switching between black and white players.
     */
    public void nextTurn() {
        // Switch turns between black and white players
        if (turn % 2 == 0) {
            System.out.println("Black player's turn");
            // Additional logic for black player's turn
        } else {
            System.out.println("White player's turn");
            // Additional logic for white player's turn
        }

        turn++;
    }

    /**
     * Gets the current turn number.
     *
     * @return The current turn number.
     */
    public int getTurn(){
        return turn;
    }

     /**
     * Sets the white player for the game.
     *
     * @param player The white player to set.
     */
    public void setWhitePlayer(Player player){
        this.white = player;
    }

    /**
     * Sets the black player for the game.
     *
     * @param player The black player to set.
     */
    public void setBlackPlayer(Player player){
        this.black = player;
    }

    /**
     * Gets the white player of the game.
     *
     * @return The white player.
     */
    public Player getWhitePlayer(){
        return white;
    }

    /**
     * Gets the black player of the game.
     *
     * @return The black player.
     */
    public Player getBlackPlayer(){
        return black;
    }

}
