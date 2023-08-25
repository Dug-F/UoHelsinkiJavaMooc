import java.util.ArrayList;

public class ExerciseManagement {
    
    private ArrayList<Exercise> exercises;
    
    public ExerciseManagement() {
        System.out.println("Hello " + this.exercises.contains("Hello"));
    }
    
    public ArrayList<String> exerciseList() {
        ArrayList<String> list = new ArrayList<>();
        for (Exercise exercise : this.exercises) {
            list.add(exercise.getName());
        }
        
        return list;
    }
    
    public void add(String exercise) {
        this.exercises.add(new Exercise(exercise));
    }
    
    public void markAsCompleted(String exerciseName) {
        for (Exercise exercise : exercises) {
            if (exercise.getName() == exerciseName) {
                exercise.setCompleted(true);
                break;
            }
        }
    }
    
    public boolean isCompleted(String exerciseName) {
        for (Exercise exercise : exercises) {
            if (exercise.getName() == exerciseName) {
                return true;
            }
        }
        return false;
    }
}
