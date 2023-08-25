import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GradesListTest {
    private GradeList grades;
    
    @Before
    public void initialize() {
        this.grades = new GradeList();
    }
    
    @Test
    public void addInitialEntry() {
        this.grades.add(50);
        assertTrue(this.grades.contains(50));
    }
    
    @Test
    public void testAverage() {
        this.grades.add(50);
        this.grades.add(75);
        Stats stats = this.grades.getFinalStats();
        assertEquals(62.5, stats.getAverageAll(), 0.1);
    }
    
    @Test
    public void testAverageWhenNoGradesEntered() {
        Stats stats = this.grades.getFinalStats();
        assertEquals(-1, stats.getAverageAll(), 0.1);
    }
    
    @Test
    public void testPassingGradeAverageWhenAllPassingGradesExist() {
        this.grades.add(60);
        this.grades.add(80);
        Stats stats = this.grades.getFinalStats();
        assertEquals(70, stats.getAveragePassed(), 0.1);
    }
    
    @Test
    public void testPassingGradeAverageWhenSomeFailingGradesExist() {
        this.grades.add(33);
        this.grades.add(77);
        this.grades.add(99);
        this.grades.add(1);
        Stats stats = this.grades.getFinalStats();
        assertEquals(88, stats.getAveragePassed(), 0.1);
    }
    
    @Test
    public void testPassingGradeAverageWhenNoPassingGradesExist() {
        Stats stats = this.grades.getFinalStats();
        assertEquals(-1, stats.getAveragePassed(), 0.1);
    }

    @Test
    public void passPercentageWithNoPasses() {
        this.grades.add(49);
        this.grades.add(48);
        this.grades.add(47);
        Stats stats = this.grades.getFinalStats();
        assertEquals(0.0, stats.getPassPercentage(), 0.1);
    }
    
    @Test
    public void passPercentageWithPasses() {
        this.grades.add(33);
        this.grades.add(77);
        this.grades.add(99);
        this.grades.add(1);
        Stats stats = this.grades.getFinalStats();
        assertEquals(4, stats.getCountAll());
        assertEquals(2, stats.getCountPassed());
        assertEquals(210, stats.getSumAll());
        assertEquals(176, stats.getSumPassed());
        assertEquals(50, stats.getPassPercentage(), 0.1);
    }
    
    
//    @Test
//    public void gradeCountWithNoGrades() {
//        Stats stats = this.grades.getFinalStats();
//        assertEquals(0, this.grades.getGradeCount());
//    }
//    
//    @Test
//    public void gradeCountWithOneGrade() {
//        this.grades.add(99);
//        assertEquals(1, this.grades.getGradeCount());
//    }
//    
//    @Test
//    public void gradeCountWithThreeGrade() {
//        this.grades.add(33);
//        this.grades.add(77);
//        this.grades.add(99);
//        assertEquals(3, this.grades.getGradeCount());
//    }
//    
//    @Test
//    public void gradeDistribution0Count0() {
//        assertEquals(0, this.grades.getGradeDistribution(0));
//    
//    @Test
//    public void gradeDistribution0CountPositive() {
//        this.grades.add(33);
//        this.grades.add(49);
//        this.grades.add(50);
//        this.grades.add(77);
//        assertEquals(2, this.grades.getGradeDistribution(0));
//    }
    
}
