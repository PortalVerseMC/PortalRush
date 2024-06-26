package com.bloobon.portalrush.portalrush.teleporter;

import com.bloobon.portalrush.region.CuboidRegion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Getter
public class Teleporter {

    private final @NotNull Location locationTo;
    private final @NotNull CuboidRegion cuboidRegion;
    private boolean isActive;


}
