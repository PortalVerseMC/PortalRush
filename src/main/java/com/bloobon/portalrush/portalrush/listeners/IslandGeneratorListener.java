package com.bloobon.portalrush.portalrush.listeners;

import com.bloobon.portalrush.portalrush.npcs.ItemShopKeeper;
import com.bloobon.portalrush.portalrush.utils.NPCUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class IslandGeneratorListener implements Listener {

    //TODO Test code
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (event.getMessage().equals("generate npc pls")) {
            ItemShopKeeper shopKeeper = new ItemShopKeeper(event.getPlayer(), event.getPlayer().getLocation());
            NPCUtil.registerNPC(shopKeeper.getEntityId(), shopKeeper);
            for (Player player : Bukkit.getOnlinePlayers()) {
                shopKeeper.spawnFor(player);
            }
        }
    }
}
