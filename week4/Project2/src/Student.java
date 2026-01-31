public abstract class Student {
    private String studentName;
    private int creditHours;
    private int qualityPoints;
    private static int numStudents;
    private static double gpaSum;
    private static double gpaThreshold;

    public Student(String studentName, int creditHours, int qualityPoints) {
        this.studentName = studentName;
        this.creditHours = creditHours;
        this.qualityPoints = qualityPoints;
        numStudents++;
        gpaSum += gpa();
    }

    public double gpa() {
        return (double) qualityPoints / creditHours;
    }

    @Override
    public String toString() {
        return "Name: " + studentName + " / GPA: " + gpa();
    }

    public abstract boolean eligibleForHonorSociety();

    public static void setGpaThreshold() {
        gpaThreshold = gpaSum / numStudents;
    }

    public static double getGpaThreshold() {
        setGpaThreshold();
        return gpaThreshold;
    }
}
