package com.minutemedia.assignment.model;

public class Match {
    private MatchStatus status;
    private String homeTeam;
    private String awayTeam;
    private String tournament;
    private String startTime;

    Match(MatchStatus status, String homeTeam, String awayTeam, String tournament, String startTime) {
        this.status = status;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.tournament = tournament;
        this.startTime = startTime;
    }

    public MatchStatus getStatus() {
        return status;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getTournament() {
        return tournament;
    }

    public String getStartTime() {
        return startTime;
    }
}
