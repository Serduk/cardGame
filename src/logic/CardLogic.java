package logic;

import cards.SimpleCard;
import cards.cardsList.earthCards.EarthCard01;
import cards.cardsList.fireCards.FireCard01;
import cards.cardsList.natureCards.NatureCard01;
import cards.cardsList.waterCards.WaterCard01;
import cards.enumsCards.BonusesInCards;
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
    protected List<SimpleCard> cardsCollection = new ArrayList<>();
//    Cards deck for user
    protected List<SimpleCard> userCardDeck = new ArrayList<>();
//    cards deck for enemy
    protected List<SimpleCard> enemyCardDeck = new ArrayList<>();

//    character class init
    SimpleCharacters character = new SimpleCharacters();
//    enemy character class init
    SimpleCharacters characterEnemy = new SimpleCharacters();


    protected int cardsDeckInUserHandCount = 5;
    protected int mainCardsDeckCollectionSize;

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
        System.out.println("CARDS COLLECTION SIZE IS: " + cardsCollection.size());
//        TODO: Solve problem, which loop will be better in this situation
        while (userCardDeck.size() < cardsDeckInUserHandCount) {
            getCardInHandsFromMainDeck();
        }
//        for (int i = 0; i < cardsDeckInUserHandCount; i++) {
//            getCardInHandsFromMainDeck();
//        }
    }

    /**
     * @return userCardDeck
     * show all cards in hands of player
     * */
    public List<SimpleCard> showCardsInHands() {
        return userCardDeck;
    }

    /**
     * @param card -> taken from GUI, when user click on card, on GUI
     *
     * Method take card with this number in player hands
     * Check all data in card, and if he has bonus -> add bonuses for player
     * Also if has damage -> make damage on enemy
     * Then take another card in hand in same place in hand (replace)
     * */
    @Override
    public void playCard(int card) {
        userCardDeck.get(card);
        if (userCardDeck.get(card).isHasDamageOnCard()) {
            System.out.println("TRY ATTACK. DAMAGE WILL BE : " + character.attack(userCardDeck.get(card).getCardDamage()));
            character.attack(userCardDeck.get(card).getCardDamage());
//            TODO: fix data with debuffs
            character.takeDamage(character.attack(userCardDeck.get(card).getCardDamage()), BonusesInCards.ATTACK_ADD_MY_SELF);
        }
        if (userCardDeck.get(card).isHasDebufOnCard()) {
//            TODO: SET DEBUFF ON CHARACTER
        }

        if (userCardDeck.get(card).isHasBonus()) {
            character.addBonusFromCards(userCardDeck.get(card).getSuccessfulBonuses());
        }
//        TODO: we don't need remove card from list, just replace it and redraw;
//        userCardDeck.remove(card);
        replaceCardInHandsFromMainDeck(card);
    }

    /**
     * Method try get card random card from main deck,
     * and put it in character deck
     * */
    protected void getCardInHandsFromMainDeck() {
        Random random = new Random();
        int num = random.nextInt(mainCardsDeckCollectionSize);
        System.out.println("GET RANDOM CARD ON INDEX: " + num);
        userCardDeck.add(cardsCollection.get(num));
    }

    /**
     * Method replace card in user hands
     * take one card in main deck and put it in hands on place
     * @param cardPosition set place in hands
     * new random card, from main deck, will be placed instead card in hands
     * */
    protected void replaceCardInHandsFromMainDeck(int cardPosition) {
        Random random = new Random();
        int num = random.nextInt(mainCardsDeckCollectionSize);
        System.out.println("GET RANDOM CARD ON INDEX: " + num);
        userCardDeck.set(cardPosition, cardsCollection.get(num));
    }
}
