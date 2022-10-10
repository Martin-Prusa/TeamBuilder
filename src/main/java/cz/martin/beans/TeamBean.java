package cz.martin.beans;

import cz.martin.services.TeamService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named("team")
@RequestScoped
public class TeamBean {

    @Inject
    private TeamService teamService;

    private boolean showError = false;

    private int numberOfTeams = 0;
    private String players = "";
    private List<List<String>> teams = new ArrayList<>();

    public void generateTeams() {
        String[] playersArr = players.split(",");
        if(numberOfTeams <= 0 || playersArr.length % numberOfTeams != 0) {
            this.showError = true;
            return;
        }
        this.showError = false;
        teams = teamService.generateTeams(players.split(","), numberOfTeams);
    }

    public boolean isShowError() {
        return showError;
    }

    public boolean isShowTeams() {
        return !showError && teams.size() != 0;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public List<List<String>> getTeams() {
        return teams;
    }
}
