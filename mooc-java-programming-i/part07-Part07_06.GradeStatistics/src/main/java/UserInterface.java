import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private GradeList grades;
    
    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.grades = new GradeList();
    }
        
    public void start() {
        while(true) {
            int grade = Integer.valueOf(scanner.nextLine());

            if (grade == -1) {
                break;
            }

            if (grade < 0 || grade > 100) {
                continue;
            }

            grades.add(grade);
        }

        this.printStats();

    }

    public void printStats() {
        Stats stats = grades.getFinalStats();

        System.out.println("Point average (all): " + stats.getAverageAll());

        System.out.print("Point average (passing): ");
        if (stats.getCountPassed() == 0) {
            System.out.println("-");
        } else {
            System.out.println(stats.getAveragePassed());
        }

        if (stats.getCountAll() == 0) {
            System.out.println("Pass percentage: 0");
        } else {
            System.out.println("Pass percentage: " + stats.getPassPercentage());
        }

        int[] distribution = stats.getGradeDistribution();
        System.out.println("Grade distribution:");
        for (int i = distribution.length -1; i >= 0; i--)  {
            System.out.print(i + ": ");
            this.printStars(distribution[i]);
            System.out.println("");
        }
    }
    
    public void printStars(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
    }
            
        
}
