package gui;

import configuration.NamingAndDiscription;
import configuration.PathsAndRoutes;

import javax.swing.*;

/**
 * This class for describe main window,
 * and main game navigation
 *
 * TODO: fixIconImg
 *
 * Created by sserdiuk on 7/3/17.
 */
public class DesktopGui {
    JFrame frame;
    JPanel gamePanel;
    JPanel chatPanel;

    public void drawGui() {
        System.out.println(NamingAndDiscription.gameName + " Started");
        frame = new JFrame(NamingAndDiscription.gameName);
        ImageIcon webIcon = new ImageIcon(PathsAndRoutes.iconIMG);

        frame.setIconImage(webIcon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(50, 50, 300, 300);
        frame.setVisible(true);

    }
}
