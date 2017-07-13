import cards.SimpleCard;
import cards.cardsList.TestCardOne;
import cards.cardsList.earthCards.EarthCard01;
import cards.cardsList.fireCards.FireCard01;
import cards.cardsList.natureCards.NatureCard01;
import cards.cardsList.waterCards.WaterCard01;

import java.util.ArrayList;
import java.util.List;


/**
 * Main class for run Application
 *
 * Created by sserdiuk on 7/3/17.
 */
public class MainRun {
    public static void main(String[] args) {
//        new DesktopGui().drawGui();
        SimpleCard card = new TestCardOne();
        EarthCard01 earthCard1 = new EarthCard01();

        List<SimpleCard> cardCollection = new ArrayList<>();
        cardCollection.add(new EarthCard01());
        cardCollection.add(new FireCard01());
        cardCollection.add(new WaterCard01());
        cardCollection.add(new NatureCard01());




        cardCollection.get(0).getSuccessfulBonuses();

//        card.getSuccessfulBonuses();
        earthCard1.getSuccessfulBonuses();
        System.out.println(cardCollection.get(0).getSuccessfulBonuses());
        System.out.println("SUCCESSFUL BONUSES WILL BE" + earthCard1.getSuccessfulBonuses());
    }
}
