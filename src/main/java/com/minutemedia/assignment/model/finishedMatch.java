package com.minutemedia.assignment.model;

public class FinishedMatch extends Match {

    private int homeScore;
    private int awayScore;

    public FinishedMatch(String homeTeam, String awayTeam, String tournament,
                         String startTime, int homeScore, int awayScore) {
        super(MatchStatus.PLAYED, homeTeam, awayTeam, tournament, startTime);
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

}
