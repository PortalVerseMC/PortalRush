package com.bloobon.portalrush.portalrush.type;


/**
 * This class is used to represent every enum that corresponds to an {@link com.bloobon.portalrush.portalrush.upgrades.Upgrade}
 *
 *
 * @param <T> Each enum holds an Object needed for its respective upgrade.
 *
 * @see GeneratorType
 */
public interface Type<T> {

    T getType();
}
