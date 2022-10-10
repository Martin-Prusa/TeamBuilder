package cz.martin.services;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TeamService {

    public List<List<String>> generateTeams(String[] players, int numberOfTeams) {
        List<List<String>> list = new ArrayList<>();
        int playersInTeam = players.length / numberOfTeams;
        for (int i = 0; i < numberOfTeams; i++) {
            list.add(new ArrayList<String>());
            for (int j = 0; j < playersInTeam; j++) {
                list.get(i).add(players[i*playersInTeam + j].trim());
            }
        }
        return list;
    }

}
