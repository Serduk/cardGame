package logic;

import cards.SimpleCard;
import cards.cardsList.earthCards.EarthCard01;
import cards.cardsList.fireCards.FireCard01;
import cards.cardsList.natureCards.NatureCard01;
import cards.cardsList.waterCards.WaterCard01;
import characters.SimpleCharacters;

import java.util.ArrayList;
import java.util.List;

/**
 * Here will be described all logic for cards
 * Adding bonuses to characters and att attack
 *
 * Created by sserdiuk on 7/13/17.
 */
public class CardLogic implements UseCards {
//    All cards in total Deck
    List<SimpleCard> cardCollection = new ArrayList<>();
//    Cards deck for user
    List<SimpleCard> userCardDeck = new ArrayList<>();
//    cards deck for enemy
    List<SimpleCard> enemyCardDeck = new ArrayList<>();

//    character class init
    SimpleCharacters character = new SimpleCharacters();
//    enemy character class init
    SimpleCharacters characterEnemy = new SimpleCharacters();

//    will be init all cards to total deck
    public void setCardDeck() {
        cardCollection.add(new EarthCard01());
        cardCollection.add(new FireCard01());
        cardCollection.add(new WaterCard01());
        cardCollection.add(new NatureCard01());
    }

//    init cards deck for user
    public void getCardsDeckInHand() {
        
    }



    @Override
    public void playCard(SimpleCard card) {
        if (card.getHasDamageOnCard()) {
//            do damage
        }
        if (card.isHasBonus()) {
            character.addBonusFromCards(card.getSuccessfulBonuses());
        }
    }
}
