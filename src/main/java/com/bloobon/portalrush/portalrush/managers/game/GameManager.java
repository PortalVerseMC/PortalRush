package com.bloobon.portalrush.portalrush.managers.game;

import com.bloobon.portalrush.portalrush.managers.players.PlayerManager;
import com.bloobon.portalrush.portalrush.managers.states.StateManager;
import lombok.Getter;

public class GameManager {

    @Getter
    private GameState state;
    private final PlayerManager playerManager = new PlayerManager();
    private final StateManager stateManager = new StateManager(this);


    //TODO put state in StateManager and only allow state changing through there.
    public GameManager(){
        this.state = GameState.SHUTDOWN;
    }



}
