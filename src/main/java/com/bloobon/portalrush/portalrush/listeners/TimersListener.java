package com.bloobon.portalrush.portalrush.listeners;

import com.bloobon.portalrush.portalrush.events.CountdownFinishedEvent;
import com.bloobon.portalrush.portalrush.gamestates.LiveState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TimersListener implements Listener {

    @EventHandler
    public void onCountdownFinish(CountdownFinishedEvent e){
        e.getGameManager().getStateManager().changeState(new LiveState(e.getGameManager()));
    }
}
