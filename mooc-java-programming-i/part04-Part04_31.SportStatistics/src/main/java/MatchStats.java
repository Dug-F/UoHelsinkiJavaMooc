/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doug
 */
public class MatchStats {
    private String homeTeam;
    private String awayTeam;
    private int homeTeamPoints;
    private int awayTeamPoints;
    
    public MatchStats(String homeTeam, String awayTeam, int homeTeamPoints, int awayTeamPoints) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamPoints = homeTeamPoints;
        this.awayTeamPoints = awayTeamPoints;
        
    }
    
    public boolean isWinner(String team) {
        if (team.equals(this.homeTeam)) {
            return this.homeTeamPoints > this.awayTeamPoints;
        } else {
            return this.awayTeamPoints > this.homeTeamPoints;
        }
    }
       
}
