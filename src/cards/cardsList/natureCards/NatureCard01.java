package cards.cardsList.natureCards;

import cards.BonusCardsType;
import cards.SimpleCard;
import cards.enumsCards.BonusesInCards;
import cards.enumsCards.CardsType;
import cards.enumsCards.ResourceTypes;
import configuration.PathsAndRoutes;

/**
 * Nature Cards Collection.
 * Card 1. img taken from .resources.img.cardsIMG.nature
 *
 * Created by sserdiuk on 7/11/17.
 */
public class NatureCard01 extends SimpleCard {
    {
        pathToCardIMG = PathsAndRoutes.pathNatureCards + "01.png";
        resourceTypeNeed = resourceTypeDetector(ResourceTypes.NATURE);
        resourceCountNeed = 3;

        cardTypeDetector(CardsType.BONUS);
        chanceForBonusSuccess = 100;
        bonuses.put(BonusesInCards.ADD_HEALTH, 10);
        bonuses.put(BonusesInCards.REMOVE_POISON_MY_SELF, 0);
    }
}
