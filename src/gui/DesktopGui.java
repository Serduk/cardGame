package gui;

import characters.Character;
import configuration.NamingAndDescription;
import configuration.PathsAndRoutes;
import logic.CardLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class for describe main window,
 * and main game navigation
 * <p>
 * Created by sserdiuk on 7/3/17.
 */
@Deprecated
public class DesktopGui extends CardLogic implements GUIInterface {
    private Character character1;
    private Character character2;

    private int startNewGameCount = 0;
    private String userButtonName = "userButtonName";

    /**
     * In this constructor we send 2 characters and redraw them on GUI
     *
     * @param character1 => receive main character (your character)
     * @param character2 => receive EnemyCharacter
     *                   <p>
     *                   With this classes will work main card logic.
     *                   set them parameters, health, etc
     */
    public DesktopGui() {
        super(true);
    }

    private JFrame frame;

    private JPanel gamePanel;
    private JPanel userCardDeckPanel;
    private JPanel enemyCardDeckPanel;
    private JPanel userDataPanel;
    private JPanel enemyDataPanel;
    private JPanel battleFieldPanel;
    private JPanel chatPanel;

// WHEN USER PLAY CARD WE GOT TO MANY PROBLEMS
    private ArrayList<JButton> userCardDeckGUI;
    private ArrayList<JButton> enemyCardDeckGUI;

    private HashMap<Integer, JButton> userCardDeckGUI_;
    private HashMap<Integer, JButton> enemyCardDeckGUI_;

    private JButton buttonStartGame;
    private JButton buttonRefresh;
    private JButton buttonScore;
    private JButton button2;

    private BorderLayout layout;
    private FlowLayout flowLayout;

