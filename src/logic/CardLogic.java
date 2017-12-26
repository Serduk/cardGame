package logic;

import cards.SimpleCard;
import cards.cardsList.earthCards.EarthCard01;
import cards.cardsList.fireCards.FireCard01;
import cards.cardsList.natureCards.NatureCard01;
import cards.cardsList.waterCards.WaterCard01;
import cards.enumsCards.BonusesInCards;
import characters.Character;
import logic.botActionLogic.BotUseCardLogic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Here will be described all logic for cards
 * Adding bonuses to characters and att attack
 * <p>
 * Created by sserdiuk on 7/13/17.
 */
public class CardLogic implements UseCards {
    public CardLogic(boolean isPlayWithBot) {
        this.isPlayWithBot = isPlayWithBot;
    }

    private boolean isCardsShouldBeDisplayed = false;
    private boolean isPlayWithBot = false;

    //    All cards in total Deck
    protected ArrayList<SimpleCard> cardsCollection = new ArrayList<>();
    //    Cards deck for user
    protected ArrayList<SimpleCard> userCardDeck = new ArrayList<>();
    //    cards deck for enemy
    protected ArrayList<SimpleCard> enemyCardDeck = new ArrayList<>();

    //    character class init
    private Character character = new Character();
    //    enemy character class init
    private Character characterEnemy = new Character();
    BotUseCardLogic botLogic;

    //    TODO: Setup botLogicGame style
    private void botLogicGame(boolean isPlayWithBot) {
        if (isPlayWithBot) {
            BotUseCardLogic botLogic = new BotUseCardLogic();
        }
    }


    protected int cardsDeckInUserHandCount = 5;
    protected int mainCardsDeckCollectionSize;

    /**
     * In this method automatically init all cards
     * Cards will be added in main deck collection
     * TODO: Probably move to constructor?
     */
    public void setMainCardsDeck() {
        cardsCollection.add(new EarthCard01());
        cardsCollection.add(new FireCard01());
        cardsCollection.add(new WaterCard01());
        cardsCollection.add(new NatureCard01());

        mainCardsDeckCollectionSize = cardsCollection.size();
    }

    /**
     * Method will clear main cards deck collection
     */
    public void clearMainCardsDeck() {
        cardsCollection.clear();
    }

    /**
     * will clear USER cards deck collection
     */
    public void clearUserCardDeck() {
        userCardDeck.clear();
        character.setCardsInHands(userCardDeck);
    }

    /**
     * will clear ENEMY cards deck collection
     */
    public void clearEnemyCardDeck() {
        enemyCardDeck.clear();
        characterEnemy.setCardsInHands(enemyCardDeck);
    }

    /**
     * Init all cards for user.
     * Create Cards Deck for player
     * get max deck size for player
     * get max deck size in total
     * get random card from MAIN DECK,
     * and put it to player Deck
     */
    public void getCardsDeckInHand() {
        System.out.println("CARDS COLLECTION SIZE IS: " + cardsCollection.size());
//        TODO: Solve problem, which loop will be better in this situation
        while (userCardDeck.size() < cardsDeckInUserHandCount) {
            getCardInHandsFromMainDeck();
        }
    }

    /**
     * @return userCardDeck
     * show all cards in hands of player
     */
    public ArrayList<SimpleCard> showCardsInHands() {
        return userCardDeck;
    }

    /**
     * @param card -> taken from GUI, when user click on card, on GUI
     *             <p>
     *             Method take card with this number in player hands
     *             Check all data in card, and if he has bonus -> add bonuses for player
     *             Also if has damage -> make damage on enemy
     *             Then take another card in hand in same place in hand (replace)
     */
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
        replaceCardInHandsFromMainDeck(card);
        getCardsGUI();
    }

    /**
     * Method try get card random card from main deck,
     * and put it in character deck
     */
    protected void getCardInHandsFromMainDeck() {
        Random random = new Random();
        int num = random.nextInt(mainCardsDeckCollectionSize);
        System.out.println("GET RANDOM CARD ON INDEX: " + num);
        userCardDeck.add(cardsCollection.get(num));
    }

    /**
     * Method replace card in user hands
     * take one card in main deck and put it in hands on place
     *
     * @param cardPosition set place in hands
     *                     new random card, from main deck, will be placed instead card in hands
     */
    protected void replaceCardInHandsFromMainDeck(int cardPosition) {
        Random random = new Random();
        int num = random.nextInt(mainCardsDeckCollectionSize);
        System.out.println("GET RANDOM CARD ON INDEX: " + num);
        userCardDeck.set(cardPosition, cardsCollection.get(num));
    }

    /************************* New METHODS MOVED FROM GUI*****************************/
    public ArrayList getEnemyCardsGUI() {
        if (isCardsShouldBeDisplayed) {
            return null;
        }
        return null;
    }

    /**
     * Method get from user cards all images;
     * @return ArrayList with path to images for user cards
     *
     * */
    public ArrayList getCardsGUI() {
        if (character.getCardsInHands().isEmpty()) {
            getCardInHandsFromMainDeck();
        }

        ArrayList<String> cardsImg = new ArrayList<>();

        for (int i = 0; i < character.getCardsInHands().size(); i++) {
            SimpleCard card = (SimpleCard) character.getCardsInHands().get(i);
            cardsImg.add(card.pathToCardIMG);
        }

        return cardsImg;
    }

    public boolean newGame(boolean isFirstGame) {
        if (!isFirstGame) {
            clearMainCardsDeck();
            clearUserCardDeck();
            clearEnemyCardDeck();
        }

        setMainCardsDeck();
        character.setCardsInHands(showCardsInHands());
        characterEnemy.setCardsInHands(showCardsInHands());

        return true;
    }
}