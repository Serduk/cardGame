package logic;

import cards.SimpleCard;
import cards.cardsList.earthCards.EarthCard01;
import cards.cardsList.fireCards.FireCard01;
import cards.cardsList.natureCards.NatureCard01;
import cards.cardsList.waterCards.WaterCard01;
import characters.SimpleCharacters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Here will be described all logic for cards
 * Adding bonuses to characters and att attack
 *
 * Created by sserdiuk on 7/13/17.
 */
public class CardLogic implements UseCards {
//    All cards in total Deck
    List<SimpleCard> cardsCollection = new ArrayList<>();
//    Cards deck for user
    List<SimpleCard> userCardDeck = new ArrayList<>();
//    cards deck for enemy
    List<SimpleCard> enemyCardDeck = new ArrayList<>();

//    character class init
    SimpleCharacters character = new SimpleCharacters();
//    enemy character class init
    SimpleCharacters characterEnemy = new SimpleCharacters();


    private int cardsDeckInUserHandCount = 5;
    private int mainCardsDeckCollectionSize;

    /**
     * In this method automatically init all cards
     * Cards will be added in main deck collection
     * TODO: Probably move to constructor?
     * */
    public void setMainCardsDeck() {
        cardsCollection.add(new EarthCard01());
        cardsCollection.add(new FireCard01());
        cardsCollection.add(new WaterCard01());
        cardsCollection.add(new NatureCard01());

        mainCardsDeckCollectionSize  = cardsCollection.size();
    }

    /**
     * Init all cards for user.
     * Create Cards Deck for player
     * get max deck size for player
     * get max deck size in total
     * get random card from MAIN DECK,
     * and put it to player Deck
     * */
    public void getCardsDeckInHand() {
        Random random = new Random();
        System.out.println("CARDS COLLECTION SIZE IS: " + cardsCollection.size());
        for (int i = 0; i < cardsDeckInUserHandCount; i++) {
            int num = random.nextInt(mainCardsDeckCollectionSize);

            System.out.println("GET RANDOM CARD ON INDEX: " + num);
            userCardDeck.add(cardsCollection.get(num));
        }
    }

    public List<SimpleCard> showCardsInHands() {
        return userCardDeck;
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
