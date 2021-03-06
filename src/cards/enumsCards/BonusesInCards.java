package cards.enumsCards;

/**
 * Describe all bonuses on cards
 *
 * Created by sserdiuk on 7/3/17.
 */
public enum BonusesInCards {
    ARMOR_ADD_MY_SELF,
//    ARMOR_DESTROY_MY_SELF,
    ATTACK_ADD_MY_SELF,
//    ATTACK_DECREASE_MY_SELF,

    ARMOR_ADD_FOR_ENEMY,
    ARMOR_DESTROY_FOR_ENEMY,
    ATTACK_ADD_FOR_ENEMY,
    ATTACK_DECRASE_MY_ENEMY,

    IGNORE_ARMOR,
    FREEZE_ENEMY,
    POISON_ENEMY,
    CURSE_ENEMY,
    DISARM_ENEMY,
    DISPEL_MY_SELF,
    POISONED_CHARACTER,
    REGENERATION,
    REFLECT,

    BUILD_TEMPLE_EARTH_MY_SELF,
    BUILD_TEMPLE_FIRE_MY_SELF,
    BUILD_TEMPLE_WATER_MY_SELF,
    BUILD_TEMPLE_NATURE_MY_SELF,
    BUILD_TEMPLE_ALL_MY_SELF,

//    instead Destroy TEMPLE, we will set "-1" in Build Temple, For Example
//    DESTROY_TEMPLE_EARTH_ENEMY,
//    DESTROY_TEMPLE_FIRE_ENEMY,
//    DESTROY_TEMPLE_WATER_ENEMY,
//    DESTROY_TEMPLE_NATURE_ENEMY,
//    DESTROY_TEMPLE_ALL_ENEMY,

    RESOURCE_WATER,
    RESOURCE_EARTH,
    RESOURCE_NATURE,
    RESOURCE_FIRE,
    RESOURCE_ALL,

    RESOURCE_REMOVE_FROM_ENEMY,
    RESOURCE_STEEL_ENEMY,
    REGENERATION_MY_SELF,
    ADD_HEALTH,
    REMOVE_POISON_MY_SELF,

    ADD_RESOURCES_FOR_ENEMY,
    ADD_HEALTH_FOR_ENEMY,
    REGENERATION_FOR_ENEMY
}
