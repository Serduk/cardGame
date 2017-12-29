package cards;

import cards.cardsList.earthCards.EarthCard01;
import cards.cardsList.fireCards.FireCard01;
import cards.cardsList.natureCards.NatureCard01;
import cards.cardsList.waterCards.WaterCard01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardsDeck {
    public CardsDeck() {
        setMainCardsDeck();
    }
    private static List cardsCollection = new ArrayList();
    private List userCardDeck = new ArrayList();


    public final static int cardsDeckInUserHandCount = 5;
    public static int mainCardsDeckCollectionSize;


    /**
     * In this method automatically init all cards
     * Cards will be added in main deck collection
     * TODO: Probably move to constructor?
     */
    public static void setMainCardsDeck() {
        cardsCollection.add(new EarthCard01());
        cardsCollection.add(new FireCard01());
        cardsCollection.add(new WaterCard01());
        cardsCollection.add(new NatureCard01());

        mainCardsDeckCollectionSize = cardsCollection.size();
    }

    public static List getCardsCollection() {
        return cardsCollection;
    }

    /**
     * Method will clear main cards deck collection
     */
    public static void clearMainCardsDeck() {
        cardsCollection.clear();
    }


    /**
     * Method try get card random card from main deck,
     * and put it in character deck
     */
    private void getCardInHandsFromMainDeck() {
        Random random = new Random();
        int num = random.nextInt(CardsDeck.mainCardsDeckCollectionSize);
        System.out.println("GET RANDOM CARD ON INDEX: " + num);
        userCardDeck.add(cardsCollection.get(num));
    }

    /**
     * Init all cards for user.
     * Create Cards Deck for player
     * get max deck size for player
     * get max deck size in total
     * get random card from MAIN DECK,
     * and put it to player Deck
     */
    public List getCardsDeckInHand() {
        System.out.println("CARDS COLLECTION SIZE IS: " + cardsCollection.size());
        while (userCardDeck.size() < CardsDeck.cardsDeckInUserHandCount) {
            getCardInHandsFromMainDeck();
        }
        return userCardDeck;
    }
}
