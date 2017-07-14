package cards;

import cards.enumsCards.BonusesInCards;

import java.util.HashMap;

/**
 * Interface for bonuses on each card
 *
 * Created by serdyuk on 7/3/17.
 */
public interface BonusCardsType {
    /**
     * By default it will be 100% chance to add some bonus or deBuf
     *
     * @param bonusType take HashMap with Bonus types and Counts
    * */
    void addBonus(HashMap<BonusesInCards, Integer> bonusType);

    /**
     * Get successful bonuses, who checked in "addBonus" Method
     *
     * @return successful bonuses, who parsed and checked in addBonus();
    * */
    HashMap<BonusesInCards, Integer> getSuccessfulBonuses();
}
