import characters.Character;
import gui.DescktopGUI;
import gui.DesktopGui;


/**
 * Main class for run Application
 *
 * Created by sserdiuk on 7/3/17.
 */
public class MainRun {
    public static void main(String[] args) {
        Character character = new Character();
        Character enemy = new Character();

//        new DesktopGui(character, enemy).drawGui();
        new DescktopGUI().drawGUI();

//        CardLogic logic = new CardLogic();
//
//        logic.setMainCardsDeck();
//        logic.getCardsDeckInHand();
//        System.out.println("USER HAS NEXT CARDS: " + logic.showCardsInHands());
//
//        List<SimpleCard> cardsInHands = logic.showCardsInHands();
//
//        cardsInHands.get(0).getSuccessfulBonuses();
//        System.out.println("SUCCESSFUL BONUSES WILL BE : " + cardsInHands.get(0).getSuccessfulBonuses());
//
//        System.out.println("ARMOR BEFORE = " + character.getArmor());
//        character.addBonusFromCards(cardsInHands.get(0).getSuccessfulBonuses());
//        System.out.println("ARMOR AFTER = " + character.getArmor());
//        System.out.println("HEALTH AFTER = " + character.getHealth());
    }
}
