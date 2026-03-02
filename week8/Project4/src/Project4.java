import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Date: 2026-03-01
 *
 * Time interval Checker Application
 * - User can input start and stop times for two seperate intervals of time and
 * an individual time
 * - The application will determine if either interval is a subset of another,
 * if the intervals overlap, or if the intervals are disjoint
 * - The application will display the comparison in the bottom most text field
 * - If the user inputs a time in an incorrect format, a message will display
 * - The user can check each input individually by pressing the enter key after
 * each input, if incorrect, a message will display
 * - The application will also determine which interval the additional
 * individual time input it within
 * - A message will display which interval time is in, and whether it is
 * contained in both intervals or none
 * - Text fields will display 12:00 AM to 12:00 PM by defaule for both intervals
 * and 12:00 PM by default for the individual time
 * 
 * @author Lawrence Cooke
 **/
public class Project4 extends Application {
    // Instantiate all required text fields and both buttons.
    private TextField tfInterval1Start = new TextField("12:00 AM");
    private TextField tfInterval1End = new TextField("12:00 PM");
    private TextField tfInterval2Start = new TextField("12:00 AM");
    private TextField tfInterval2End = new TextField("12:00 PM");
    private TextField tfTimeCheck = new TextField("12:00 PM");
    private TextField tfOutput = new TextField();
    private Button btCompareIntervals = new Button("Compare Intervals");
    private Button btCheckTime = new Button("Check Time");

    // GridPane will be used to arrange the text fields and buttons. Labels are also
    // instantiated
    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Start Time"), 1, 0);
        gridPane.add(new Label("End Time"), 2, 0);
        gridPane.add(new Label("Time Interval 1"), 0, 1);
        gridPane.add(tfInterval1Start, 1, 1);
        gridPane.add(tfInterval1End, 2, 1);
        gridPane.add(new Label("Time Interval 2"), 0, 2);
        gridPane.add(tfInterval2Start, 1, 2);
        gridPane.add(tfInterval2End, 2, 2);
        gridPane.add(btCompareIntervals, 1, 3, 2, 1);
        gridPane.add(new Label("Time to Check"), 0, 4);
        gridPane.add(tfTimeCheck, 1, 4, 2, 1);
        gridPane.add(btCheckTime, 1, 5, 2, 1);
        gridPane.add(tfOutput, 0, 6, 3, 1);

        // Formatting for all nodes, Text field text is centered
        gridPane.setAlignment(Pos.CENTER);
        tfInterval1Start.setAlignment(Pos.BOTTOM_CENTER);
        tfInterval1End.setAlignment(Pos.BOTTOM_CENTER);
        tfInterval2Start.setAlignment(Pos.BOTTOM_CENTER);
        tfInterval2End.setAlignment(Pos.BOTTOM_CENTER);
        tfTimeCheck.setAlignment(Pos.BOTTOM_CENTER);
        tfOutput.setEditable(false);
        GridPane.setHalignment(btCompareIntervals, HPos.LEFT);
        GridPane.setHalignment(btCheckTime, HPos.LEFT);

        // Text field event handlers, the user can press the enter key after each
        // input and a message will display if the field is incorrect
        tfInterval1Start.setOnAction(e -> checkTF(tfInterval1Start.getText()));
        tfInterval2Start.setOnAction(e -> checkTF(tfInterval2Start.getText()));
        tfInterval1End.setOnAction(e -> checkTF(tfInterval1End.getText()));
        tfInterval2End.setOnAction(e -> checkTF(tfInterval2End.getText()));
        tfTimeCheck.setOnAction(e -> checkTF(tfTimeCheck.getText()));

