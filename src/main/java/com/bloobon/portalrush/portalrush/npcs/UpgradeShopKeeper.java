package com.bloobon.portalrush.portalrush.npcs;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

@RequiredArgsConstructor
@Getter
public class UpgradeShopKeeper implements NPC {

    private final Location location;
    private final Entity entity;
}