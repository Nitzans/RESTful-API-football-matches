package com.minutemedia.assignment.model;

public class UpcomingMatch extends Match {

    private String kickoffTime;

    public UpcomingMatch(String homeTeam, String awayTeam, String tournament, String startTime, String kickoffTime) {
        super(MatchStatus.UPCOMING, homeTeam, awayTeam, tournament, startTime);
        this.kickoffTime = kickoffTime;
    }

    public String getKickoffTime() {
        return kickoffTime;
    }
}
