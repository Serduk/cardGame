import cards.SimpleCard;
import cards.cardsList.TestCardOne;
import cards.cardsList.earthCards.EarthCard1;
import cards.enumsCards.BonusesInCards;
import gui.DesktopGui;

import java.util.HashMap;

/**
 * Main class for run Application
 *
 * Created by sserdiuk on 7/3/17.
 */
public class MainRun {
    public static void main(String[] args) {
//        new DesktopGui().drawGui();
        SimpleCard card = new TestCardOne();
        EarthCard1 earthCard1 = new EarthCard1();

//        card.getSuccessfulBonuses();
        earthCard1.getSuccessfulBonuses();
    }
}
