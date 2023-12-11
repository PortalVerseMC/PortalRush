package com.bloobon.portalrush.portalrush.managers.game;

import com.bloobon.portalrush.portalrush.managers.players.PlayerManager;

public class GameManager {

    private GameState state;
    private final PlayerManager playerManager = new PlayerManager();

    public GameManager(){
        this.state = GameState.SHUTDOWN;
    }
}
