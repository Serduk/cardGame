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
        return resourceTypes.toString().toLowerCase();
    }

    protected String cardTypeDetector(CardsType cardsType) {
        return cardsType.toString().toLowerCase();
    }

    /*************************************** AggressiveCardsType CARDS METHODS AND FIELDS Implementation ***********************/
    protected int damage = 0;

    @Override
    public int cardDamage() {
        return damage;
    }


    /*************************************** BONUS CARDS METHODS AND FIELDS Implementation ***********************/
    protected int chanceForBunusSuccess = 100;
    protected HashMap<Object, Integer> bonuses = new HashMap();
    private HashMap<Object, Integer> successfulBonuses = new HashMap<>();

    /**
     * Method overrated. and add chance for adding some bonuses.
     * They have some chance to not be added(%).
     * User mast change chanceForBunusSuccess for set another chance
     *  @param bonus take Object from enum BonusesInCards and Integer -> bonus size
     *                  Then parse all keys, and check condition ->  % for adding
     *
     *  @return parsed and chacked on % bonuses
     *
     * TODO: 1. add parser for all bonuses in map.
     * TODO: 2. add checker for all bonuses on success implement in game
    * */
    @Override
    public void addBonus(HashMap<Object, Integer> bonus) {
        System.out.println("CHANGE FOR BONUS SUCCESS " + chanceForBunusSuccess);
        System.out.println("TRY ADDING " + bonus.size() + " BONUSES");

        if (chanceForBunusSuccess < 100) {
            if ((int) (Math.random() * 100) <= chanceForBunusSuccess) {
                System.out.println("Add bonus");
//                successfulBonuses.put();
            } else {
                System.out.println("Sorry, bonus not added");
            }
        } else {
            System.out.println("Add bonus");
        }
    }

    @Override
    public HashMap<Object, Integer> getSuccessfulBonuses() {
        System.out.println("ADDED " + successfulBonuses.size() + " BONUSES");
        return successfulBonuses;
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
