package com.minutemedia.assignment.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.minutemedia.assignment.DataStore;
import com.minutemedia.assignment.exceptions.InvalidStatusException;
import com.minutemedia.assignment.exceptions.TeamNotFoundException;
import com.minutemedia.assignment.exceptions.TournamentNotFoundException;
import com.minutemedia.assignment.model.Match;
import com.minutemedia.assignment.model.MatchStatus;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class MatchController {

    private static DataStore data = DataStore.getInstance();

    @RequestMapping("/team")
    public List<Match> TeamMatches(@RequestParam(value="name") String name) throws TeamNotFoundException {
        List<Match> result = data.getTeamMatches(name);
        if (result==null) throw new TeamNotFoundException(name);
        return result;
    }

    @GetMapping("/team/{status}")
    public List<Match> TeamMatchesByStatus(@RequestParam(value="name") String name, @PathVariable String status) throws TeamNotFoundException, InvalidStatusException {
        if (!(status.equalsIgnoreCase(MatchStatus.PLAYED.toString()) || status.equalsIgnoreCase(MatchStatus.UPCOMING.toString())))
            throw new InvalidStatusException("Invalid status");
        List<Match> filterResult = data.getTeamMatches(name);
        if (filterResult==null) throw new TeamNotFoundException(name);
        return filterResult.stream()
                .filter(match -> match.getStatus().toString().equals(status.toUpperCase()))
                .collect(Collectors.toList());
    }

    @GetMapping("/tournament")
    public List<Match> TournamentMatches(@RequestParam(value="name") String name) throws TournamentNotFoundException {
        List<Match> result = data.getTournamentMatches(name);
        if (result==null) throw new TournamentNotFoundException(name);
        return result;
    }

    @GetMapping("/tournament/{status}")
    public List<Match> TournamentMatchesByStatus(@RequestParam(value="name") String name, @PathVariable String status) throws TournamentNotFoundException, InvalidStatusException {
        if (!(status.equalsIgnoreCase(MatchStatus.PLAYED.toString()) || status.equalsIgnoreCase(MatchStatus.UPCOMING.toString())))
            throw new InvalidStatusException(status);
        List<Match> filterResult = data.getTournamentMatches(name);
        if (filterResult==null) throw new TournamentNotFoundException(name);
        return filterResult.stream()
                .filter(match -> match.getStatus().toString().equals(status.toUpperCase()))
                .collect(Collectors.toList());
    }

}