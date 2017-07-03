import cards.SimpleCard;
import cards.cardsList.TestCardOne;
import gui.DesktopGui;

/**
 * Main class for run Application
 *
 * Created by sserdiuk on 7/3/17.
 */
public class MainRun {
    public static void main(String[] args) {
        new DesktopGui().drawGui();
        SimpleCard card = new TestCardOne();
        System.out.println(card);
        System.out.println((Math.random() * 100));
    }
}
