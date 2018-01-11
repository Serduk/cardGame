package configuration;

/**
 * Describe all routes and paths:
 * saving files
 *
 * Created by sserdiuk on 7/3/17.
 */
public final class PathsAndRoutes {
    private static final String pathToGameCards = "resources/img/cardsIMG/";
    public static final String iconIMG = pathToGameCards + "deck.jpg";
    public static final String zeroCard = pathToGameCards + "card_00.png";
    public static final String pathNatureCards = pathToGameCards + "nature/school_1_card_";
    public static final String pathFireCards = pathToGameCards + "fire/school_2_card_";
    public static final String pathEarthCards = pathToGameCards + "earth/school_3_card_";
    public static final String pathWaterCards = pathToGameCards + "water/school_4_card_";

    private static final String pathToResourcesIMG = "resources/img/resourcesIMG/";
    public static final String pathToEarthIMG = pathToResourcesIMG + "resource_3_earth.png";
    public static final String pathToFireIMG = pathToResourcesIMG + "resource_2_fire.png";
    public static final String pathToWaterIMG = pathToResourcesIMG + "resource_4_water.png";
    public static final String pathToNatureIMG = pathToResourcesIMG + "resource_1_nature.png";

    private static final String pathToBufsAndDebufsIMG = "resources/img/buffsAndDebuffsIMG/";
    public static final String pathToHealthRestoreActive = pathToBufsAndDebufsIMG + "param_icon_1_active.jpg";
    public static final String pathToHealthRestoreInActive = pathToBufsAndDebufsIMG + "param_icon_1_inactive.jpg";
    public static final String pathToReflectActive = pathToBufsAndDebufsIMG + "param_icon_2_active.jpg";
    public static final String pathToReflectInActive = pathToBufsAndDebufsIMG + "param_icon_2_inactive.jpg";
    public static final String pathToIsPoisonedActive = pathToBufsAndDebufsIMG + "param_icon_4_active.jpg";
    public static final String pathToIsPoisonedInActive = pathToBufsAndDebufsIMG + "param_icon_4_inactive.jpg";
    public static final String pathToIsFreezedActive = pathToBufsAndDebufsIMG + "param_icon_3_active.jpg";
    public static final String pathToIsFreezedInActive = pathToBufsAndDebufsIMG + "param_icon_3_inactive.jpg";
}
