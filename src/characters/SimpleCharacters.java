package characters;

import cards.enumsCards.BonusesInCards;

import java.util.HashMap;

/**
 * Describe all Properties for characters
 * Armor, AttackPower, Resources
 *
 * TODO: Solve problems with user cards were us bonus -> Ignore Armor
 * TODO: How parse Cards with Poisons or Freeze, Reflect (Maby add few fields with this, and add all this bonuses to Attack)
 * Created by sserdiuk on 7/13/17.
 */
public class SimpleCharacters {
    private int attackPower = 0;
    private int health = 100;
    private int armor = 0;

    private int poisonedDamage = 0;
    private int poisoneRounds = 0;

    boolean freezAttack = false;
    boolean ignoreArmorAttack = false;

    private int templeEarth = 1;
    private int templeFire = 1;
    private int templeWater = 1;
    private int templeNature = 1;

    private int resourceEarthCount = 5;
    private int resourceFireCount = 5;
    private int resourceWaterCount = 5;
    private int resourceNatureCount = 5;

    /**
     * Method Make Attack to Enemy
     * @param cardDamage take attack count from card
     * then Add attackPower to cardDamage;
     * Then decrease attack power by one (After each Attack should be lesser by 1)
     * @return total damage (attackPower + Damage From card);
     * */
    public int attack(int cardDamage) {
        int damage = attackPower + cardDamage;
        if (attackPower > 0) {
            attackPower--;
        }
        return damage;
    }
/*------------------------------------------- GET BASE PARAMS -----------------------------------------------------*/
    /**
     * @return total attackPower
     * needed for describing on GUI
     * Or for some check in some another places
     * */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * @return total health
     * needed for describing on GUI
     * Or for some check in some another places
     * */
    public int getHealth() {
        return health;
    }

    /**
     * @return total armor
     * needed for describing on GUI
     * Or for some check in some another places
     * */
    public int getArmor() {
        return armor;
    }

/*------------------------------------------- GET TEMPLE DATA -----------------------------------------------------*/

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
     * @param templeModification send modification for temple counts
     * Modification can add temple or Destroy it
     * */
    public void setTempleCount(BonusesInCards templeType, int templeModification) {
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
     *
     * @return currentTempleCount (1 or more)
     * */
    private int templeCountChecker(int currentTempleCount, int templeModification) {
        currentTempleCount += templeModification;
        if (currentTempleCount < 1) {
            currentTempleCount = 1;
        }
        return currentTempleCount;
    }

    /**
     * Method change TempleCount
     * @param resourceCount send modification for temple counts
     * Modification can add temple or Destroy it
     * */
    public void setResourceCount(BonusesInCards resourceType, int resourceCount) {
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
     *                           first and second params unite
     *                           if totally temple count will be lesser then 1
     *                           method set currentTempleCount = 1
     *
     * @return currentResourceCount (0 or more)
     * */
    private int resourceCountChecker(int currentResourceCount, int resourceModification) {
        currentResourceCount += resourceModification;
        if (currentResourceCount < 0) {
            currentResourceCount = 0;
        }
        return currentResourceCount;
    }

    /*------------------------------------------- ________________ -----------------------------------------------------*/
    /**
     * Method parse all income bonuses from cards.
     * Check it all.
     * And, add all bonuses to Characters
     *
     * @param bonusList -> all data income in hashMap
     *                   key -> Bonus Type
     *                   value -> Count Of this Bonus
     *                   example: ARMOR_ADD_MY_SELF, 1
     *                   armor + 1 on Character
     *
     * */
    public void addBonusFromCards(HashMap<BonusesInCards, Integer> bonusList) {

    }
}
