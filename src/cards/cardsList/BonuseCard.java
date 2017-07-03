package cards.cardsList;

import cards.CardsBonuses;
import cards.SimpleCard;

/**
 * from this class will be extended all cards with bonus
 * TODO: Add parser for bonuses, and set them to user status
 *
 * Created by serdyuk on 7/3/17.
 */
public class BonuseCard extends SimpleCard implements CardsBonuses {
    protected int chancePercentage = 100;

    /*
    * Method overrated. and chance for bonuses.
    * They have some chance to not be added.
    * User mast change chancePercentage for set another chance
    * */
    @Override
    public void addBonus(String[] bonusType) {
        if (chancePercentage < 100) {
            if ((Math.random() * 100) <= chancePercentage) {
                System.out.println("Add bonus");
            } else {
                System.out.println("Sorry, bonus not added");
            }
        } else {
            System.out.println("Add bonus");
        }
    }
}
