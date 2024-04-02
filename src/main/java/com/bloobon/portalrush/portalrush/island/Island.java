package com.bloobon.portalrush.portalrush.island;

import com.bloobon.portalrush.portalrush.crystal.Crystal;
import com.bloobon.portalrush.portalrush.npcs.Engineer;
import com.bloobon.portalrush.portalrush.npcs.ItemShopKeeper;
import com.bloobon.portalrush.portalrush.npcs.UpgradeShopKeeper;
import com.bloobon.portalrush.portalrush.generator.IslandGenerator;
import com.bloobon.portalrush.portalrush.teams.Team;
import com.bloobon.portalrush.portalrush.teleporter.Teleporter;
import lombok.NonNull;
import org.bukkit.Location;

public record Island(@NonNull Team team, @NonNull IslandGenerator ironGenerator, @NonNull IslandGenerator goldGenerator, @NonNull Engineer engineer, @NonNull
                     ItemShopKeeper itemShopKeeper, @NonNull UpgradeShopKeeper upgradeShopKeeper, @NonNull Teleporter teleporter, @NonNull Crystal crystal, @NonNull
                     Location playerSpawn) {

}
