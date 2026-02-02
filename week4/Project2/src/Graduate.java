/**
 * Date: 02/01/2026
 *
 * Graduate class extends Student, overrides eligibleForHonorSociety with
 * criteria that is specific to Graduate students
 *
 * @author Lawrence Cooke
 */
public class Graduate extends Student {
    /** String indicating the graduate student's degree path */
    private String degreePath;

    /**
     * Class constructor, makes use of the superclass constructor
     *
     * @param studentName   A String representing the Student's last name. Should be
     *                      formatted as "FirstName,LastName"
     * @param creditHours   An integer representing the student's completed credit
     *                      hours
     * @param qualityPoints An integer representing the student's quality points
     * @param degreePath    A String representing the Student's degree path, should
     *                      only contain "Masters", or "Doctorate"
     */
    public Graduate(String studentName, int creditHours, int qualityPoints, String degreePath) {
        super(studentName, creditHours, qualityPoints);
        this.degreePath = degreePath;
    }

    /**
     * Overridden method with added criteria specific to Graduates
     *
     * @return true if the student's gpa is above the threshold and the student is
     *         pursuing a Masters; returns false otherwise
     */
    @Override
    public boolean eligibleForHonorSociety() {
        String s = degreePath.toLowerCase();
        return (gpa() >= getGpaThreshold()) && s.equals("masters");
    }

    /**
     * Overridden method that returns information specific to the student
     *
     * @return returns a String with the student's name, GPA, and the student's
     *         degree path
     */
    @Override
    public String toString() {
        return super.toString() + " / " + degreePath;
    }
}
