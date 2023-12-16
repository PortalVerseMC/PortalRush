package com.bloobon.portalrush.portalrush.teams;

import com.bloobon.portalrush.portalrush.PortalRush;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class Team {

    private static final int maxPlayers = 1;
    @Getter
    private final @NotNull TeamColor color;
    @Getter
    private final List<Player> players = new ArrayList<>();
    private boolean aliveCrystal;

    public void addPlayer(@NotNull Player player){
        players.add(player);
    }

    public void removePlayer(@NotNull Player player){
        players.remove(player);
    }

    public boolean hasAliveCrystal(){
        return aliveCrystal;
    }


    public int alivePlayerCount(){
        return Math.toIntExact(players.stream().filter(player -> player.getGameMode() != GameMode.SPECTATOR).count());
    }

}
