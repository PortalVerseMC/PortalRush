package com.bloobon.portalrush.portalrush.teams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeamManager {

    private final List<Team> teams = new ArrayList<>();

    public List<Team> aliveTeams(){
        return teams.stream().filter(team-> team.alivePlayerCount()>0 && team.hasAliveCrystal()).collect(Collectors.toList());
    }

    public int aliveTeamsCount(){
        return teams.size();
    }

}
