package com.bloobon.portalrush.portalrush.upgrades;

import com.bloobon.portalrush.portalrush.managers.upgrades.UpgradeCache;

public interface Upgrade {

    int getLevel();
    void addLevel();
    int getMaxLevel();
}
