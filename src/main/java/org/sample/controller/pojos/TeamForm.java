package org.sample.controller.pojos;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TeamForm{
    private String teamName;
    private long id;
    
    @NotNull
    @Pattern(regexp = "^(?=\\s*\\s).*$", message = "Enter a team name")
    
    public String getTeamName() {
        return teamName;
    }
    
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    public long getTimestamp() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
}
