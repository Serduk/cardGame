package characters;

import cards.SimpleCard;
import cards.enumsCards.BonusesInCards;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Describe all Properties for characters
 * Armor, AttackPower, Resources
 * <p>
 * TODO: Solve problems with user cards were us bonus -> Ignore Armor
 * TODO: How parse Cards with Poisons or Freeze, Reflect (Maby add few fields with this, and add all this bonuses to Attack)
 * TODO: REGENERATION FEATURE, FIX
 * Created by sserdiuk on 7/13/17.
 */
public class Character {
    private List cardsInHands;

    private int attackPower = 0;
    private int health = 100;
    private int armor = 0;

    private int poisonedDamage = 0;
    private int poisonedRounds = 0;

    private int freezeRounds = 0;

    private int regenerationPoints = 0;
    private int regenerationRounds = 0;

    private int reflectionPoints = 0;
    private int reflectionRounds = 0;

    private boolean poisonAttack = false;
    private boolean freezeAttack = false;
    private boolean ignoreArmorAttack = false;

    private int templeEarth = 1;
    private int templeFire = 1;
    private int templeWater = 1;
    private int templeNature = 1;

    private int resourceEarthCount = 5;
    private int resourceFireCount = 5;
    private int resourceWaterCount = 5;
    private int resourceNatureCount = 5;

    /**
     * Methods should add save cards in hands character
     *
     * @param cardsInHands take List from CardLogic and save to list
     *
     * */
    public void setCardsInHands(List cardsInHands) {
        this.cardsInHands = cardsInHands;
    }

    /**
     * @return arrayList with cards in hands
     * */
    public List getCardsInHands() {
        return cardsInHands;
    }

