package cards.cardsList;

import cards.AggressiveCardsType;
import cards.SimpleCard;

/**
 * simple test card
 * Created by serdyuk on 7/3/17.
 */
public class TestCardOne extends SimpleCard implements AggressiveCardsType {
    @Override
    public int getCardDamage() {
        return 0;
    }
}
