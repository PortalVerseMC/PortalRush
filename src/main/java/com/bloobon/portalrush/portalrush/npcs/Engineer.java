package com.bloobon.portalrush.portalrush.npcs;

import com.bloobon.portalrush.portalrush.island.Island;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;


@RequiredArgsConstructor
@Getter
public class Engineer implements NPC {

    private final Location location;
    private final Entity entity;
    private final Island island;

}
