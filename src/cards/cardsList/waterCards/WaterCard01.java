package cards.cardsList.waterCards;

import cards.SimpleCard;
import cards.enumsCards.BonusesInCards;
import cards.enumsCards.CardsType;
import cards.enumsCards.ResourceTypes;
import configuration.PathsAndRoutes;

/**
 * Water Cards Collection.
 * Card 1. img taken from .resources.img.cardsIMG.water
 *
 * Created by sserdiuk on 7/11/17.
 */
public class WaterCard01 extends SimpleCard {
    {
        pathToCardIMG = PathsAndRoutes.pathWaterCards + "01.png";
        resourceTypeNeed = resourceTypeDetector(ResourceTypes.WATER);
        resourceCountNeed = 3;

        cardTypeDetector(CardsType.BONUS);
        chanceForBonusSuccess = 100;
        bonuses.put(BonusesInCards.REMOVE_POISON_MY_SELF, 0);

        addBonus(bonuses);
    }
}
