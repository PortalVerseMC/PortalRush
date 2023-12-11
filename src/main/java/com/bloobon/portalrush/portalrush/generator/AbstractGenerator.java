package com.bloobon.portalrush.portalrush.generator;

import com.bloobon.portalrush.portalrush.tasks.GeneratorTimer;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

@Getter

public abstract class AbstractGenerator {
    @Setter
    private int interval;
    private final GeneratorType generatorType;
    private final Location location;
    private boolean isActive;
    @Setter
    private GeneratorTimer generatorTimer;

    public AbstractGenerator(@NotNull GeneratorType generatorType,@NotNull Location location, int interval){
        this.generatorType = generatorType;
        this.location = location;
        this.interval = interval;
        isActive = false;
        generatorTimer = new GeneratorTimer(this);
    }
}
