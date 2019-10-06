package com.minutemedia.assignment.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.minutemedia.assignment.DataStore;
import com.minutemedia.assignment.model.Match;
import com.minutemedia.assignment.model.MatchStatus;
import com.minutemedia.assignment.app.InvalidStatusException;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class MatchController {

    private static DataStore data = DataStore.getInstance();

    @RequestMapping("/team")
    public List<Match> TeamMatches(@RequestParam(value="name") String name) {
        return data.getTeamMatches(name);
    }

    @GetMapping("/team/{status}")
    public List<Match> TeamMatchesByStatus(@RequestParam(value="name") String name, @PathVariable String status) throws InvalidStatusException {
        if (!(status.equalsIgnoreCase(MatchStatus.PLAYED.toString()) || status.equalsIgnoreCase(MatchStatus.UPCOMING.toString())))
            throw new InvalidStatusException("\nInvalid status. Only 'upgoing' and 'played' are valid status");
        return data.getTeamMatches(name).stream()
                .filter(match -> match.getStatus().toString().equals(status.toUpperCase()))
                .collect(Collectors.toList());
    }

    @GetMapping("/tournament")
    public List<Match> TournamentMatches(@RequestParam(value="name") String name) {
        return data.getTournamentMatches(name);
    }

    @GetMapping("/tournament/{status}")
    public List<Match> TournamentMatchesByStatus(@RequestParam(value="name") String name, @PathVariable String status) throws InvalidStatusException{
        if (!(status.equalsIgnoreCase(MatchStatus.PLAYED.toString()) || status.equalsIgnoreCase(MatchStatus.UPCOMING.toString())))
            throw new InvalidStatusException("Invalid status. Only 'upgoing' and 'played' are valid");
        return data.getTournamentMatches(name).stream()
                .filter(match -> match.getStatus().toString().equals(status.toUpperCase()))
                .collect(Collectors.toList());
    }

}

