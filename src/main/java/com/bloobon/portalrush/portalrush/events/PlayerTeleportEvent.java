package com.bloobon.portalrush.portalrush.events;

import com.bloobon.portalrush.portalrush.teleporter.Teleporter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public class PlayerTeleportEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final Teleporter teleporter;
    private final Player player;

    //Allazw thn 2

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
