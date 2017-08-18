package gui;

import characters.SimpleCharacters;
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
 *
 * Created by sserdiuk on 7/3/17.
 */
public class DesktopGui extends CardLogic {
    private SimpleCharacters character1;
    private SimpleCharacters character2;

    /**
     * In this constructor we send 2 characters and redraw them on GUI
     * @param character1 => receive main character (your character)
     * @param character2 => receive EnemyCharacter
     *
     * With this classes will work main card logic.
     *                   set them parameters, health, etc
     * */
    public DesktopGui (SimpleCharacters character1, SimpleCharacters character2) {
        this.character1 = character1;
        this.character2 = character2;
    }

    private JFrame frame;
    private JPanel gamePanel;
    private JPanel userCardDeckPanel;
    JPanel chatPanel;
    JLabel startGame;

    ArrayList<JButton> userCardDeck;

    private JButton buttonStartGame;
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

        buttonStartGame = new JButton(webIcon);
        buttonStartGame.addActionListener(new clickOnLabel());

//        button2 = new JButton("button2", icon2);
        button2 = new JButton(icon2);
        button2.setSize(25, 25);
        button2.addActionListener(new clickOnLabel());
//        button2.setIcon(icon2);



        flowLayout = new FlowLayout();
        userCardDeckPanel = new JPanel(flowLayout);

        layout = new BorderLayout();
        gamePanel = new JPanel(layout);

        userCardDeckPanel.add(buttonStartGame);
        userCardDeckPanel.add(button2);

//        gamePanel.add(BorderLayout.WEST, buttonStartGame);
//        gamePanel.add(BorderLayout.EAST, button2);
        gamePanel.add(BorderLayout.SOUTH, userCardDeckPanel);

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
     *
     * TODO: Complete Method
     * */
    private class newGame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
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
     *
     * All cards will be put in ArrayList.
     * All images (routes for cards img) will be taken from basic Card class
     *
     * TODO: Complete method
     *
     * */
    private void showUserCardsDeck() {

    }

    /**
     * This Method will show all enemy cards deck from CardLogic Method
     * All Cards will be shown with Card Sheet
     *
     * TODO: Complete Method
     *
     * */
    private void showEnemyCardDeck() {

    }
}
