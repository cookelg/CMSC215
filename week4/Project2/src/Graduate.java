public class Graduate extends Student {
    private String degreePath;

    public Graduate(String studentName, int creditHours, int qualityPoints, String degreePath) {
        super(studentName, creditHours, qualityPoints);
        this.degreePath = degreePath;
    }

    @Override
    public boolean eligibleForHonorSociety() {
        String s = degreePath.toLowerCase();
        return (gpa() >= getGpaThreshold()) && s.equals("masters");
    }

    @Override
    public String toString() {
        return super.toString() + " / " + degreePath;
    }
}
