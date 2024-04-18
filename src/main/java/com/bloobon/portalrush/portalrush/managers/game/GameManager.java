package com.bloobon.portalrush.portalrush.managers.game;

import com.bloobon.portalrush.portalrush.gamestates.GameState;
import com.bloobon.portalrush.portalrush.gamestates.ShutdownState;
import com.bloobon.portalrush.portalrush.managers.island.IslandManager;
import com.bloobon.portalrush.portalrush.managers.lobby.LobbyManager;
import com.bloobon.portalrush.portalrush.managers.players.PlayerManager;
import com.bloobon.portalrush.portalrush.managers.states.StateManager;
import com.bloobon.portalrush.portalrush.teams.TeamManager;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
public class GameManager {


    @Setter
    private @NotNull GameState state;
    private final PlayerManager playerManager = new PlayerManager();
    private final StateManager stateManager = new StateManager(this);
    private final TeamManager teamManager = new TeamManager();
    private final IslandManager islandManager = new IslandManager();
    private final LobbyManager lobbyManager = new LobbyManager();

    public GameManager(){
        //TODO Why is the shutdown state fired in the beginning?
        stateManager.changeState(new ShutdownState(this));

    }


}
