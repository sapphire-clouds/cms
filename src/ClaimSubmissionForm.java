import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClaimSubmissionForm {
    private Stage primaryStage;
    private FarmerManager farmerManager;

    public ClaimSubmissionForm(Stage primaryStage, FarmerManager farmerManager) {
        this.primaryStage = primaryStage;
        this.farmerManager = farmerManager;
    }

    public void show() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-background-color: #260101;");

        Label titleLabel = new Label("Insurance Claim Submission");
        titleLabel.setFont(new Font("Arial", 24));
        titleLabel.setTextFill(Color.WHITE);
        grid.add(titleLabel, 0, 0, 2, 1);

        // Cattle details input
        TextField cattleIDField = new TextField();
        cattleIDField.setPromptText("Cattle ID");
        grid.add(cattleIDField, 0, 1);

        TextField reasonField = new TextField();
        reasonField.setPromptText("Reason for Claim");
        grid.add(reasonField, 1, 1);

        Button submitButton = new Button("Submit Claim");
        grid.add(submitButton, 0, 2, 2, 1);
        submitButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;");

        submitButton.setOnAction(e -> {
            String cattleID = cattleIDField.getText();
            String reason = reasonField.getText();
            // Logic for submitting the claim here
            System.out.println("Submitting claim for Cattle ID: " + cattleID + ", Reason: " + reason);
            // Reset fields after submission
            cattleIDField.clear();
            reasonField.clear();
        });

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Claim Submission");
        primaryStage.show();
    }
}
