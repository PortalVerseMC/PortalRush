package com.bloobon.portalrush.portalrush.managers.players;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private final List<Player> activePlayers = new ArrayList<>();
    private final List<Player> spectatorPlayers = new ArrayList<>();


    public void addActivePlayer(Player player){
        activePlayers.add(player);
    }

    public void addSpectatorPlayer(Player player){
        spectatorPlayers.add(player);
    }

    public void removeActivePlayer(Player player){
        activePlayers.remove(player);
    }

    public void removeSpectatorPlayer(Player player){
        spectatorPlayers.remove(player);
    }

    public List<Player> getActivePlayers() {
        return activePlayers;
    }

    public List<Player> getSpectatorPlayers() {
        return spectatorPlayers;
    }
}
