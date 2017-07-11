package cards;

import java.util.HashMap;

/**
 * Interface for bonuses on each card
 *
 * Created by serdyuk on 7/3/17.
 */
public interface BonusCardsType {
    /*
    * By default it will be 100% chance to add some bonus or deBuf
    * */
    HashMap<Object, Integer> addBonus(HashMap<Object, Integer> bonusType);
}
