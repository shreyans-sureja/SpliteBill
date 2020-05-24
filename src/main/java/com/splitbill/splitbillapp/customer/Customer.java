package com.splitbill.splitbillapp.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.splitbill.splitbillapp.team.Team;
import com.splitbill.splitbillapp.teamTransaction.TeamTransaction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    private String id;

    @NotNull
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String password;

    @ManyToMany(mappedBy = "customers")
    private List<Team> teams = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<TeamTransaction> teamTransactions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Customer() {
    }

    public Customer(String id, @NotNull String name, @NotNull String password, List<Team> teams, List<TeamTransaction> teamTransactions) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.teams = teams;
        this.teamTransactions = teamTransactions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<TeamTransaction> getTeamTransactions() {
        return teamTransactions;
    }

    public void setTeamTransactions(List<TeamTransaction> teamTransactions) {
        this.teamTransactions = teamTransactions;
    }



}
