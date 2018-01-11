package configuration;

/**
 * Describe all routes and paths:
 * saving files
 *
 * Good picture resizer: http://picresize.com/
 *
 * Created by sserdiuk on 7/3/17.
 */
public final class PathsAndRoutes {
    private static final String pathToGameCards = "resources/img/cardsIMG/";
    public static final String iconIMG = pathToGameCards + "deck.jpg";
    public static final String zeroCard = pathToGameCards + "card_00.png";

    private static final String pathToAttributes = "resources/img/characterAttributes/";
    public static final String pathToHealthIMG = pathToAttributes + "health.png";
    public static final String pathToArmorIMG = pathToAttributes + "armor.png";
    public static final String pathToAttackPowerIMG = pathToAttributes + "attackPower.png";

    public static final String pathNatureCards = pathToGameCards + "nature/school_1_card_";
    public static final String pathFireCards = pathToGameCards + "fire/school_2_card_";
    public static final String pathEarthCards = pathToGameCards + "earth/school_3_card_";
    public static final String pathWaterCards = pathToGameCards + "water/school_4_card_";

    private static final String pathToResourcesIMG = "resources/img/resourcesIMG/";
    public static final String pathToEarthIMG = pathToResourcesIMG + "resource_3_earth.png";
    public static final String pathToFireIMG = pathToResourcesIMG + "resource_2_fire.png";
    public static final String pathToWaterIMG = pathToResourcesIMG + "resource_4_water.png";
    public static final String pathToNatureIMG = pathToResourcesIMG + "resource_1_nature.png";

    private static final String pathToBuffsAndDebuffsIMG = "resources/img/buffsAndDeBuffsIMG/";
    public static final String pathToHealthRestoreActive = pathToBuffsAndDebuffsIMG + "param_icon_1_active.jpg";
    public static final String pathToHealthRestoreInActive = pathToBuffsAndDebuffsIMG + "param_icon_1_inactive.jpg";
    public static final String pathToReflectActive = pathToBuffsAndDebuffsIMG + "param_icon_2_active.jpg";
    public static final String pathToReflectInActive = pathToBuffsAndDebuffsIMG + "param_icon_2_inactive.jpg";
    public static final String pathToIsPoisonedActive = pathToBuffsAndDebuffsIMG + "param_icon_4_active.jpg";
    public static final String pathToIsPoisonedInActive = pathToBuffsAndDebuffsIMG + "param_icon_4_inactive.jpg";
    public static final String pathToIsFreezedActive = pathToBuffsAndDebuffsIMG + "param_icon_3_active.jpg";
    public static final String pathToIsFreezedInActive = pathToBuffsAndDebuffsIMG + "param_icon_3_inactive.jpg";
}
