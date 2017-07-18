package cards.cardsList.fireCards;


import cards.SimpleCard;
import cards.enumsCards.BonusesInCards;
import cards.enumsCards.CardsType;
import cards.enumsCards.ResourceTypes;
import configuration.PathsAndRoutes;

/**
 * Fire Cards Collection.
 * Card 1. img taken from .resources.img.cardsIMG.fire
 *
 * Created by sserdiuk on 7/11/17.
 */
public class FireCard01 extends SimpleCard {
    {
        pathToCardIMG = PathsAndRoutes.pathFireCards + "01.png";
        resourceTypeNeed = resourceTypeDetector(ResourceTypes.FIRE);
        resourceCountNeed = 5;

        cardTypeDetector(CardsType.BONUS);
        bonuses.put(BonusesInCards.BUILD_TEMPLE_EARTH_MY_SELF, 1);
        bonuses.put(BonusesInCards.BUILD_TEMPLE_FIRE_MY_SELF, 1);
        bonuses.put(BonusesInCards.BUILD_TEMPLE_WATER_MY_SELF, 1);
        bonuses.put(BonusesInCards.BUILD_TEMPLE_NATURE_MY_SELF, 1);

        addBonus(bonuses);
    }
}
