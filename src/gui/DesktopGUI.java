package gui;


import characters.CharacterAttributes;
import configuration.NamingAndDescription;
import configuration.PathsAndRoutes;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private boolean isUserTurn;

    private JFrame frame;
    private JPanel gamePanel;
    private JPanel userCardDeckPanel;
    private JPanel enemyCardDeckPanel;
    private JPanel battleFieldPanel;
    private JPanel chatPanel;

    private JPanel userDataPanel;
    private JPanel userBuffsAndDebuffsPanel;
    private JPanel userResourcesPanel;

    private JPanel enemyDataPanel;
    private JPanel enemyBuffsAndDebuffsPanel;
    private JPanel enemyResourcesPanel;

    private List<JButton> userCardDeckGUI;
    private List<JButton> enemyCardDeckGUI;
    private List<JButton> userCharacterParamsDataGUI;
    private List<JButton> enemyCharacterParamsDataGUI;

    private JButton buttonNewGame;
    private JButton buttonRefreshGame;
    private JButton buttonScore;

    private BorderLayout borderLayout;
    private FlowLayout flowLayout;

    public void drawGUI() {
        System.out.println("DRAW GUI");

        frame = new JFrame(NamingAndDescription.gameName);
        ImageIcon webIcon = new ImageIcon(PathsAndRoutes.iconIMG);

        buttonNewGame = new JButton(NamingAndDescription.newGame, webIcon);
        buttonNewGame.addActionListener(new NewGame());

        flowLayout = new FlowLayout();
        borderLayout = new BorderLayout();

        userCardDeckPanel = new JPanel(flowLayout);
        enemyCardDeckPanel = new JPanel(flowLayout);
        battleFieldPanel = new JPanel(flowLayout);

        userDataPanel = new JPanel(flowLayout);
        userBuffsAndDebuffsPanel = new JPanel(flowLayout);
        userResourcesPanel = new JPanel(flowLayout);

        userDataPanel.add(BorderLayout.NORTH, userBuffsAndDebuffsPanel);
        userDataPanel.add(BorderLayout.SOUTH, userResourcesPanel);


        enemyDataPanel = new JPanel(flowLayout);
        enemyBuffsAndDebuffsPanel = new JPanel(flowLayout);
        enemyResourcesPanel = new JPanel(flowLayout);

        enemyDataPanel.add(BorderLayout.NORTH, enemyBuffsAndDebuffsPanel);
        enemyDataPanel.add(BorderLayout.SOUTH, enemyResourcesPanel);


        gamePanel = new JPanel(borderLayout);

        battleFieldPanel.add(buttonNewGame);

        gamePanel.add(BorderLayout.SOUTH, userCardDeckPanel);
        gamePanel.add(BorderLayout.NORTH, enemyCardDeckPanel);
        gamePanel.add(BorderLayout.CENTER, battleFieldPanel);
        gamePanel.add(BorderLayout.WEST, userDataPanel);
        gamePanel.add(BorderLayout.EAST, enemyDataPanel);

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

    /**
     * Mehtod get all actual data about user character in Card logic
     * */
    private void displayUserData() {
//        TODO ADD VIEW FOR ALL ELEMENTS FROM HASHMAP
//        TODO: MOVE STRINGS AND ALL CONDITIONS TO NEW METHOD. AND USE THIS METHOD HERE
        Map<CharacterAttributes, Integer> userData = cardLogic.getCharacterData();
        userCharacterParamsDataGUI = new ArrayList<>();

        String pathToFreeze;
        String pathToHealth = "";
        String pathToPoisoned = "";
        String pathToReflection = "";

        if (userData.get(CharacterAttributes.FREEZED_ROUNDS) > 0) {
            pathToFreeze = PathsAndRoutes.pathToIsFreezedActive;
        } else {
            pathToFreeze = PathsAndRoutes.pathToIsFreezedInActive;
        }

        if (userData.get(CharacterAttributes.POISONED_ROUNDS) > 0) {
            pathToPoisoned = PathsAndRoutes.pathToIsPoisonedActive;
        } else {
            pathToPoisoned = PathsAndRoutes.pathToIsPoisonedInActive;
        }

        if (userData.get(CharacterAttributes.REGENERATION_ROUNDS) > 0) {
            pathToHealth = PathsAndRoutes.pathToHealthRestoreActive;
        } else {
            pathToHealth = PathsAndRoutes.pathToHealthRestoreInActive;
        }

        if (userData.get(CharacterAttributes.REFLECTION_ROUNDS) > 0) {
            pathToReflection = PathsAndRoutes.pathToReflectActive;
        } else {
            pathToReflection = PathsAndRoutes.pathToReflectInActive;
        }

        JButton freeze = new JButton("freeze");
        freeze.setHorizontalTextPosition(AbstractButton.CENTER);
        freeze.setVerticalTextPosition(AbstractButton.BOTTOM);
        freeze.setIcon(new ImageIcon(pathToFreeze));
//        freeze.setEnabled(false);
        userBuffsAndDebuffsPanel.add(freeze);

        JButton reflect = new JButton();
        JButton restoreHealth = new JButton();
        JButton poisoned = new JButton();

    }

    /**
     * Method Get all actual data about Enemy character in card logic
     * */
    private void displayEnemyData() {
//        TODO: ADD VIEW FOR ALL ELEMENTS FROM HASHMAP
//        TODO: MOVE STRINGS AND ALL CONDITIONS TO NEW METHOD. AND USE THIS METHOD HERE
        Map<CharacterAttributes, Integer> userData = cardLogic.getEnemyCharacterData();
        enemyCharacterParamsDataGUI = new ArrayList<>();


        String pathToFreeze;
        String pathToHealth = "";
        String pathToPoisoned = "";
        String pathToReflection = "";

        if (userData.get(CharacterAttributes.FREEZED_ROUNDS) > 0) {
            pathToFreeze = PathsAndRoutes.pathToIsFreezedActive;
        } else {
            pathToFreeze = PathsAndRoutes.pathToIsFreezedInActive;
        }

        if (userData.get(CharacterAttributes.POISONED_ROUNDS) > 0) {
            pathToPoisoned = PathsAndRoutes.pathToIsPoisonedActive;
        } else {
            pathToPoisoned = PathsAndRoutes.pathToIsPoisonedInActive;
        }

        if (userData.get(CharacterAttributes.REGENERATION_ROUNDS) > 0) {
            pathToHealth = PathsAndRoutes.pathToHealthRestoreActive;
        } else {
            pathToHealth = PathsAndRoutes.pathToHealthRestoreInActive;
        }

        if (userData.get(CharacterAttributes.REFLECTION_ROUNDS) > 0) {
            pathToReflection = PathsAndRoutes.pathToReflectActive;
        } else {
            pathToReflection = PathsAndRoutes.pathToReflectInActive;
        }

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

            displayUserData();
            displayEnemyData();

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
