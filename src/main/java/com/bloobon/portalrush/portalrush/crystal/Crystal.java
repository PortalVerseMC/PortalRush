package com.bloobon.portalrush.portalrush.crystal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.EnderCrystal;

@RequiredArgsConstructor
@Getter
public class Crystal {

    private final EnderCrystal enderCrystal;
    private final Location location;
    private int health;
}
