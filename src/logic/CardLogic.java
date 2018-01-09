package logic;

import cards.CardsDeck;
import cards.SimpleCard;
import cards.enumsCards.BonusesInCards;
import characters.Character;
import characters.CharacterAttributes;
import configuration.PathsAndRoutes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private List<SimpleCard> cardsCollection = cardsDeck.getCardsCollection();
    //    Cards deck for user
    private List<SimpleCard> userCardDeck = cardsDeck.getCardsDeckInHand();
    //    cards deck for enemy
    private List<SimpleCard> enemyCardDeck = cardsDeck.getCardsDeckInHand();

    private Map<CharacterAttributes, Integer> characterData = new HashMap<>();
    private Map<CharacterAttributes, Integer> enemyCharacterData = new HashMap<>();

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
    public List<SimpleCard> showCardsInHands() {
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
    public List getEnemyCardsGUI() {
        List<String> cardsImg = new ArrayList<>();

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
    public List getCardsGUI() {
        List<String> cardsImg = new ArrayList<>();

//        for (int i = 0; i < userCardDeck.size(); i++) {
//            SimpleCard card = userCardDeck.get(i);
//            cardsImg.add(card.pathToCardIMG);
//        }

        for (SimpleCard card : userCardDeck) {
            cardsImg.add(card.pathToCardIMG);
        }

        return cardsImg;
    }

    /* ****************************** METHODS FOR CHARACTERS (USER/ENEMY) *************************************/

    private void setCharacterData() {
        characterData.put(CharacterAttributes.ATTACK_POWER, character.getAttackPower());
        characterData.put(CharacterAttributes.HEALTH, character.getHealth());
        characterData.put(CharacterAttributes.ARMOR, character.getArmor());
        characterData.put(CharacterAttributes.POISONED_ROUNDS, character.getPoisoneRoundsCount());
        characterData.put(CharacterAttributes.FREEZED_ROUNDS, character.getFreezeRoundsCount());

        characterData.put(CharacterAttributes.TEMPLE_EARTH, character.getTempleEarth());
        characterData.put(CharacterAttributes.TEMPLE_FIRE, character.getTempleFire());
        characterData.put(CharacterAttributes.TEMPLE_NATURE, character.getTempleNature());
        characterData.put(CharacterAttributes.TEMPLE_WATER, character.getTempleWater());

        characterData.put(CharacterAttributes.RESOURCE_EARTH_COUNT, character.getResourceEarthCount());
        characterData.put(CharacterAttributes.RESOURCE_FIRE_COUNT, character.getResourceFireCount());
        characterData.put(CharacterAttributes.RESOURCE_NATURE_COUNT, character.getResourceNatureCount());
        characterData.put(CharacterAttributes.RESOURCE_WATER_COUNT, character.getResourceWaterCount());
    }

    /**
     * @return map with main data about character
     * */
    public Map getCharacterData() {
        setCharacterData();

        return characterData;
    }

    private void setEnemyCharacterData() {
        enemyCharacterData.put(CharacterAttributes.ATTACK_POWER, characterEnemy.getAttackPower());
        enemyCharacterData.put(CharacterAttributes.HEALTH, characterEnemy.getHealth());
        enemyCharacterData.put(CharacterAttributes.ARMOR, characterEnemy.getArmor());
        enemyCharacterData.put(CharacterAttributes.POISONED_ROUNDS, characterEnemy.getPoisoneRoundsCount());
        enemyCharacterData.put(CharacterAttributes.FREEZED_ROUNDS, characterEnemy.getFreezeRoundsCount());

        enemyCharacterData.put(CharacterAttributes.TEMPLE_EARTH, characterEnemy.getTempleEarth());
        enemyCharacterData.put(CharacterAttributes.TEMPLE_FIRE, characterEnemy.getTempleFire());
        enemyCharacterData.put(CharacterAttributes.TEMPLE_NATURE, characterEnemy.getTempleNature());
        enemyCharacterData.put(CharacterAttributes.TEMPLE_WATER, characterEnemy.getTempleWater());

        enemyCharacterData.put(CharacterAttributes.RESOURCE_EARTH_COUNT, characterEnemy.getResourceEarthCount());
        enemyCharacterData.put(CharacterAttributes.RESOURCE_FIRE_COUNT, characterEnemy.getResourceFireCount());
        enemyCharacterData.put(CharacterAttributes.RESOURCE_NATURE_COUNT, characterEnemy.getResourceNatureCount());
        enemyCharacterData.put(CharacterAttributes.RESOURCE_WATER_COUNT, characterEnemy.getResourceWaterCount());
    }

    /**
     * @return map with main data about enemy Character
     * */
    public Map getEnemyCharacterData() {
        setEnemyCharacterData();

        return enemyCharacterData;
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