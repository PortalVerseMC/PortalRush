package com.bloobon.portalrush.portalrush.listeners;

import com.bloobon.portalrush.portalrush.PortalRush;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@RequiredArgsConstructor
public class ConnectionListener implements Listener {

    private final PortalRush portalRush;

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        portalRush.getGameManager().getPlayerManager().addActivePlayer(event.getPlayer());
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        portalRush.getGameManager().getPlayerManager().removeActivePlayer(event.getPlayer());
    }
}
