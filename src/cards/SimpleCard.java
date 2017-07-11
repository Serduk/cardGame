package cards;

import cards.enumsCards.BonusesInCards;
import cards.enumsCards.CardsType;
import cards.enumsCards.ResourceTypes;

import java.util.HashMap;

/**
 * In this class we describe basic properties for All cards
 *
 * Created by sserdiuk on 7/3/17.
 */
public class SimpleCard implements AggressiveCardsType, BonusCardsType, DefenseCardsType {
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

    /**
     * Method overrated. and add chance for adding some bonuses.
     * They have some chance to not be added(%).
     * User mast change chancePercentage for set another chance
     *  @param bonusType take Object from enum BonusesInCards and Integer -> bonus size
     *                  Then parse all keys, and check condition ->  % for adding
     *
     *  @return parsed and chacked on % bonuses
     *
     * TODO: 1. add parser for all bonuses in map.
     * TODO: 2. add checker for all bonuses on success implement in game
    * */
    @Override
    public HashMap<Object, Integer> addBonus(HashMap<Object, Integer> bonusType) {
        HashMap<Object, Integer> alreadyParsedBonuses = new HashMap<>();

        if (chancePercentage < 100) {
            if ((Math.random() * 100) <= chancePercentage) {
                System.out.println("Add bonus");
            } else {
                System.out.println("Sorry, bonus not added");
            }
        } else {
            System.out.println("Add bonus");
        }

        return alreadyParsedBonuses;
    }

    public void addSuccessedBonus(HashMap<Object, Integer> bonusType) {

    }

    public String bonusesType(BonusesInCards bonusesInCards) {
        String bonusType = bonusesInCards.toString();
        System.out.println(bonusType);
        return bonusType;
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
