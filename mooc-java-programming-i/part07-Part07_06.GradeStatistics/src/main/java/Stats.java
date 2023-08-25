public class Stats {
    private int countAll = 0;
    private int sumAll = 0;
    private int countPassed = 0;
    private int sumPassed = 0;
    private int[] distribution = {0, 0, 0, 0, 0, 0};
    
    public Stats() {
//        this.countAll = 0;
//        this.sumAll = 0;
//        this.countPassed = 0;
//        this.sumPassed = 0;
    }
    
    public void addGrade(int grade, boolean passed, int distribution) {
        this.countAll ++;
        this.sumAll += grade;

        if (passed) {
            this.countPassed++;
            this.sumPassed += grade;
        }
        
        if (distribution >= 0 && distribution <= 5) {
            this.distribution[distribution]++;
        }
    }

    public int getCountAll() {
        return countAll;
    }

    public int getCountPassed() {
        return countPassed;
    }

    public int getSumAll() {
        return sumAll;
    }

    public int getSumPassed() {
        return sumPassed;
    }
    
    public double getAverageAll() {
        if (this.countAll == 0) {
            return -1.0;
        }
        return (double) this.sumAll/ this.countAll;
    }
    
    public double getAveragePassed() {
        if (this.countPassed == 0) {
            return -1.0;
        }
        return (double) this.sumPassed / this.countPassed;
    }
    
    public double getPassPercentage() {
        return (double) 100 * this.countPassed / this.countAll;
    }
    
    public int[] getGradeDistribution() {
        return this.distribution;
    }
}
