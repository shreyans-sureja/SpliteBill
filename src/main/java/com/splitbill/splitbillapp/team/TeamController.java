package com.splitbill.splitbillapp.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping(value = "/teams/{id}")
    ResponseEntity<List<Team> > getAllTeams(@PathVariable String userId){
        return teamService.getAllTeams(userId);
    }

    @PostMapping(value = "/teams/{id}")
    ResponseEntity<Long> addTeam(@RequestBody Team newTeam, @PathVariable String userId){
        return teamService.addTeam(newTeam, userId);
    }

    @PostMapping(value = "/team/{id}")
    ResponseEntity<String> addTeamMembers(@PathVariable Long teamId,@RequestBody List<String> friends){
        return teamService.addTeamMembers(teamId,friends);
    }
}
