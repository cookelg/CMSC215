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

public class Project4 extends Application {
    private TextField tfInterval1Start = new TextField();
    private TextField tfInterval1End = new TextField();
    private TextField tfInterval2Start = new TextField();
    private TextField tfInterval2End = new TextField();
    private TextField tfTimeCheck = new TextField();
    private TextField tfOutput = new TextField();
    private Button btCompareIntervals = new Button("Compare Intervals");
    private Button btCheckTime = new Button("Check Time");

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

        gridPane.setAlignment(Pos.CENTER);
        tfInterval1Start.setAlignment(Pos.BOTTOM_CENTER);
        tfInterval1End.setAlignment(Pos.BOTTOM_CENTER);
        tfInterval2Start.setAlignment(Pos.BOTTOM_CENTER);
        tfInterval2End.setAlignment(Pos.BOTTOM_CENTER);
        tfTimeCheck.setAlignment(Pos.BOTTOM_CENTER);
        tfOutput.setEditable(false);
        GridPane.setHalignment(btCompareIntervals, HPos.LEFT);
        GridPane.setHalignment(btCheckTime, HPos.LEFT);

        tfInterval1Start.setOnAction(e -> checkTF(tfInterval1Start.getText()));
        tfInterval2Start.setOnAction(e -> checkTF(tfInterval2Start.getText()));
        tfInterval1End.setOnAction(e -> checkTF(tfInterval1End.getText()));
        tfInterval2End.setOnAction(e -> checkTF(tfInterval2End.getText()));
        tfTimeCheck.setOnAction(e -> checkTF(tfTimeCheck.getText()));

        btCompareIntervals.setOnAction(e -> compareIntervals());

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 450, 250);
        primaryStage.setTitle("Time Interval Checker"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

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
