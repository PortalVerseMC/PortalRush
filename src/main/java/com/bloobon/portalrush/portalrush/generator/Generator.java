package com.bloobon.portalrush.portalrush.generator;


import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public class Generator extends AbstractGenerator{


    public Generator(@NotNull GeneratorType generatorType,@NotNull Location location, int interval) {
        super(generatorType, location, interval);
    }
}
