package com.bloobon.portalrush.portalrush.island;

import com.bloobon.portalrush.portalrush.crystal.Crystal;
import com.bloobon.portalrush.portalrush.npcs.Engineer;
import com.bloobon.portalrush.portalrush.npcs.ItemShopKeeper;
import com.bloobon.portalrush.portalrush.npcs.UpgradeShopKeeper;
import com.bloobon.portalrush.portalrush.generator.IslandGenerator;
import com.bloobon.portalrush.portalrush.teams.Team;
import com.bloobon.portalrush.portalrush.teleporter.Teleporter;
import lombok.Getter;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Getter
public class IslandBuilder {
    private final Team team;
    private IslandGenerator ironGenerator;
    private IslandGenerator goldGenerator;
    private Engineer engineer;
    private ItemShopKeeper itemShopKeeper;
    private UpgradeShopKeeper upgradeShopKeeper;
    private Teleporter teleporter;
    private Location playerSpawn;
    private Crystal crystal;

    public IslandBuilder(@NotNull Team team) {
        this.team = team;
    }

    public IslandBuilder withIronGenerator(@NotNull IslandGenerator ironGenerator) {
        this.ironGenerator = ironGenerator;
        return this;
    }

    public IslandBuilder withGoldGenerator(@NotNull IslandGenerator goldGenerator) {
        this.goldGenerator = goldGenerator;
        return this;
    }

    public IslandBuilder withEngineer(@NotNull Engineer engineer) {
        this.engineer = engineer;
        return this;
    }

    public IslandBuilder withPlayerSpawn(@NotNull Location playerSpawn){
        this.playerSpawn = playerSpawn;
        return this;
    }

    public IslandBuilder withItemShopKeeper(@NotNull ItemShopKeeper itemShopKeeper) {
        this.itemShopKeeper = itemShopKeeper;
        return this;
    }

    public IslandBuilder withUpgradeShopKeeper(@NotNull UpgradeShopKeeper upgradeShopKeeper) {
        this.upgradeShopKeeper = upgradeShopKeeper;
        return this;
    }

    public IslandBuilder withTeleporter(@NotNull Teleporter Teleporter) {
        this.teleporter = teleporter;
        return this;
    }

    public IslandBuilder withCrystal(@NotNull Crystal crystal) {
        this.crystal = crystal;
        return this;
    }

    public Island build() {

        Objects.requireNonNull(ironGenerator, "Iron Generator must be set");
        Objects.requireNonNull(goldGenerator, "Gold Generator must be set");
        Objects.requireNonNull(engineer, "Engineer must be set");
        Objects.requireNonNull(itemShopKeeper, "Item ShopKeeper must be set");
        Objects.requireNonNull(upgradeShopKeeper, "Upgrade ShopKeeper must be set");
        Objects.requireNonNull(teleporter, "Big Teleporter must be set");
        Objects.requireNonNull(playerSpawn, "Player Spawn must be set");
        Objects.requireNonNull(crystal, "Crystal must be set");

        return new Island(team, ironGenerator, goldGenerator, engineer, itemShopKeeper,
                upgradeShopKeeper, teleporter, crystal, playerSpawn);
    }
}
