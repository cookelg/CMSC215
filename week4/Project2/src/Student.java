/**
 * Date: 02/01/2026
 *
 * The Student class is an abstract class that provides common data fields that
 * apply
 * to all types of students
 * Also contains static methods to set and get the GPA threshold
 *
 * @author Lawrence Cooke
 */
public abstract class Student {
    /** Student name data field */
    private String studentName;

    /**
     * Student's credit hours data field, used with qualityPoints to calculate gpa
     */
    private int creditHours;

    /**
     * Student's quality points data field, used with creditHours to calculate gpa
     */
    private int qualityPoints;

    /** A count of the existing instances of Student */
    private static int numStudents;

    /** A running sum of each gpa as Student objects are initialized */
    private static double gpaSum;

    /** The median GPA of all instantiated Students */
    private static double gpaThreshold;

    /**
     * class constructor, will increment static variable numStudents and add the
     * new object's gpa to the static running total gpaSum.
     * 
     * @param studentName   A String representing the Student's last name. Should be
     *                      formatted as "FirstName,LastName"
     * @param creditHours   An integer representing the student's completed credit
     *                      hours
     * @param qualityPoints An integer representing the student's quality points
     */
    public Student(String studentName, int creditHours, int qualityPoints) {
        this.studentName = studentName;
        this.creditHours = creditHours;
        this.qualityPoints = qualityPoints;
        numStudents++;
        gpaSum += gpa();
    }

    /**
     * Method used to calculate the student's GPA using credit hours and quality
     * points.
     * 
     * @return if creditHours greater than 0, a double representing the calculated
     *         GPA; returns 0 otherwise.
     */
    public double gpa() {
        if (creditHours > 0) {
            return (double) qualityPoints / creditHours;
        } else
            return 0;
    }

    /**
     * Overridden toString method to get Student's information
     *
     * @return Returns a String containing students name and GPA
     *         as "Name: %s GPA: %.2f"
     */
    @Override
    public String toString() {
        return String.format("Name: %s GPA: %.2f", studentName, gpa());
    }

    /**
     * Abstract method that indicates whether or not a Student is elligible for the
     * Honor society
     * 
     * @return true if a student is elligible;
     *         false otherwise
     */
    public abstract boolean eligibleForHonorSociety();

    /**
     * static method to calculate the average gpa and set gpaThreshold
     */
    private static void setGpaThreshold() {
        if (numStudents > 0)
            gpaThreshold = gpaSum / numStudents;
    }

    /**
     * static method that runs setGpaThreshold
     *
     * @return returns the average GPA
     */
    public static double getGpaThreshold() {
        setGpaThreshold();
        return gpaThreshold;
    }
}
