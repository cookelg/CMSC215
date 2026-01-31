public class Undergraduate extends Student {
    private String studentYear;

    public Undergraduate(String studentName, int creditHours, int qualityPoints, String studentYear) {
        super(studentName, creditHours, qualityPoints);
        this.studentYear = studentYear;
    }

    @Override
    public boolean eligibleForHonorSociety() {
        String s = studentYear.toLowerCase();
        return (gpa() >= getGpaThreshold()) &&
                (s.equals("junior") || s.equals("senior"));
    }

    @Override
    public String toString() {
        return super.toString() + " / " + studentYear;
    }
}
