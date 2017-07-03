package cards.cardsList;

import cards.AggressiveCardsType;
import cards.SimpleCard;

/**
 * Extended from simple card
 * All cards with "attack" will be extended from this class
 *
 * TODO: describe methods How aggressive cards will be work with bonuses together (freeze, poison, etc)
 *
 * Created by serdyuk on 7/3/17.
 */
public class AgrressiveCard extends SimpleCard implements AggressiveCardsType {
    protected int damage = 0;

    @Override
    public int cardDamage() {
        return damage;
    }
}
