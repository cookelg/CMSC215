import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Date: 2026-02-17
 *
 * - Trip cost calculator JavaFX application that takes user input through text
 * fields and combo boxes to calculate the total cost of fuel, hotel, food, and
 * attractions
 * - input fields include trip distance, gasoline cost, gas mileage, number of
 * days,
 * hotel cost per day, food cost per day, and total cost of attractions
 * - The user can also specify the linear units of their trip distance, the
 * volume
 * units of their fuel price, and either miles/gallon or km/liters
 *
 * @author Lawrence Cooke
 */
public class Project3 extends Application {
    private TextField tfDistance = new TextField();
    private TextField tfGasCost = new TextField();
    private TextField tfGasMileage = new TextField();
    private TextField tfNumDays = new TextField();
    private TextField tfHotelCost = new TextField();
    private TextField tfFoodCost = new TextField();
    private TextField tfAttractions = new TextField();
    private TextField tfTotalTripCost = new TextField();
    private Button btCalculate = new Button("Calculate");
    // String arrays contain the values seen inside the combo boxes
    private String[] linearUnits = { "miles", "kilometers" };
    private String[] volumeUnits = { "dollars/gal", "dollars/liter" };
    private String[] fuelRateUnits = { "miles/gallon", "kilometers/liter" };
    private ComboBox<String> cboLinearUnits = new ComboBox<>();
    private ComboBox<String> cboVolumeUnits = new ComboBox<>();
    private ComboBox<String> cboFuelRateUnits = new ComboBox<>();
    // constants contain the values used to convert mi to km and gal to liters
    private static final double KILOMETERS_PER_MILE = 1.609347;
    private static final double LITERS_PER_GALLON = 3.78541178;

    @Override
    public void start(Stage primaryStage) {
        // Create UI, utilizing a grid pane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Distance:"), 0, 0);
        gridPane.add(tfDistance, 1, 0);
        gridPane.add(cboLinearUnits, 3, 0);
        gridPane.add(new Label("Gasoline Cost:"), 0, 1);
        gridPane.add(tfGasCost, 1, 1);
        gridPane.add(cboVolumeUnits, 3, 1);
        gridPane.add(new Label("Gas Mileage:"), 0, 2);
        gridPane.add(tfGasMileage, 1, 2);
        gridPane.add(cboFuelRateUnits, 3, 2);
        gridPane.add(new Label("Number Of Days:"), 0, 3);
        gridPane.add(tfNumDays, 1, 3);
        gridPane.add(new Label("Hotel Cost:"), 0, 4);
        gridPane.add(tfHotelCost, 1, 4);
        gridPane.add(new Label("Food Cost:"), 0, 5);
        gridPane.add(tfFoodCost, 1, 5);
        gridPane.add(new Label("Attractions:"), 0, 6);
        gridPane.add(tfAttractions, 1, 6);
        // calculate button located above the total trip cost
        gridPane.add(btCalculate, 1, 7);
        gridPane.add(new Label("Total Trip Cost:"), 0, 8);
        gridPane.add(tfTotalTripCost, 1, 8);

        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        tfDistance.setAlignment(Pos.BOTTOM_RIGHT);
        tfGasCost.setAlignment(Pos.BOTTOM_RIGHT);
        tfGasMileage.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumDays.setAlignment(Pos.BOTTOM_RIGHT);
        tfHotelCost.setAlignment(Pos.BOTTOM_RIGHT);
        tfFoodCost.setAlignment(Pos.BOTTOM_RIGHT);
        tfAttractions.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotalTripCost.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotalTripCost.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);
        cboLinearUnits.setPrefWidth(100);
        cboLinearUnits.setValue(linearUnits[1]);
        cboVolumeUnits.setPrefWidth(100);
        cboVolumeUnits.setValue(volumeUnits[1]);
        cboFuelRateUnits.setPrefWidth(100);
        cboFuelRateUnits.setValue(fuelRateUnits[1]);

        ObservableList<String> items1 = FXCollections.observableArrayList(linearUnits);
        cboLinearUnits.getItems().addAll(items1);
        ObservableList<String> items2 = FXCollections.observableArrayList(volumeUnits);
        cboVolumeUnits.getItems().addAll(items2);
        ObservableList<String> items3 = FXCollections.observableArrayList(fuelRateUnits);
        cboFuelRateUnits.getItems().addAll(items3);

        // utilizing css style to shrink the font size of the whole pane.
        gridPane.setStyle("-fx-font-size: 10");

        // Process events
        btCalculate.setOnAction(e -> calculateTotal());

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("Trip Cost Estimator"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * - calculateTotal class method is used to handle the event fired from the user
     * clicking the "Calculate" button with the mouse
     * - if the user chooses any imperial units from the combo boxes, they will be
     * converted to metric
     */
    private void calculateTotal() {
        // Get values from text fields
        double distance = Double.parseDouble(tfDistance.getText());
        double gasCost = Double.parseDouble(tfGasCost.getText());
        double gasMileage = Double.parseDouble(tfGasMileage.getText());
        int numDays = Integer.parseInt(tfNumDays.getText());
        double hotelCost = Double.parseDouble(tfHotelCost.getText());
        double foodCost = Double.parseDouble(tfFoodCost.getText());
        double attractions = Double.parseDouble(tfAttractions.getText());
        String linearUnit = cboLinearUnits.getValue();
        String volumeUnit = cboVolumeUnits.getValue();
        String fuelRateUnit = cboFuelRateUnits.getValue();

        // These three control statements will ensure that all units will be metric
        // before they are passed to the constructor
        if (linearUnit.equals("miles"))
            distance *= KILOMETERS_PER_MILE;
        if (volumeUnit.equals("dollars/gal"))
            gasCost *= LITERS_PER_GALLON;
        if (fuelRateUnit.equals("miles/gallon"))
            gasMileage *= (LITERS_PER_GALLON / KILOMETERS_PER_MILE);

        // Print messages used to check the accuracy of the individual values
        // System.out.println("distance " + distance);
        // System.out.println("gas Cost " + gasCost);
        // System.out.println("gas mileage " + gasMileage);

        TripCost trip = new TripCost(distance, gasCost, gasMileage, numDays,
                hotelCost, foodCost, attractions);

        // Display the total Trip cost in the appropriate text field.
        tfTotalTripCost.setText(String.format("$%.2f",
                trip.getTripCost()));
    }
}
