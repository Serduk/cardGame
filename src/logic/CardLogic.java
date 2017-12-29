package logic;

import cards.CardsDeck;
import cards.SimpleCard;
import cards.enumsCards.BonusesInCards;
import characters.Character;
import configuration.PathsAndRoutes;
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

    private CardsDeck cardsDeck = new CardsDeck();

    private ArrayList<SimpleCard> cardsCollection = cardsDeck.getCardsCollection();
    //    Cards deck for user
    private ArrayList<SimpleCard> userCardDeck = cardsDeck.getCardsDeckInHand();
    //    cards deck for enemy
    private ArrayList<SimpleCard> enemyCardDeck = cardsDeck.getCardsDeckInHand();

    private boolean isCardsShouldBeDisplayed = false;
    private boolean isPlayWithBot = false;
    private boolean isFirstGame = true;

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

    /**
     * will clear USER cards deck collection
     */
    private void clearUserCardDeck() {
        userCardDeck.clear();
        character.setCardsInHands(userCardDeck);
    }

    /**
     * will clear ENEMY cards deck collection
     */
    private void clearEnemyCardDeck() {
        enemyCardDeck.clear();
        characterEnemy.setCardsInHands(enemyCardDeck);
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
     * Method replace card in user hands
     * take one card in main deck and put it in hands on place
     *
     * @param cardPosition set place in hands
     *                     new random card, from main deck, will be placed instead card in hands
     */
    private void replaceCardInHandsFromMainDeck(int cardPosition) {
        Random random = new Random();
        int num = random.nextInt(CardsDeck.mainCardsDeckCollectionSize);
        System.out.println("GET RANDOM CARD ON INDEX: " + num);
        userCardDeck.set(cardPosition, cardsCollection.get(num));
    }

    /************************* New METHODS MOVED FROM GUI*****************************/
    public ArrayList getEnemyCardsGUI() {
        ArrayList<String> cardsImg = new ArrayList<>();

        if (isCardsShouldBeDisplayed) {
            for (SimpleCard card : enemyCardDeck) {
                cardsImg.add(card.pathToCardIMG);
            }
        } else {
            for (int i = 0; i < enemyCardDeck.size(); i++) {
                cardsImg.add(PathsAndRoutes.zeroCard);
            }
        }
        return cardsImg;
    }

    /**
     * Method get from user cards all images;
     * @return ArrayList with path to images for user cards
     *
     * */
    public ArrayList getCardsGUI() {
        ArrayList<String> cardsImg = new ArrayList<>();

//        for (int i = 0; i < userCardDeck.size(); i++) {
//            SimpleCard card = userCardDeck.get(i);
//            cardsImg.add(card.pathToCardIMG);
//        }

        for (SimpleCard card : userCardDeck) {
            cardsImg.add(card.pathToCardIMG);
        }

        return cardsImg;
    }

    public boolean newGame() {
        if (!isFirstGame) {
            System.out.println("clear cards in decks");
            clearUserCardDeck();
            clearEnemyCardDeck();
        }

        userCardDeck = cardsDeck.getCardsDeckInHand();
        character.setCardsInHands(showCardsInHands());
        characterEnemy.setCardsInHands(showCardsInHands());

        System.out.println("Main Deck Size is: " + CardsDeck.getCardsCollection().size());
        System.out.println("User Deck Size is: " + character.getCardsInHands().size());
        System.out.println("Enemy Deck Size is: " + characterEnemy.getCardsInHands().size());

        return true;
    }

    /**
     * Method set boolean to true or false
     * Check, first game or not
     * Usable in @method newGame()
     * @param isFirstGame set to false => method newGame clear all data on deck for user, enemy and main deck
     *
     * */
    public void setIsFirstGame(boolean isFirstGame) {
        this.isFirstGame = isFirstGame;
    }
}