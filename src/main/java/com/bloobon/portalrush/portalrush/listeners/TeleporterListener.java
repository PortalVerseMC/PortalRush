package com.bloobon.portalrush.portalrush.listeners;

import com.bloobon.portalrush.portalrush.PortalRush;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public class TeleporterListener implements Listener {


    private final @NotNull PortalRush portalRush;

    @EventHandler
    public void onPortalEnter(PlayerPortalEvent event){

        Player player = event.getPlayer();
    }
}