    public boolean replaceCardInHands(int cardNum, SimpleCard card) {
        if (cardsInHands.size() >= cardNum) {
            cardsInHands.set(cardNum, card);
            System.out.println("Card Successfully replaced");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method Make Attack to Enemy
     *
     * @param cardDamage take attack count from card
     *                   then Add attackPower to getCardDamage;
     *                   Then decrease attack power by one (After each Attack should be lesser by 1)
     * @return total damage (attackPower + Damage From card);
     */
    public int attack(int cardDamage) {
        int damage = attackPower + cardDamage;
        if (attackPower > 0) {
            attackPower--;
        }
        return damage;
    }

    /**
     * Method for work with receiving damage from Attacker
     *
     * @param damageReceive -> get damage int
     * @param debuff        -> check debufs.
     *                      ex: Attack may be with poison or freeze
     *                      <p>
     *                      Firstly: system should check armor count, and recalculate damage with armor
     *                      if debuf has ignore armor -> recalculate clear damage
     *                      <p>
     *                      TODO: add condition for hasArmor
     *                      TODO: Add condition for debuf: ignore armor, poison, freeze, etc
     */
    public void takeDamage(int damageReceive, BonusesInCards debuff) {

    }
/*------------------------------------------- GET BASE PARAMS -----------------------------------------------------*/

    /**
     * @return total attackPower
     * needed for describing on GUI
     * Or for some check in some another places
     */
    public int getAttackPower() {
        return attackPower;
    }

    private void setAttackPower(int Modification) {
        attackPower += Modification;
        if (attackPower < 0) {
            attackPower = 0;
        }
    }

    /**
     * @return total health
     * needed for describing on GUI
     * Or for some check in some another places
     */
    public int getHealth() {
        return health;
    }

    private void setHealth(int Modification) {
        health += Modification;
        if (health < 0) {
            health = 0;
        }
    }

    /**
     * @return total armor
     * needed for describing on GUI
     * Or for some check in some another places
     */
    public int getArmor() {
        return armor;
    }

    private void setArmor(int Modification) {
        armor += Modification;
        if (armor < 0) {
            armor = 0;
        }
    }

    /**
     * @return boolean for attack ignore Armor or ignore Armor
     */
    public boolean isIgnoreArmorAttack() {
        return ignoreArmorAttack;
    }

    private void setIgnoreArmorAttack(boolean setBoolean) {
        ignoreArmorAttack = setBoolean;
    }

    /**
     * @return boolean for attack Freeze or Not Freeze
     */
    public boolean isFreezeAttack() {
        return freezeAttack;
    }

    private void setFreezeAttack(boolean setBoolean) {
        freezeAttack = setBoolean;
    }

    /**
     * @return boolean for attack Poisoned or Poisoned
     */
    public boolean isPoisonAttack() {
        return poisonAttack;
    }

    private void setPoisonedAttack(boolean setBoolean) {
        poisonAttack = setBoolean;
    }

    /********************************************* GET POISONED AND FREEZED DATA *************************************/
    public int getPoisoneRoundsCount() {
        return poisonedRounds;
    }

    public int getFreezeRounds() {
        return freezeRounds;
    }

//    TODO: Implement feature with debuffs to user. add debuffs in switcher and etc
    public int getReflectionRounds() {
        return reflectionRounds;
    }

    public int getRegenerationRounds() {
        return regenerationRounds;
    }

    public int getRegenerationPoints() {
        return regenerationPoints;
    }

    public int getReflectionPoints() {
        return reflectionPoints;
    }

    /*------------------------------------------- GET TEMPLE DATA ----------------------------------------------------*/

    public int getTempleEarth() {
        return templeEarth;
    }

    public int getTempleFire() {
        return templeFire;
    }

    public int getTempleNature() {
        return templeNature;
    }

    public int getTempleWater() {
        return templeWater;
    }

    public int getResourceEarthCount() {
        return resourceEarthCount;
    }

    public int getResourceFireCount() {
        return resourceFireCount;
    }

    public int getResourceNatureCount() {
        return resourceNatureCount;
    }

    public int getResourceWaterCount() {
        return resourceWaterCount;
    }

    /**
     * Method change TempleCount
     *
     * @param templeModification send modification for temple counts
     *                           Modification can add temple or Destroy it
     */
    private void setTempleCount(BonusesInCards templeType, int templeModification) {
        switch (templeType) {
            case BUILD_TEMPLE_FIRE_MY_SELF:
                templeFire = templeCountChecker(templeFire, templeModification);
                break;
            case BUILD_TEMPLE_EARTH_MY_SELF:
                templeEarth = templeCountChecker(templeEarth, templeModification);
                break;
            case BUILD_TEMPLE_WATER_MY_SELF:
                templeWater = templeCountChecker(templeWater, templeModification);
                break;
            case BUILD_TEMPLE_NATURE_MY_SELF:
                templeNature = templeCountChecker(templeNature, templeModification);
                break;
            case BUILD_TEMPLE_ALL_MY_SELF:
                templeNature = templeCountChecker(templeNature, templeModification);
                templeWater = templeCountChecker(templeWater, templeModification);
                templeEarth = templeCountChecker(templeEarth, templeModification);
                templeFire = templeCountChecker(templeFire, templeModification);
                break;
            default:
                System.out.println("Temples not Added");
        }
    }

    /**
     * Temple Count must be 1 or more.
     * 1 -> minimum
     *
     * @param currentTempleCount take current state of temples
     * @param templeModification take data from card
     *                           first and second params unite
     *                           if totally temple count will be lesser then 1
     *                           method set currentTempleCount = 1
     * @return currentTempleCount (1 or more)
     */
    private int templeCountChecker(int currentTempleCount, int templeModification) {
        currentTempleCount += templeModification;
        if (currentTempleCount < 1) {
            currentTempleCount = 1;
        }
        return currentTempleCount;
    }

    /**
     * Method change TempleCount
     *
     * @param resourceCount send modification for temple counts
     *                      Modification can add temple or Destroy it
     */
    private void setResourceCount(BonusesInCards resourceType, int resourceCount) {
        switch (resourceType) {
            case RESOURCE_EARTH:
                resourceEarthCount = resourceCountChecker(resourceEarthCount, resourceCount);
                break;
            case RESOURCE_FIRE:
                resourceFireCount = resourceCountChecker(resourceFireCount, resourceCount);
                break;
            case RESOURCE_WATER:
                resourceWaterCount = resourceCountChecker(resourceWaterCount, resourceCount);
                break;
            case RESOURCE_NATURE:
                resourceNatureCount = resourceCountChecker(resourceNatureCount, resourceCount);
                break;
            case RESOURCE_ALL:
                break;
            default:
                System.out.println("Resource don't added");
        }
    }

    /**
     * Temple Count must be 1 or more.
     * 1 -> minimum
     *
     * @param currentResourceCount take current state of resources
     * @param resourceModification take data from card
     *                             first and second params unite
     *                             if totally temple count will be lesser then 1
     *                             method set currentTempleCount = 1
     * @return currentResourceCount (0 or more)
     */
    private int resourceCountChecker(int currentResourceCount, int resourceModification) {
        currentResourceCount += resourceModification;
        if (currentResourceCount < 0) {
            currentResourceCount = 0;
        }
        return currentResourceCount;
    }

    /*---------------------------------------- INCOME BONUSES PARSER ------------------------------------------------*/

    /**
     * Method parse all income bonuses from cards.
     * Check it all.
     * And, add all bonuses to Characters
     *
     * @param bonusList -> all data income in hashMap
     *                  key -> Bonus Type
     *                  value -> Count Of this Bonus
     *                  example: ARMOR_ADD_MY_SELF, 1
     *                  armor + 1 on Character
     */
    public void addBonusFromCards(HashMap<BonusesInCards, Integer> bonusList) {
        for (Map.Entry<BonusesInCards, Integer> entry : bonusList.entrySet()) {

            BonusesInCards key = entry.getKey();
            int value = entry.getValue();

            String keyParser = key.toString();
            if (keyParser.contains("BUILD_TEMPLE")) {
                setTempleCount(key, value);
            } else if (keyParser.contains("RESOURCE")) {
                setResourceCount(key, value);
            } else if (keyParser.contains("ADD_HEALTH")) {
                setHealth(value);
            } else if (keyParser.contains("ARMOR_ADD")) {
                setArmor(value);
            } else if (keyParser.contains("ATTACK_ADD")) {
                setAttackPower(value);
            } else if (keyParser.contains("IGNORE_ARMOR")) {
                setIgnoreArmorAttack(true);
            } else if (keyParser.contains("FREEZE_ENEMY")) {
                setFreezeAttack(true);
            } else if (keyParser.contains("POISON_ENEMY")) {
                setPoisonedAttack(true);
            }
        }
    }
}
