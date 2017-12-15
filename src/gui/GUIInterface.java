package gui;

/**
 * Interface should describe methods for GUI drawing on all OS types
 *
 * Should be implemented on mobile and desktop
 *
 * <p>
 * Created by sserdiuk on 12/15/17.
 */

public interface GUIInterface {
    void drawGui();

    /**
     * This method will get all user cards deck from CardLogic Method
     * and show cards img on GUI
     * <p>
     * All cards will be put in ArrayList.
     * All images (routes for cards img) will be taken from basic Card class
     * <p>
     * BEFORE USE THIS METHOD: YOU SHOULD USE METHOD setMainCardsDeck(), FOR SETUP MAIN CARD DECK;
     */
    void showUserCardsDeck();

    /**
     * This Method will show all enemy cards deck from CardLogic Method
     * All Cards will be shown with Card Sheet
     */
    void showEnemyCardsDeck();

    /**
     * This method will clear all user card deck from Desk
     * clear ALL user cardsDeck
     */
    void clearUserCardsDeckGUI();

    /**
     * This method will clear all enemy card deck from Desk
     * clear ALL user cardsDeck
     */
    void clearEnemyCardsDeckGUI();

    /**
     * Anonymous class for start game
     * Change screen on Table with Cards
     * Add cards for each player
     * <p>
     * TODO: Fix problem with new game cards redisplayng
     */
    void newGame();

    /**
     * Anonymous class for help repaint all actions on card desk
     * After some actions
     */
    void repaintDesk();

    /**
     * Played clicked card
     * This card should be:
     *            1. Removed from enemy or player deck
     *            2. Showed on "play field"
     *            3. Moved to trash after playing
     * */
    void playClickedButton(int button);

    /**
     * Method add to user card list all new cards from userCardDeck
     */
    void drawCardDeckForUser();

    /**
     * Method add to enemy card list all new cards from enemyCardDeck
     */
    void drawCardDeckForEnemy();
}
