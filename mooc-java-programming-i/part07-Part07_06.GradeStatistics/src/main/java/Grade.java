public class Grade {
    private int grade;
    private boolean passed;
    private int distribution;
    
    public Grade(int grade) {
        this.grade = grade;
        this.passed = false;
        if (grade >= 50) {
            this.passed = true;
        }
        
        if (grade < 50) {
            this.distribution = 0;
        } else if (grade < 60) {
            this.distribution = 1;
        } else if (grade < 70) {
            this.distribution = 2;
        } else if (grade < 80)  {
            this.distribution = 3;
        } else if (grade < 90) {
            this.distribution = 4;
        } else {
            this.distribution = 5;
        }
    }
    
    public int getGrade() {
        return this.grade;
    }
    
    public boolean getPassed() {
        return this.passed;
    }
    
    public int getDistribution() {
        return this.distribution;
    }
    
    public boolean equals (Object grade) {
        if (this == grade) {
            return true;
        }
        
        if (!(grade instanceof Grade)) {
            return false;
        }
        
        Grade checkGrade = (Grade) grade;
        if (checkGrade.getGrade() == this.getGrade()) {
            return true;
        }
        
        return false;
    }
    
}
