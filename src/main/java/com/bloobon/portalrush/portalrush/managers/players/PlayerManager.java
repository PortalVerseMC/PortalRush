package com.bloobon.portalrush.portalrush.managers.players;

import com.bloobon.portalrush.portalrush.PortalRush;
import com.bloobon.portalrush.portalrush.gamestates.CountdownState;
import com.bloobon.portalrush.portalrush.gamestates.DiamondUpgradeState;
import com.bloobon.portalrush.portalrush.gamestates.WaitingState;
import com.bloobon.portalrush.portalrush.island.Island;
import com.bloobon.portalrush.portalrush.managers.game.GameManager;
import com.bloobon.portalrush.portalrush.teams.Team;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PlayerManager {

    private final List<Player> activePlayers = new ArrayList<>();
    private final List<Player> spectatorPlayers = new ArrayList<>();

    private final int minPlayersRequired = 3;
    private final int maxPlayers = 6;
    private final int lobbyCountdown = 5;

    public static int FIRST_DIAMOND_UPGRADE = 2;
    public static int SECOND_DIAMOND_UPGRADE = 2;
    public static int FIRST_EMERALD_UPGRADE = 2;
    public static int SECOND_EMERALD_UPGRADE = 2;
    public static int CRYSTALS_DIE = 2;
    public static int END_GAME = 2;

    public void addActivePlayer(Player player) {
        GameManager gameManager = PortalRush.getInstance().getGameManager();
        //Check if the game is full
        if (activePlayers.size() + 1 <= getMaxPlayers()) {
            activePlayers.add(player);
            if (activePlayers.size() < getMaxPlayers()) {
                //We aren't enough players to start.
                //We are in the waiting state.
                if (!(gameManager.getState() instanceof WaitingState)) {
                    gameManager.getStateManager().changeState(new WaitingState(gameManager));
                }
                //Teleport player to the lobby
                player.teleport(gameManager.getLobbyManager().getToLocation());
            }
        } else {
            //Game is full.
            //TODO retrooper Rethink this, but for now we will kick them.
            player.kickPlayer("Game is full.");
        }

        //Start countdown once we reach minimum players
        if (activePlayers.size() == getMinPlayersRequired()) {
            //We may start a game.
            //Start countdown.
            if (gameManager.getState() instanceof WaitingState) {
                //After the countdown is over, we will teleport all players to their islands.
                int lobbyCountdown = gameManager.getPlayerManager().getLobbyCountdown();
                gameManager.getStateManager().changeState(new CountdownState(gameManager, lobbyCountdown, new BukkitRunnable() {
                    @Override
                    public void run() {
                        //Teleport all players to their islands.
                        for (Island island : gameManager.getIslandManager().getIslands()) {
                            Team team = island.team();
                            for (Player p : team.getPlayers()) {
                                //TODO retrooper Confirm this is the right location
                                p.teleport(island.teleporter().getLocationTo());
                            }
                        }

                        //After teleporting all players to their islands, we must start another countdown.
                        /**
                         * We fire the diamond upgrade countdown.
                         * The diamond upgrade state will fire itself again, representing the second upgrade.
                         * After that the emerald upgrade state will automatically be fired twice.
                         * Furthermore, the crystal die state will be fired, which will then fire the shutdown state.
                         */
                        gameManager.getStateManager().changeState(new DiamondUpgradeState(gameManager, FIRST_DIAMOND_UPGRADE));
                    }
                }));
            }
        }
    }

    public void addSpectatorPlayer(Player player) {
        spectatorPlayers.add(player);
    }

    public void removeActivePlayer(Player player) {
        activePlayers.remove(player);
    }

    public void removeSpectatorPlayer(Player player) {
        spectatorPlayers.remove(player);
    }

}
