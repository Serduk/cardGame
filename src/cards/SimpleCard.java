package cards;

import cards.enumsCards.CardsType;
import cards.enumsCards.ResourceTypes;

/**
 * In this class we describe basic properties for All cards
 *
 * Created by sserdiuk on 7/3/17.
 */
public class SimpleCard implements AggressiveCardsType, BonusCardsType, DefenseCardsType{
    protected String pathToCardIMG = "";

    protected String resourceTypeNeed = resourceTypeDetector(ResourceTypes.UNDEFINED);
    protected int resourceCountNeed;

//    describe type of card: aggressive, defense, bonus, etc
    protected String cardType = cardTypeDetector(CardsType.UNDEFINED);

    protected String resourceTypeDetector(ResourceTypes resourceTypes) {
        String resource;

        switch (resourceTypes) {
            case ICE:
                resource = "ice";
                break;
            case DIRT:
                resource = "dirt";
                break;
            case FIRE:
                resource = "fire";
                break;
            case WATER:
                resource = "water";
                break;
            case UNDEFINED:
            default:
                resource = "undefined";
                break;
        }
        return resource;
    }

    protected String cardTypeDetector(CardsType cardsType) {
        String type;

        switch (cardsType) {
            case BONUS:
                type = "bonus";
                break;
            case DEFENSE:
                type = "defense";
                break;
            case AGGRESSIVE:
                type = "aggressive";
                break;
            case UNDEFINED:
            default:
                type = "undefined";
                break;
        }
        return type;
    }

    /*
    * Implemented from AggressiveCardsType
    * */
    protected int damage = 0;

    @Override
    public int cardDamage() {
        return damage;
    }

    /*
    * Implemented from BonusCardsType
    * */
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

    /*
    * Implemented from DefenseCardsType
    * */
    protected int defense = 0;

    @Override
    public int cardDefense() {
        return defense;
    }
}