        // Button event handlers for both buttons
        btCompareIntervals.setOnAction(e -> compareIntervals());
        btCheckTime.setOnAction(e -> checkTime());

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 450, 250);
        primaryStage.setTitle("Time Interval Checker"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    // Event handler method, uses Scanner objects to parse the strings and pass the
    // appropriate data to the Time and Interval constructors. If the user's input
    // is incorrect, an exception is thrown and its message is displayed in the
    // bottom text box. Displays which interval the individal time is contained in,
    // if it is contained in both, and if it is contained in neither
    private void checkTime() {
        Scanner i1Start = new Scanner(tfInterval1Start.getText()).useDelimiter("[: ]");
        Scanner i2Start = new Scanner(tfInterval2Start.getText()).useDelimiter("[: ]");
        Scanner i1End = new Scanner(tfInterval1End.getText()).useDelimiter("[: ]");
        Scanner i2End = new Scanner(tfInterval2End.getText()).useDelimiter("[: ]");
        Scanner timeField = new Scanner(tfTimeCheck.getText()).useDelimiter("[: ]");

        try {
            Time start1 = new Time(i1Start.nextInt(), i1Start.nextInt(), i1Start.next());
            Time end1 = new Time(i1End.nextInt(), i1End.nextInt(), i1End.next());
            Time start2 = new Time(i2Start.nextInt(), i2Start.nextInt(), i2Start.next());
            Time end2 = new Time(i2End.nextInt(), i2End.nextInt(), i2End.next());
            Time timeCheck = new Time(timeField.nextInt(), timeField.nextInt(), timeField.next());
            i1Start.close();
            i2Start.close();
            i1End.close();
            i2End.close();
            timeField.close();
            Interval<Time> interval1 = new Interval<Time>(start1, end1);
            Interval<Time> interval2 = new Interval<Time>(start2, end2);
            if (interval1.within(timeCheck) && interval2.within(timeCheck))
                tfOutput.setText("Both intervals contain the time " + timeCheck.toString());
            else if (interval1.within(timeCheck))
                tfOutput.setText("Only interval 1 contains the time " + timeCheck.toString());
            else if (interval2.within(timeCheck))
                tfOutput.setText("Only interval 2 contains the time " + timeCheck.toString());
            else
                tfOutput.setText("Neither interval contains the time " + timeCheck.toString());
        } catch (InvalidTimeException ex) {
            tfOutput.setText(ex.getMessage());
        } catch (Exception ex) {
            tfOutput.setText(ex.toString() + ": Invalid Characters entered");
        }

    }

    // Event handler method, uses Scanner objects to parse the strings and pass the
    // appropriate data to the Time and Interval constructors. If the user's input
    // is incorrect, an exception is thrown and its message is displayed in the
    // bottom text box. Displays which interval is a subinterval, if they overlap,
    // and if they are disjoint
    private void compareIntervals() {
        Scanner i1Start = new Scanner(tfInterval1Start.getText()).useDelimiter("[: ]");
        Scanner i2Start = new Scanner(tfInterval2Start.getText()).useDelimiter("[: ]");
        Scanner i1End = new Scanner(tfInterval1End.getText()).useDelimiter("[: ]");
        Scanner i2End = new Scanner(tfInterval2End.getText()).useDelimiter("[: ]");

        try {
            Time start1 = new Time(i1Start.nextInt(), i1Start.nextInt(), i1Start.next());
            Time end1 = new Time(i1End.nextInt(), i1End.nextInt(), i1End.next());
            Time start2 = new Time(i2Start.nextInt(), i2Start.nextInt(), i2Start.next());
            Time end2 = new Time(i2End.nextInt(), i2End.nextInt(), i2End.next());
            i1Start.close();
            i2Start.close();
            i1End.close();
            i2End.close();
            Interval<Time> interval1 = new Interval<Time>(start1, end1);
            Interval<Time> interval2 = new Interval<Time>(start2, end2);
            if (interval1.subinterval(interval2))
                tfOutput.setText("Interval 1 is a sub-interval of Interval 2");
            else if (interval2.subinterval(interval1))
                tfOutput.setText("Interval 2 is a sub-interval of Interval 1");
            else if (interval1.overlaps(interval2))
                tfOutput.setText("The Intervals overlap");
            else
                tfOutput.setText("The Intervals are disjoint");
        } catch (InvalidTimeException ex) {
            tfOutput.setText(ex.getMessage());
        } catch (Exception ex) {
            tfOutput.setText(ex.toString() + ": Invalid Characters entered");
        }
    }

    // Event handler method for the text fields. If the user presses the enter key,
    // a message will display in the bottom most text field indicating if the input
    // is valid
    private void checkTF(String str) {
        Scanner input = new Scanner(str).useDelimiter("[: ]");
        try {
            Time time = new Time(input.nextInt(), input.nextInt(), input.next());
            tfOutput.setText(time.toString() + " = " + time.getMilitaryTime());
        } catch (InvalidTimeException ex) {
            tfOutput.setText(ex.getMessage());
        } catch (Exception ex) {
            tfOutput.setText(ex.toString());
        }
        input.close();
    }
}
