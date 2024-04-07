package com.bloobon.portalrush.portalrush.gamestates;

import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class GameState {

    protected final GameManager gameManager;
    public abstract void onSet();
}
