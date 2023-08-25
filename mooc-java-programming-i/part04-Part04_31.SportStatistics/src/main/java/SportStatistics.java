
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("File:");
        String filename = scan.nextLine();
        
        System.out.println("Team:");
        String team = scan.nextLine();
        
        ArrayList<MatchStats> matchStats = readTeamFile(filename, team);
        
        int wins = 0;
        int losses = 0;
        
        for (MatchStats stat : matchStats) {
            if (stat.isWinner(team)) {
                wins++;
            } else {
                losses++;
            }
        }
        
        System.out.println("Games: " + matchStats.size());
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);

    }
    
    public static ArrayList<MatchStats> readTeamFile(String filename, String team) {
        ArrayList<MatchStats> matchStats = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(Paths.get(filename))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] matchData = row.split(",");
                if (matchData[0].equals(team) || matchData[1].equals(team)) {
                    matchStats.add(new MatchStats(matchData[0], matchData[1], Integer.valueOf(matchData[2]), Integer.valueOf(matchData[3])));
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return matchStats;
    }

}
