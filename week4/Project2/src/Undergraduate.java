/**
 * Date: 02/01/2026
 *
 * Undergraduate class extends Student, overrides eligibleForHonorSociety with
 * criteria that is specific to Undergraduate students
 *
 * @author Lawrence Cooke
 */
public class Undergraduate extends Student {
    /**
     * String indicating what year the student is attending, should only contain
     * Freshman, Sophmore, Junior, or Senior
     */
    private String studentYear;

    /**
     * Class constructor, makes use of the superclass constructor
     *
     * @param studentName   A String representing the Student's last name. Should be
     *                      formatted as "FirstName,LastName"
     * @param creditHours   An integer representing the student's completed credit
     *                      hours
     * @param qualityPoints An integer representing the student's quality points
     * @param studentYear   A String representing the Student's year, should only
     *                      contain "Freshman", "Sophmore", "Junior", or "Senior"
     */
    public Undergraduate(String studentName, int creditHours, int qualityPoints, String studentYear) {
        super(studentName, creditHours, qualityPoints);
        this.studentYear = studentYear;
    }

    /**
     * Overridden method with added criteria specific to undergraduates
     *
     * @return true if the student's gpa is above the threshold and the student is
     *         a junior or a senior; returns false otherwise
     */
    @Override
    public boolean eligibleForHonorSociety() {
        String s = studentYear.toLowerCase();
        return (gpa() >= getGpaThreshold()) &&
                (s.equals("junior") || s.equals("senior"));
    }

    /**
     * Overridden method that returns information specific to the student
     *
     * @return returns a String with the student's name, GPA, and the student's year
     */
    @Override
    public String toString() {
        return super.toString() + " / " + studentYear;
    }
}
