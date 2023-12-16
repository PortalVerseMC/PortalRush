package com.bloobon.portalrush.portalrush.managers.upgrades;


import com.bloobon.portalrush.portalrush.type.Type;

/**
 * Cache that holds all the values for each level in an Upgrade.
 *
 *
 * @param <T> Enum representing the Upgrade
 * @param <V> Type of object the Map offers
 */
public interface UpgradeCache<T extends Type, V> {

    V getValueOfLevel(T type, int level);

}
