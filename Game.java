/**
 * This class is implemented by Amgad Elrashid Gurashi Eltayeb
 * The Game class represents the main game logic and state.
 */

public class Game {
    private Player yellow; // The yellow player
    private Player blue; // The blue player
    private int turn = 0; // The current turn number
    private Board board; // The game board

    /**
     * Initializes the game by creating player instances and game board.
     */
    private void init() {
        board = Board.getInstance();
        yellow = new Player(true);
        blue = new Player(false);
    }

    /**
     * Moves a player's piece from the current tile to the new tile.
     *
     * @param player      The player to move
     * @param currentTile The current tile of the player's piece.
     * @param newTile     The new tile where the player's piece will be moved.
     */
    public boolean isMoveValid(Player player, Tile currentTile, Tile newTile) {
        Piece playerPiece = currentTile.getPiece(); // store the source piece in the playerPiece variable
        if (player == getPlayerTurn() && playerPiece.canMove(currentTile, newTile)
                && player.isYellow() == playerPiece.isYellow()) { // checks if it's the player's turn & legal move and if the piece belong to them
            return true;
        }
        return false;
    }

    public void playerMove(Player player, Tile currentTile, Tile newTile) {
        if (isMoveValid(player, currentTile, newTile)) {
            newTile.setPiece(currentTile.getPiece());
            currentTile.setPiece(null);
        } else {
            System.out.println("Invalid move");
        }

    }

    

    /**
     * Starts the game by initializing the game state and starting the first turn.
     */
    public void startGame() {
        init();
        

        // implementation
    };

    /**
     * Handles the logic when the game is over.
     */
    public void gameOver() {
        // implementation
    };

    /**
     * Advances the game to the next turn, switching between yellow and blue
     * players.
     */
    public void nextTurn() {
        // Switch turns between yellow and blue players
        if (turn % 2 == 0) {
            yellow.setTurn(true);
            blue.setTurn(false);
            System.out.println("yellow player's turn");
            // Additional logic for yellow player's turn
        } else {
            blue.setTurn(true);
            yellow.setTurn(false);
            System.out.println("blue player's turn");
            // Additional logic for blue player's turn
        }

        turn++;
    }

    /**
     * Gets the current Player turn.
     *
     * @return The current Player turn.
     */
    public Player getPlayerTurn() {
        if (yellow.getTurn()) {
            return yellow;
        }
        return blue;
    }

    /**
     * Sets the blue player for the game.
     *
     * @param player The blue player to set.
     */
    public void setBluePlayer(Player player) {
        this.blue = player;
    }

    /**
     * Sets the yellow player for the game.
     *
     * @param player The yellow player to set.
     */
    public void setYellowPlayer(Player player) {
        this.yellow = player;
    }

    /**
     * Gets the blue player of the game.
     *
     * @return The blue player.
     */
    public Player getBluePlayer() {
        return blue;
    }

    /**
     * Gets the yellow player of the game.
     *
     * @return The yellow player.
     */
    public Player getYellowPlayer() {
        return yellow;
    }

}