    public void drawGui() {
        System.out.println(NamingAndDescription.gameName + " Started");
        frame = new JFrame(NamingAndDescription.gameName);
        ImageIcon webIcon = new ImageIcon(PathsAndRoutes.iconIMG);
        ImageIcon icon2 = new ImageIcon(PathsAndRoutes.iconIMG);

//        Example for Using Scale for images
//        ImageIcon iconScalable = new ImageIcon(new ImageIcon(PathsAndRoutes.iconIMG).getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT));
//        JButton buttonScalable = new JButton(iconScalable);

        buttonStartGame = new JButton("new Game", webIcon);
        buttonStartGame.addActionListener(new NewGame());

//        button2 = new JButton(icon2);
//        button2.setSize(25, 25);
//        button2.addActionListener(new clickOnLabel());

        flowLayout = new FlowLayout();
        userCardDeckPanel = new JPanel(flowLayout);
        enemyCardDeckPanel = new JPanel(flowLayout);
        userDataPanel = new JPanel(flowLayout);
        enemyDataPanel = new JPanel(flowLayout);
        battleFieldPanel = new JPanel(flowLayout);

        layout = new BorderLayout();
        gamePanel = new JPanel(layout);

        battleFieldPanel.add(buttonStartGame);

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
     * Anonymous class for start game
     * Change screen on Table with Cards
     * Add cards for each player
     * <p>
     */
    private class NewGame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            newGame();
        }
    }


    @Override
    public void newGame() {
        if (startNewGameCount > 0) {
            System.out.println("It's not new game, cards will be redrawed");
            clearUserCardsDeckGUI();
            clearEnemyCardsDeckGUI();
            clearCurrentGameData();
            repaintDesk();
        }
        clearMainCardsDeck();
        clearUserCardDeck();
        clearEnemyCardDeck();
        
        setMainCardsDeck();
        showEnemyCardsDeck();
        showUserCardsDeck();
        drawCardDeckForUser();
        drawCardDeckForEnemy();

        startNewGameCount++;
    }

    private class clickOnLabel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clicked!");
        }
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
    public void showUserCardsDeck() {
        clearMainCardsDeck();
        setMainCardsDeck();
        getCardsDeckInHand();
//        userCardDeckGUI = new ArrayList<JButton>();
        userCardDeckGUI_ = new HashMap<>();
        for (int i = 0; i < cardsDeckInUserHandCount; i++) {
            JButton jButton = new JButton(userButtonName + i);
            jButton.setHorizontalTextPosition(AbstractButton.CENTER);
            jButton.setVerticalTextPosition(AbstractButton.BOTTOM);
            jButton.setIcon(new ImageIcon(showCardsInHands().get(i).pathToCardIMG));
            jButton.addActionListener(new PlayClickedButton(i));
            userCardDeckGUI_.put(i, jButton);
//            userCardDeckGUI.add(jButton);
        }
//        System.out.println("DESKTOP GUI: USER HAS " + userCardDeckGUI.size() + " Card IMAGES");
        System.out.println("DESKTOP GUI: USER HAS " + userCardDeckGUI_.size() + " Card IMAGES");
    }

    /**
     * This method will clear all user card deck from Desk
     * clear ALL user cardsDeck
     */
    public void clearUserCardsDeckGUI() {
//        if (userCardDeckGUI.isEmpty()) {
//            System.out.println("No cards in deck!");
//        } else {
//            userCardDeckGUI.clear();
//            userCardDeckPanel.updateUI();
//        }
        if (userCardDeckGUI_.isEmpty()) {
            System.out.println("No cards in deck!");
        } else {
            userCardDeckGUI_.clear();
            userCardDeckPanel.updateUI();
        }
    }

    /**
     * This Method will show all enemy cards deck from CardLogic Method
     * All Cards will be shown with Card Sheet
     */
    public void showEnemyCardsDeck() {
//        enemyCardDeckGUI = new ArrayList<JButton>();
        enemyCardDeckGUI_ = new HashMap<>();
        for (int i = 0; i < cardsDeckInUserHandCount; i++) {
            JButton jButton = new JButton(new ImageIcon(PathsAndRoutes.zeroCard));
//            enemyCardDeckGUI.add(jButton);
            enemyCardDeckGUI_.put(i, jButton);
        }
    }

    /**
     * This method will clear all user card deck from Desk
     * clear ALL user cardsDeck
     */
    public void clearEnemyCardsDeckGUI() {
//        if (enemyCardDeckGUI.isEmpty()) {
//            System.out.println("No cards in deck!");
//        } else {
//            enemyCardDeckGUI.clear();
//            enemyCardDeckPanel.updateUI();
//        }
        if (enemyCardDeckGUI_.isEmpty()) {
            System.out.println("No cards in deck!");
        } else {
            enemyCardDeckGUI_.clear();
            userCardDeckPanel.updateUI();
        }
    }

    /**
     * Anonymous class for help repaint all actions on card desk
     * After some actions
     */
    private class Repaint implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            repaintDesk();
        }
    }

    @Override
    public void repaintDesk() {
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

    private class PlayClickedButton implements ActionListener {
        protected PlayClickedButton(int clickedButtonNum) {
            this.clickedButtonNum = clickedButtonNum;
        }

        int clickedButtonNum;

        @Override
        public void actionPerformed(ActionEvent e) {
            playClickedButton(clickedButtonNum);
        }
    }

    @Override
    public void playClickedButton(int clickedButtonNum) {
        System.out.println("BUTTON NUMBER IS: " + clickedButtonNum);
//        userCardDeckGUI.remove(clickedButtonNum);
        userCardDeckGUI_.remove(clickedButtonNum);
        userCardDeckPanel.remove(clickedButtonNum);
        userCardDeckPanel.revalidate();
        userCardDeckPanel.repaint();
//        System.out.println("USER CARD SIZE = " + userCardDeckGUI.size());
        System.out.println("USER CARD SIZE = " + userCardDeckGUI_.size());
    }

    /**
     * Method add to user card list all new cards from userCardDeck
     */
    public void drawCardDeckForUser() {
//        for (JButton anUserCardDeckGUI : userCardDeckGUI) {
//            userCardDeckPanel.add(anUserCardDeckGUI);
//        }
//        userCardDeckPanel.revalidate();
//        userCardDeckPanel.repaint();
        for (int i = 0; i < userCardDeckGUI_.size(); i++) {
            userCardDeckPanel.add(userCardDeckGUI_.get(i));
        }
        userCardDeckPanel.revalidate();
        userCardDeckPanel.repaint();
    }

    /**
     * Method add to enemy card list all new cards from enemyCardDeck
     */
    public void drawCardDeckForEnemy() {
//        for (JButton anUserCardDeckGUI : enemyCardDeckGUI) {
//            enemyCardDeckPanel.add(anUserCardDeckGUI);
//        }
//        enemyCardDeckPanel.revalidate();
//        enemyCardDeckPanel.repaint();

        for (int i = 0; i < enemyCardDeckGUI_.size(); i++) {
            enemyCardDeckPanel.add(enemyCardDeckGUI_.get(i));
        }
        enemyCardDeckPanel.revalidate();
        enemyCardDeckPanel.repaint();
    }

    public void clearCurrentGameData() {
        userCardDeckPanel.removeAll();
        enemyCardDeckPanel.removeAll();
        userDataPanel.removeAll();
        enemyDataPanel.removeAll();
//        battleFieldPanel.removeAll();
    }

//    TODO: add method to interface
    public void repaintCart(int repaingCard) {
        replaceCardInHandsFromMainDeck(repaingCard);

    }
}
