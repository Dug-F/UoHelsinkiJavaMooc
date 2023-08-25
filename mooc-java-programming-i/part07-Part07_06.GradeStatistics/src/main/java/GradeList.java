import java.util.ArrayList;

public class GradeList {
    private ArrayList<Grade> grades;
    
    public GradeList() {
        this.grades = new ArrayList<>();
    }
    
    public void add(int grade) {
        this.grades.add(new Grade(grade));
    }
    
    public boolean contains(int grade) {
        Grade checkGrade = new Grade(grade);
        return this.grades.contains(checkGrade);
    }
    
    public Stats getFinalStats() {
        Stats stats = new Stats();
        
        for (Grade grade : grades) {
            stats.addGrade(grade.getGrade(), grade.getPassed(), grade.getDistribution());
        }
        
        return stats;
    }
       
}
