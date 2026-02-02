import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Date: 02/01/2026
 *
 * Project2 contains the main method to run the overall program;
 * the main method takes an input file passed as an argument in the command
 * line;
 * if no argument is passed, the main method will look for a file named
 * students.txt
 * in the local directory;
 * Student objects are instantiated and added to an arrayList from the input
 * file;
 * After all students have been added, the GPA threshold is displayed to the
 * console, then all elligible students are displayed
 *
 * @throws FileNotFoundException if the input file is not found
 *
 * @author Lawrence Cooke
 */
public class Project2 {
    /**
     * main method
     * 
     * @param args[0] Optional command line argument for the filepath to the source
     *                file
     */
    public static void main(String[] args) throws FileNotFoundException {
        File sourceFile;
        if (args.length > 0) { // tests if a CLI argument exists
            sourceFile = new File(args[0]);
        } else { // if no CLI argument exists, program will look for students.txt
            sourceFile = new File("students.txt");
        }

        ArrayList<Student> studentList = new ArrayList<>();

        // try block is used to take advantage of the auto-close() functionality
        try (Scanner input = new Scanner(sourceFile);) {
            while (input.hasNext()) { // while loop ends after all data is read
                String studentName = input.next();
                int creditHours = input.nextInt();
                int qualityPoints = input.nextInt();
                String yearOrDegree = input.next();

                // Instantiates Student objects as either Undergraduate or Graduate
                // based on the String in yearOrDegree
                if (yearOrDegree.toLowerCase().equals("masters") ||
                        yearOrDegree.toLowerCase().equals("doctorate")) {
                    studentList.add(new Graduate(studentName, creditHours, qualityPoints, yearOrDegree));
                } else {
                    studentList.add(new Undergraduate(studentName, creditHours, qualityPoints, yearOrDegree));
                }
            }
        }
        // Prints the threshold GPA. The value is calculated when the method is
        // called
        System.out.printf("The GPA threshold for membership is %.2f\n", Student.getGpaThreshold());
        System.out.println("Elligible Students:");

        // Only Prints student information if the overridden class methods return true.
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.eligibleForHonorSociety())
                System.out.println(student.toString());
        }
    }
}
