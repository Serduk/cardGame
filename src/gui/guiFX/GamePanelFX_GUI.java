package gui.guiFX;

import gui.GUIInterface;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Alternative example for app GUI,
 * should be used JavaFX
 *
 * Priority:
 * https://docs.oracle.com/javafx/2/get_started/fxml_tutorial.htm
 * https://docs.oracle.com/javase/8/javafx/api/toc.htm
 * https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
 *
 * http://www.java2s.com/Code/Java/JavaFX/SetButtonGraphic.htm
 * http://zoranpavlovic.blogspot.com/2012/06/javafx-2-add-image-to-button.html
 *
 *
 * Created by sserdiuk on 12/18/17.
 */
public class GamePanelFX_GUI extends Application implements GUIInterface {

    public Label helloWorld;

    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Hello World");
        System.out.println("Hello World!");
    }

    public void playClickedButton(ActionEvent actionEvent) {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("guiTestExample/guiEx.fxml"));

        Scene scene = new Scene(root, 1500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    /***********************************************************/

    @Override
    public void drawGui() {

    }

    @Override
    public void showUserCardsDeck() {

    }

    @Override
    public void showEnemyCardsDeck() {

    }

    @Override
    public void clearUserCardsDeckGUI() {

    }

    @Override
    public void clearEnemyCardsDeckGUI() {

    }

    @Override
    public void newGame() {

    }

    @Override
    public void repaintDesk() {

    }

    @Override
    public void playClickedButton(int button) {

    }

    @Override
    public void drawCardDeckForUser() {

    }

    @Override
    public void drawCardDeckForEnemy() {

    }



    /**
     * Example for app starting
     * */
//    public static void main(String[] args) {
//        launch(args);
//    }
}