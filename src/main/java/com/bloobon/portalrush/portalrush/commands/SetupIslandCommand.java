package com.bloobon.portalrush.portalrush.commands;

import com.bloobon.portalrush.portalrush.PortalRush;
import com.bloobon.portalrush.portalrush.gamestates.ShutdownState;
import com.bloobon.portalrush.portalrush.utils.SetupItems;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public class SetupIslandCommand implements SubCommand{

    private final PortalRush portalRush;
    @Override
    public void onCommand(@NotNull Player player, @NotNull String[] args) {
        if(!(portalRush.getGameManager().getState() instanceof ShutdownState)) return;
        Inventory inventory = player.getInventory();
        inventory.setItem(0, SetupItems.SETUP_SHOPKEEPER);
        inventory.setItem(1, SetupItems.SETUP_UPGRADEKEEPER);
        inventory.setItem(2, SetupItems.SETUP_ENGINEER);
        inventory.setItem(3, SetupItems.SETUP_ISLAND_GENERATOR);
        inventory.setItem(4, SetupItems.SETUP_PORTAL);
        inventory.setItem(5, SetupItems.SETUP_SPAWN_LOCATIONS);
        inventory.setItem(6, SetupItems.SETUP_CRYSTAL);
    }

    @Override
    public String getName() {
        return "setup";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }
}
