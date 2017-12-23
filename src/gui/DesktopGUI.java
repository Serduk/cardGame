package gui;


import configuration.NamingAndDescription;
import configuration.PathsAndRoutes;
import logic.CardLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class for describe main window,
 * and main game navigation
 * <p>
 * Created by sserdiuk on 7/3/17.
 */

public class DesktopGUI {
//    replace with choosing play with bot or with another user
    CardLogic logic = new CardLogic(true);
    private boolean isFirstGame = true;

    private JFrame frame;
    private JPanel gamePanel;
    private JPanel userCardDeckPanel;
    private JPanel enemyCardDeckPanel;
    private JPanel userDataPanel;
    private JPanel enemyDataPanel;
    private JPanel battleFieldPanel;
    private JPanel chatPanel;

    private ArrayList<JButton> userCardDeckGUI;
    private ArrayList<JButton> enemyCardDeckGUI;

    private JButton buttonNewGame;
    private JButton buttonRefreshGame;
    private JButton buttonScore;

    private BorderLayout layout;
    private FlowLayout flowLayout;

    public void drawGUI() {
        System.out.println("DRAW GUI");

        frame = new JFrame(NamingAndDescription.gameName);
        ImageIcon webIcon = new ImageIcon(PathsAndRoutes.iconIMG);

        buttonNewGame = new JButton(NamingAndDescription.newGame, webIcon);
        buttonNewGame.addActionListener(new NewGame());

        flowLayout = new FlowLayout();
        userCardDeckPanel = new JPanel(flowLayout);
        enemyCardDeckPanel = new JPanel(flowLayout);
        userDataPanel = new JPanel(flowLayout);
        enemyDataPanel = new JPanel(flowLayout);
        battleFieldPanel = new JPanel(flowLayout);

        layout = new BorderLayout();
        gamePanel = new JPanel(layout);

        battleFieldPanel.add(buttonNewGame);

        gamePanel.add(BorderLayout.SOUTH, userCardDeckPanel);
        gamePanel.add(BorderLayout.NORTH, enemyCardDeckPanel);
        gamePanel.add(BorderLayout.CENTER, battleFieldPanel);

        frame.add(gamePanel);

        frame.setIconImage(webIcon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(50, 50, 1500, 600);
        frame.setVisible(true);
    }

    /**
     * This method will get all user cards deck from CardLogic Method
     * and show cards img on GUI
     * <p>
     * All cards will be put in ArrayList.
     * All images (routes for cards img) will be taken from basic Card class
     * <p>
     * BEFORE USE THIS METHOD: YOU SHOULD USE METHOD setMainCardsDeck(), FOR SETUP MAIN CARD DECK;
     */
    private void displayUserCards() {


    }

    /**
     * This Method will show all enemy cards deck from CardLogic Method
     * All Cards will be shown with Card Sheet
     */
    private void displayEnemyCards() {

    }

    private void displayUserData() {

    }

    private void displayEnemyData() {

    }

    private void displayBattleField() {

    }

    public void chatWorker() {

    }

    /**
     * Played clicked card
     * This card should be:
     * 1. Removed from enemy or player deck
     * 2. Showed on "play field"
     * 3. Moved to trash after playing
     */
    public void playClickedCard(int button) {

    }

    public void repaintCards() {

    }

    public void repaintBattleField() {

    }

    /**
    * UI should be unClickable
     * While next user complete his turn
    * */
    public void lockUI() {

    }



    /**
     * Anonymous class for start game
     * Change screen on Table with Cards
     * Add cards for each player
     * <p>
     */
    private class NewGame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("new game");

        }
    }
}
