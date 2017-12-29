package gui;


import configuration.NamingAndDescription;
import configuration.PathsAndRoutes;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import logic.CardLogic;

/**
 * This class for describe main window,
 * and main game navigation
 * <p>
 * Created by sserdiuk on 7/3/17.
 */

public class DesktopGUI {
    //    replace with choosing play with bot or with another user
    CardLogic cardLogic = new CardLogic(true);
    private boolean isFirstGame = true;

    private JFrame frame;
    private JPanel gamePanel;
    private JPanel userCardDeckPanel;
    private JPanel enemyCardDeckPanel;
    private JPanel userDataPanel;
    private JPanel enemyDataPanel;
    private JPanel battleFieldPanel;
    private JPanel chatPanel;

    private List<JButton> userCardDeckGUI;
    private List<JButton> enemyCardDeckGUI;

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
     * <p>
     * TODO: we should move IF and All FOR in separate method. I think, we should use some ENUM for switching, were we should clear buttons
     */
    private void displayUserCards() {
        userCardDeckGUI = new ArrayList<>();
        if (!isFirstGame) {
//            TODO: Replace iterator
            for (int i = 0; i < cardLogic.getCardsGUI().size(); i++) {
                if (userCardDeckPanel == null) {
                    break;
                }
                userCardDeckPanel.remove(0);
            }
        }

        for (int i = 0; i < cardLogic.getCardsGUI().size(); i++) {
            JButton jButton = new JButton("userButtonName" + i);
            jButton.setHorizontalTextPosition(AbstractButton.CENTER);
            jButton.setVerticalTextPosition(AbstractButton.BOTTOM);
            System.out.println("cardLogic.getCardsGUI().get(i) " + cardLogic.getCardsGUI().get(i));
            jButton.setIcon(new ImageIcon((String) cardLogic.getCardsGUI().get(i)));
            jButton.addActionListener(new ClickedCardListener(i));
            userCardDeckGUI.add(jButton);
            userCardDeckPanel.add(userCardDeckGUI.get(i));
        }
//        repaintCards();
    }

    /**
     * This Method will show all enemy cards deck from CardLogic Method
     * All Cards will be shown with Card Sheet
     */
    private void displayEnemyCards() {
        enemyCardDeckGUI = new ArrayList<>();
        if (!isFirstGame) {
            for (int i = 0; i < cardLogic.getCardsGUI().size(); i++) {
                if (enemyCardDeckPanel == null) {
                    break;
                }
                enemyCardDeckPanel.remove(0);
            }
        }

        for (int i = 0; i < cardLogic.getEnemyCardsGUI().size(); i++) {
            JButton jButton = new JButton("enemyButtonName" + i);
            jButton.setHorizontalTextPosition(AbstractButton.CENTER);
            jButton.setVerticalTextPosition(AbstractButton.BOTTOM);
            jButton.setIcon(new ImageIcon((String) cardLogic.getEnemyCardsGUI().get(i)));
            jButton.addActionListener(new ClickedCardListener(i));
            enemyCardDeckGUI.add(jButton);
            enemyCardDeckPanel.add(enemyCardDeckGUI.get(i));
        }
//        repaintCards();
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
        cardLogic.playCard(button);
        displayPlayedCardOnBattleField();
        displayUserCards();
        displayEnemyCards();
        repaintCards();
    }

    private void displayPlayedCardOnBattleField() {
        System.out.println("Played card displayed on battlefield");

    }

    private void repaintCards() {
        userCardDeckPanel.revalidate();
        enemyCardDeckPanel.revalidate();
        userDataPanel.revalidate();
        enemyDataPanel.revalidate();
        battleFieldPanel.revalidate();

        userCardDeckPanel.repaint();
        enemyCardDeckPanel.repaint();
        userDataPanel.repaint();
        enemyDataPanel.repaint();
        battleFieldPanel.repaint();

//        frame.revalidate();
//        frame.repaint();
//        gamePanel.revalidate();
//        gamePanel.repaint();
    }

    public void repaintBattleField() {

    }

    /**
     * UI should be unClickable
     * While next user complete his turn
     */
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
            cardLogic.newGame();
            displayUserCards();
            displayEnemyCards();
            repaintCards();
            isFirstGame = false;
            cardLogic.setIsFirstGame(isFirstGame);
        }
    }

    private class ClickedCardListener implements ActionListener {
        private int clickedButton;

        private ClickedCardListener(int clickedButton) {
            this.clickedButton = clickedButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clicked Button" + clickedButton);
            playClickedCard(clickedButton);
        }
    }
}
