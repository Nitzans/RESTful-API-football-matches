package com.minutemedia.assignment;

import com.minutemedia.assignment.model.Match;
import com.minutemedia.assignment.model.FinishedMatch;
import com.minutemedia.assignment.model.UpcomingMatch;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataStore {
    private static final String UPCOMING_FILE_PATH = "src/main/resources/result_upcoming.csv";
    private static final String PLAYED_FILE_PATH = "src/main/resources/result_played.csv";
    private Map<String, List<Match>> matchesByTeam = new HashMap<>();
    private Map<String, List<Match>> matchesByTournament = new HashMap<>();
    private static DataStore instance = new DataStore();
    public static DataStore getInstance(){
        return instance;
    }

    private DataStore(){
        BufferedReader reader1 = null; //reading from result_upcoming.csv
        BufferedReader reader2 = null; //reading from result_played.csv
        String line;

        try {
            reader1 = new BufferedReader(new FileReader(UPCOMING_FILE_PATH));
            reader2 = new BufferedReader(new FileReader(PLAYED_FILE_PATH));

            reader1.readLine();
            while ((line = reader1.readLine()) != null) {
                String[] match = line.split(",");
                addUpcomingMatchToMap(match);
            }
            reader2.readLine();
            while ((line = reader2.readLine()) != null) {
                String[] match = line.split(",");
                addFinishedMatchToMap(match);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader1 != null && reader2 != null) {
                try {
                    reader1.close();
                    reader2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Match> getMatchesByTeam(String teamName){
        return matchesByTeam.get(teamName);
    }

    public List<Match> getMatchesByTournament(String tournamentName) {
        return matchesByTournament.get(tournamentName);
    }

    private void addUpcomingMatchToMap(String[] match){
        addUpcomingMatchToHomeTeamList(match);
        addUpcomingMatchToGuestTeamList(match);
        addUpcomingMatchToTournamentList(match);
    }

    private void addFinishedMatchToMap(String[] match){
        addFinishedMatchToHomeTeamList(match);
        addFinishedMatchToGuestTeamList(match);
        addFinishedMatchToTournamentList(match);
    }

    private void addUpcomingMatchToHomeTeamList(String[] match){
        if (!matchesByTeam.containsKey(match[0])){
            matchesByTeam.put(match[0], new LinkedList<>());
        }
        matchesByTeam.get(match[0]).add(new UpcomingMatch(match[0], match[1], match[2], match[3], match[4]));
    }

    private void addUpcomingMatchToGuestTeamList(String[] match) {
        if (!matchesByTeam.containsKey(match[1])) {
            matchesByTeam.put(match[1], new LinkedList<>());
        }
        matchesByTeam.get(match[1]).add(new UpcomingMatch(match[0], match[1], match[2], match[3], match[4]));
    }

    private void addUpcomingMatchToTournamentList(String[] match){
        if (!matchesByTournament.containsKey(match[2])){
            matchesByTournament.put(match[2], new LinkedList<>());
        }
        matchesByTournament.get(match[2]).add(new UpcomingMatch(match[0], match[1], match[2], match[3], match[4]));
    }

    private void addFinishedMatchToHomeTeamList(String[] match){
        if (!matchesByTeam.containsKey(match[0])){
            matchesByTeam.put(match[0], new LinkedList<>());
        }
        matchesByTeam.get(match[0]).add(new FinishedMatch(match[0], match[2], match[4], match[5],
                Integer.valueOf(match[1]), Integer.valueOf(match[3])));
    }

    private void addFinishedMatchToGuestTeamList(String[] match){
        if (!matchesByTeam.containsKey(match[2])){
            matchesByTeam.put(match[2], new LinkedList<>());
        }
        matchesByTeam.get(match[2]).add(new FinishedMatch(match[0], match[2], match[4], match[5],
                Integer.valueOf(match[1]), Integer.valueOf(match[3])));
    }

    private void addFinishedMatchToTournamentList(String[] match){
        if (!matchesByTournament.containsKey(match[4])){
            matchesByTournament.put(match[4], new LinkedList<>());
        }
        matchesByTournament.get(match[4]).add(new FinishedMatch(match[0], match[2], match[4], match[5],
                Integer.valueOf(match[1]), Integer.valueOf(match[3])));
    }

}
