package logic;

import cards.SimpleCard;
import cards.enumsCards.BonusesInCards;

import java.util.HashMap;

/**
 * Method for Using card in game.
 * Method pars all data in hash map
 * Add and Decrease all bonuses
 * Add Damage
 * etc
 *
 * Created by sserdiuk on 7/14/17.
 */
public interface UseCards {
    void playCard(int card);
}
