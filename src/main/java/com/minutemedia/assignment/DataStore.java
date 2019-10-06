package com.minutemedia.assignment;

import com.minutemedia.assignment.model.Match;
import com.minutemedia.assignment.model.finishedMatch;
import com.minutemedia.assignment.model.upcomingMatch;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataStore {
    private final String upcomingFilePath = "src/main/resources/result_upcoming.csv";
    private final String playedFilePath = "src/main/resources/result_played.csv";
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
            reader1 = new BufferedReader(new FileReader(upcomingFilePath));
            reader2 = new BufferedReader(new FileReader(playedFilePath));

            reader1.readLine();
            while ((line = reader1.readLine()) != null) {
                String[] match = line.split(",");
                AddUpcomingMatch(match);
            }
            reader2.readLine();
            while ((line = reader2.readLine()) != null) {
                String[] match = line.split(",");
                AddFinishedMatch(match);
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

    private void AddUpcomingMatch(String[] match){
        if (!matchesByTeam.containsKey(match[0])){
            matchesByTeam.put(match[0], new LinkedList<>());
        }
        matchesByTeam.get(match[0]).add(new upcomingMatch(match[0], match[1], match[2], match[3], match[4]));

        if (!matchesByTeam.containsKey(match[1])){
            matchesByTeam.put(match[1], new LinkedList<>());
        }
        matchesByTeam.get(match[1]).add(new upcomingMatch(match[0], match[1], match[2], match[3], match[4]));

        if (!matchesByTournament.containsKey(match[2])){
            matchesByTournament.put(match[2], new LinkedList<>());
        }
        matchesByTournament.get(match[2]).add(new upcomingMatch(match[0], match[1], match[2], match[3], match[4]));
    }

    private void AddFinishedMatch(String[] match){
        if (!matchesByTeam.containsKey(match[0])){
            matchesByTeam.put(match[0], new LinkedList<>());
        }
        matchesByTeam.get(match[0]).add(new finishedMatch(match[0], match[2], match[4], match[5], Integer.valueOf(match[1]), Integer.valueOf(match[3])));

        if (!matchesByTeam.containsKey(match[2])){
            matchesByTeam.put(match[2], new LinkedList<>());
        }
        matchesByTeam.get(match[2]).add(new finishedMatch(match[0], match[2], match[4], match[5], Integer.valueOf(match[1]), Integer.valueOf(match[3])));

        if (!matchesByTournament.containsKey(match[4])){
            matchesByTournament.put(match[4], new LinkedList<>());
        }
        matchesByTournament.get(match[4]).add(new finishedMatch(match[0], match[2], match[4], match[5], Integer.valueOf(match[1]), Integer.valueOf(match[3])));
    }

    public List<Match> getTeamMatches(String teamName) {
        return matchesByTeam.get(teamName);
    }

    public List<Match> getTournamentMatches(String tournamentName) {
        return matchesByTournament.get(tournamentName);
    }

}
