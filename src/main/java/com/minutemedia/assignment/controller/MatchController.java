package com.minutemedia.assignment.controller;

import com.minutemedia.assignment.DataStore;
import com.minutemedia.assignment.exceptions.InvalidStatusException;
import com.minutemedia.assignment.exceptions.TeamNotFoundException;
import com.minutemedia.assignment.exceptions.TournamentNotFoundException;
import com.minutemedia.assignment.model.Match;
import com.minutemedia.assignment.model.MatchStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController("/")
public class MatchController {

    private static final DataStore DATA_STORE = DataStore.getInstance();

    @GetMapping("/team")
    public List<Match> getMatchesByTeam(@RequestParam(value = "name") String name) throws TeamNotFoundException {
        List<Match> result = DATA_STORE.getMatchesByTeam(name);
        if (result == null) throw new TeamNotFoundException();
        return result;
    }

    @GetMapping("/team/{status}")
    public List<Match> getMatchesByTeamAndStatus(@RequestParam(value = "name") String name, @PathVariable String status)
            throws TeamNotFoundException, InvalidStatusException {

        if (!(status.equalsIgnoreCase(MatchStatus.PLAYED.toString()) ||
                status.equalsIgnoreCase(MatchStatus.UPCOMING.toString()))) {
            throw new InvalidStatusException();
        }
        List<Match> filterResult = DATA_STORE.getMatchesByTeam(name);
        if (filterResult == null) throw new TeamNotFoundException();
        return filterResult.stream()
                .filter(match -> match.getStatus().toString().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    @GetMapping("/tournament")
    public List<Match> getMatchesByTournament(@RequestParam(value = "name") String name) throws TournamentNotFoundException {
        List<Match> result = DATA_STORE.getMatchesByTournament(name);
        if (result == null) throw new TournamentNotFoundException();
        return result;
    }

    @GetMapping("/tournament/{status}")
    public List<Match> getMatchesByTournamentAndStatus(@RequestParam(value = "name") String name, @PathVariable String status)
            throws TournamentNotFoundException, InvalidStatusException {

        if (!(status.equalsIgnoreCase(MatchStatus.PLAYED.toString()) ||
                status.equalsIgnoreCase(MatchStatus.UPCOMING.toString())))
            throw new InvalidStatusException();
        List<Match> filterResult = DATA_STORE.getMatchesByTournament(name);
        if (filterResult == null) throw new TournamentNotFoundException();
        return filterResult.stream()
                .filter(match -> match.getStatus().toString().equals(status.toUpperCase()))
                .collect(Collectors.toList());
    }
}