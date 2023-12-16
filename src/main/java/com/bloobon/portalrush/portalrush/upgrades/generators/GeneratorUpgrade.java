package com.bloobon.portalrush.portalrush.upgrades.generators;

import com.bloobon.portalrush.portalrush.type.GeneratorType;
import com.bloobon.portalrush.portalrush.upgrades.Upgrade;

public interface GeneratorUpgrade extends Upgrade {

    int getCurrentInterval();
    int getInterval(int level);

    GeneratorType getGeneratorType();
}
