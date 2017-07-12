package cards.cardsList.earthCards;

import cards.SimpleCard;
import cards.enumsCards.BonusesInCards;
import cards.enumsCards.CardsType;
import cards.enumsCards.ResourceTypes;
import configuration.PathsAndRoutes;

/**
 * Earth Cards Collection.
 * Card 1. img taken from .resources.img.cardsIMG.earth
 *
 * Created by sserdiuk on 7/11/17.
 */
public class EarthCard1 extends SimpleCard {
    {
        pathToCardIMG = PathsAndRoutes.pathToGameCards + "earth/school_3_card_01.phg";
        resourceTypeNeed = resourceTypeDetector(ResourceTypes.EARTH);
        resourceCountNeed = 3;

        cardType = cardTypeDetector(CardsType.BONUS);

        bonuses.put(BonusesInCards.ARMOR_ADD_MY_SELF, 3);
        bonuses.put(BonusesInCards.BUILD_TEMPLE_EARTH_MY_SELF, 1);

        chanceForBunusSuccess = 25;

        addBonus(bonuses);
    }
}
