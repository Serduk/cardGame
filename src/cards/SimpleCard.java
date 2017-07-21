package cards;

import cards.enumsCards.BonusesInCards;
import cards.enumsCards.CardsType;
import cards.enumsCards.ResourceTypes;

import java.util.HashMap;
import java.util.Map;

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

//    boolean for checking. Has card damage or not. If has -> set bool to true, and set damage in CardLogic class
    protected boolean hasDamageOnCard = false;

//    boolean for checking. Has card debuf or not. if has -> set bool to true, and set debuf in CardLogic
    protected boolean hasDebufOnCard = false;

/********************************************* BASIC CARDS PROPERTIES *************************************************/

    public int getResourceCountNeed() {
        return resourceCountNeed;
    }

    public boolean isHasDamageOnCard() {
        return hasDamageOnCard;
    }

    public boolean isHasDebufOnCard() {
        return hasDebufOnCard;
    }

    public String getResourceTypeNeed() {
        return resourceTypeNeed;
    }

    protected String resourceTypeDetector(ResourceTypes resourceTypes) {
        return resourceTypes.toString().toLowerCase();
    }

    protected String cardTypeDetector(CardsType cardsType) {
        return cardsType.toString().toLowerCase();
    }

/********************************* AggressiveCardsType CARDS METHODS AND FIELDS Implementation ***********************/
    protected int damage = 0;

    @Override
    public int getCardDamage() {
        return damage;
    }


    /*************************************** BONUS CARDS METHODS AND FIELDS Implementation ***********************/
    protected int chanceForBonusSuccess = 100;
    protected boolean hasBonus = false;
    protected HashMap<BonusesInCards, Integer> bonuses = new HashMap();
    private HashMap<BonusesInCards, Integer> successfulBonuses = new HashMap<>();

    /**
     * Method implemented.
     * Add chance for adding some bonuses.
     * They all (bonuses) have some chance to be added(%).
     * User mast change chanceForBonusSuccess for set another chance in child classes
     *  @param bonus take Object from enum BonusesInCards and Integer -> bonus size
     *               Then parse all keys, and check condition ->  % for adding
     *
     * Method check each entrySet from HashMap Bonus.
     *               if % = 100 => all bonuses will be added by default.
     *               if % < 100 => each set will be checked on condition.
     *               if random num <= chance for adding bonus => Bonus will be added
     *
     *               All Successful bonuses will be add in successfulBonuses
     *
     * TODO: Make method as Protected
     * TODO: SomeTimes bonuses nod added. Example NatureCard01; need debug
    * */
    @Override
    public void addBonus(HashMap<BonusesInCards, Integer> bonus) {
        System.out.println("CHANGE FOR BONUS SUCCESS " + chanceForBonusSuccess);
        System.out.println("TRY ADDING " + bonus.size() + " BONUSES");
        for (Map.Entry<BonusesInCards, Integer> e : bonus.entrySet()) {
            //to get key
            e.getKey();
            System.out.println(e.getKey());
            //and to get value
            e.getValue();
            System.out.println(e.getValue());

            if (chanceForBonusSuccess < 100) {
                if ((int) (Math.random() * 100) <= chanceForBonusSuccess) {
                    System.out.println("Add bonus");
                    successfulBonuses.put(e.getKey(), e.getValue());
                } else {
                    System.out.println("Sorry, bonus not added");
                }
            } else {
                System.out.println("Add bonus because percentage = 100");
                successfulBonuses.put(e.getKey(), e.getValue());
            }
        }
    }

    /**
     * @return successfulBonuses
     * Firstly all this bonuses will be checked on "Success Percent" in method addBonus()
     * If bonus fail check in addBonus, he will not be added in successfulBonuses
     * */
    @Override
    public HashMap<BonusesInCards, Integer> getSuccessfulBonuses() {
        System.out.println("ADDED " + successfulBonuses.size() + " BONUSES");
        return successfulBonuses;
    }

    /**
     * Converter for Enums
     * @param bonusesInCards take enum and convert it in String
     * @return bonusType in String.
     *
     * it's will be need in System Logic.
     * When user play card -> it take enums and convert them to Bonuses
     * */
    public String bonusesType(BonusesInCards bonusesInCards) {
        String bonusType = bonusesInCards.toString();
        System.out.println(bonusType);
        return bonusType;
    }

    /**
     * Method check HashMap with bonuses
     * If Card has some bonuses (or som change to get bonus)
     * @return boolean with existing bonus in card
     * */
    public boolean isHasBonus() {
        if (!successfulBonuses.isEmpty()) {
            hasBonus = true;
        }
        return hasBonus;
    }

/*************************************** DefenseCardsType CARDS METHODS AND FIELDS Implementation ***********************/

    protected int defense = 0;

    /**
     * @return Bonus for Defense
     *
     * */
    @Override
    public int cardDefense() {
        return defense;
    }
}
