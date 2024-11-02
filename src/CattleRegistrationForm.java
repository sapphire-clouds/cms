import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CattleRegistrationForm {
    private Stage primaryStage;
    private FarmerManager farmerManager; // Assuming this manages farmers and their cattle

    public CattleRegistrationForm(Stage primaryStage, FarmerManager farmerManager) {
        this.primaryStage = primaryStage;
        this.farmerManager = farmerManager;
    }

    public void show() {
        VBox cattleBox = new VBox(20);
        cattleBox.setAlignment(Pos.CENTER);
        cattleBox.setPadding(new Insets(30));
        cattleBox.setStyle("-fx-background-color: #260101;");

        Label titleLabel = new Label("Register Cattle");
        titleLabel.setFont(new Font("Arial", 24));
        titleLabel.setTextFill(Color.WHITE);

        // Input fields for cattle details
        TextField breedField = new TextField();
        breedField.setPromptText("Breed");
        breedField.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;");

        TextField ageField = new TextField();
        ageField.setPromptText("Age (years)");
        ageField.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;");

        TextField weightField = new TextField();
        weightField.setPromptText("Weight (kg)");
        weightField.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;");

        TextArea vaccinationRecordsField = new TextArea();
        vaccinationRecordsField.setPromptText("Vaccination Records");
        vaccinationRecordsField.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;");

        TextField insurancePolicyField = new TextField();
        insurancePolicyField.setPromptText("Insurance Policy");
        insurancePolicyField.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;");

        // Register Button
        Button registerButton = new Button("Register Cattle");
        registerButton.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-background-color: #ffffff; -fx-text-fill: black;");
        registerButton.setOnAction(e -> {
            try {
                String breed = breedField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                double weight = Double.parseDouble(weightField.getText().trim());
                String vaccinationRecords = vaccinationRecordsField.getText().trim();
                String insurancePolicy = insurancePolicyField.getText().trim();

                Cattle newCattle = new Cattle(breed, age, weight, vaccinationRecords, insurancePolicy);
                farmerManager.registerCattle(newCattle); // Assuming FarmerManager has a method to register cattle

                // Display success message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registration Successful");
                alert.setHeaderText(null);
                alert.setContentText("Cattle registered successfully with ID: " + newCattle.getId());
                alert.showAndWait();

                // Clear the fields after registration
                breedField.clear();
                ageField.clear();
                weightField.clear();
                vaccinationRecordsField.clear();
                insurancePolicyField.clear();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter valid numerical values for age and weight.");
                alert.showAndWait();
            }
        });

        // Add all components to the cattle box
        cattleBox.getChildren().addAll(titleLabel, breedField, ageField, weightField, vaccinationRecordsField, insurancePolicyField, registerButton);

        // Set scene size and show
        Scene cattleScene = new Scene(cattleBox, 800, 600);
        primaryStage.setScene(cattleScene);
        primaryStage.setTitle("Cattle Registration");
        primaryStage.show();
    }
}
