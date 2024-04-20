package com.bloobon.portalrush.portalrush.gamestates;

import com.bloobon.portalrush.portalrush.island.Island;
import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import com.bloobon.portalrush.portalrush.teams.Team;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LiveState extends GameState {
    public LiveState(@NotNull GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public void onSet() {
        //Teleport all players to their islands.
        for (Island island : gameManager.getIslandManager().getIslands()) {
            Team team = island.team();
            for (Player player : team.getPlayers()) {
                //TODO retrooper Confirm this is the right location
                player.teleport(island.bigTeleporter().getLocationTo());
            }
        }

    }
}
