package com.bloobon.portalrush.portalrush.island;

import com.bloobon.portalrush.portalrush.crystal.Crystal;
import com.bloobon.portalrush.portalrush.npcs.Engineer;
import com.bloobon.portalrush.portalrush.npcs.ItemShopKeeper;
import com.bloobon.portalrush.portalrush.npcs.UpgradeShopKeeper;
import com.bloobon.portalrush.portalrush.generator.IslandGenerator;
import com.bloobon.portalrush.portalrush.teams.Team;
import com.bloobon.portalrush.portalrush.teleporter.Teleporter;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

public record Island(@NonNull Team team,@NonNull IslandGenerator ironGenerator,@NonNull IslandGenerator goldGenerator,@NonNull Engineer engineer,@NonNull
                     ItemShopKeeper itemShopKeeper,@NonNull UpgradeShopKeeper upgradeShopKeeper,@NonNull Teleporter smallTeleporter,@NonNull
                     Teleporter bigTeleporter,@NonNull Crystal crystal) {

}
