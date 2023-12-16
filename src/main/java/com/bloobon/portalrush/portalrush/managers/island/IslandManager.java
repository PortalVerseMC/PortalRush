package com.bloobon.portalrush.portalrush.managers.island;

import com.bloobon.portalrush.portalrush.island.Island;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class IslandManager {

    private final List<Island> islands = new ArrayList<>();

    public void addIsland(@NotNull Island island) {
        islands.add(island);
    }

}
