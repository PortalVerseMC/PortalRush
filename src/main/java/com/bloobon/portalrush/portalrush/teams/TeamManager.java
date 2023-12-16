package com.bloobon.portalrush.portalrush.teams;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class TeamManager {

    private final List<Team> teams = new ArrayList<>();

    public List<Team> aliveTeams(){
        return teams.stream().filter(team-> team.alivePlayerCount()>0 && team.hasAliveCrystal()).collect(Collectors.toList());
    }

    public TeamManager(){
        //TODO Set up correctly with config
        setup();
    }

    public int aliveTeamsCount(){
        return teams.size();
    }

    public void addTeam(@NotNull Team team){
        teams.add(team);
    }

    public void setup(){
        teams.add(new Team(TeamColor.BLUE));
        teams.add(new Team(TeamColor.RED));
    }

    public Optional<Team> getTeamOfPlayer(@NotNull Player player){
        for(Team team :teams){
            if(team.getPlayers().contains(player)) return Optional.of(team);
        }
        return Optional.empty();
    }

}
