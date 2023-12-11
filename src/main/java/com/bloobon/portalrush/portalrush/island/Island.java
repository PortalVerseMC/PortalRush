package com.bloobon.portalrush.portalrush.island;

import com.bloobon.portalrush.portalrush.npcs.Engineer;
import com.bloobon.portalrush.portalrush.npcs.ItemShopKeeper;
import com.bloobon.portalrush.portalrush.npcs.UpgradeShopKeeper;
import com.bloobon.portalrush.portalrush.generator.IslandGenerator;
import com.bloobon.portalrush.portalrush.teams.TeamColor;
import com.bloobon.portalrush.portalrush.teleporter.Teleporter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Island {

    private final TeamColor teamColor;
    private final IslandGenerator ironGenerator;
    private final IslandGenerator goldGenerator;
    private final Engineer engineer;
    private final ItemShopKeeper itemShopKeeper;
    private final UpgradeShopKeeper upgradeShopKeeper;
    private final Teleporter smallTeleporter;
    private final Teleporter bigTeleporter;


}
