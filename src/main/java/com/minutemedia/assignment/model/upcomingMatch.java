package com.minutemedia.assignment.model;

public class upcomingMatch extends Match {

    private String kickoffTime;

    public upcomingMatch(String homeTeam, String awayTeam, String tournament, String startTime, String kickoffTime) {
        super(MatchStatus.UPCOMING, homeTeam, awayTeam, tournament, startTime);
        this.kickoffTime = kickoffTime;
    }

}
