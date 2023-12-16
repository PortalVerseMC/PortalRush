package com.bloobon.portalrush.portalrush.commands;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface SubCommand {

    void onCommand(@NotNull Player player,@NotNull String[] args);
    String getName();
    String[] getAliases();
}
