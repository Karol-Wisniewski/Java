import java.util.ArrayList;

public class GradesList {

    private ArrayList<Double> gradeList;

    public GradesList() {};

    private boolean checkList() {
        return gradeList == null;
    }
    public void addGrade (double grade) {
        if (grade < 2 || grade > 5 || grade % 0.5 != 0) {
            return;
        }
        if (gradeList == null) {
            gradeList = new ArrayList<Double>();
        }
        gradeList.add(grade);
    };

    public double getAverage() {
        if (checkList()) {
            return 0;
        }
        double sum = 0;
        for (double grade : gradeList) {
            sum += grade;
        }
        return sum / gradeList.size();
    };

    public double getLowest() {
        if (checkList()) {
            return 0;
        }
        double lowest = gradeList.get(0);
        for (double grade : gradeList) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    };

    public double getHighest() {
        if (checkList()) {
            return 0;
        }
        double highest = gradeList.get(0);
        for (double grade : gradeList) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    };
}
