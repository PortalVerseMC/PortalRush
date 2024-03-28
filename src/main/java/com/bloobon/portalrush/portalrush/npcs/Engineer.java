package com.bloobon.portalrush.portalrush.npcs;

import com.bloobon.portalrush.portalrush.island.Island;
import io.github.retrooper.packetevents.util.SpigotReflectionUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;


@Getter
public class Engineer extends NPCVillager implements IslandSpecificNPC {
    private final Island island;

    public Engineer(Player entity, Location location, Island island) {
        super(entity, location, Component.text("Engineer").color(NamedTextColor.GREEN));
        this.island = island;
    }

    @Override
    public void handleLeftClick(Player player) {

    }

    @Override
    public void handleRightClick(Player player) {

    }
}
