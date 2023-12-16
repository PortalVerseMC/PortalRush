package com.bloobon.portalrush.portalrush.generator;

import com.bloobon.portalrush.portalrush.type.GeneratorType;
import lombok.Getter;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

@Getter
public class IslandGenerator extends AbstractGenerator {

    //Once ores spawn, they will contain a namespacedkey. once picked up key will be cleared.

    public IslandGenerator(@NotNull GeneratorType generatorType, @NotNull Location location, int interval) {
        super(generatorType, location, interval);
    }

}
