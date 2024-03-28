package com.bloobon.portalrush.portalrush.npcs;


import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@Getter
public class UpgradeShopKeeper extends NPCVillager {
    public UpgradeShopKeeper(Player entity, Location location, Component name) {
        super(entity, location, Component.text("Upgrade Shop").color(NamedTextColor.GREEN));
    }

    @Override
    public void handleLeftClick(Player player) {

    }

    @Override
    public void handleRightClick(Player player) {

    }
}