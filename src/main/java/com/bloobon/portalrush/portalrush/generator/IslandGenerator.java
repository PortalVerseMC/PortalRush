package com.bloobon.portalrush.portalrush.generator;

import com.bloobon.portalrush.region.CuboidRegion;
import lombok.Getter;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

@Getter
public class IslandGenerator extends AbstractGenerator {


    private final CuboidRegion cuboidRegion;

    public IslandGenerator(@NotNull GeneratorType generatorType, @NotNull Location location, @NotNull CuboidRegion cuboidRegion, int interval) {
        super(generatorType, location, interval);
        this.cuboidRegion = cuboidRegion;
    }
}
