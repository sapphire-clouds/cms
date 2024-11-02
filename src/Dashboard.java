import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Dashboard {
    private Stage primaryStage;
    private FarmerManager farmerManager; // Manager that handles farmers' data
    private String username; // Username of the logged-in farmer

    public Dashboard(Stage primaryStage, FarmerManager farmerManager, String username) {
        this.primaryStage = primaryStage;
        this.farmerManager = farmerManager;
        this.username = username;
    }

    public void show() {
        VBox dashboardBox = new VBox(20);
        dashboardBox.setAlignment(Pos.CENTER);
        dashboardBox.setPadding(new Insets(30));
        dashboardBox.setStyle("-fx-background-color: #260101;");

        // Title Label
        Label titleLabel = new Label("Welcome to the Farmer Dashboard, " + username + "!");
        titleLabel.setFont(new Font("Arial", 24));
        titleLabel.setTextFill(Color.WHITE);

        // Button for Cattle Registration
        Button registerCattleButton = new Button("Register Cattle");
        registerCattleButton.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-background-color: #ffffff; -fx-text-fill: black;");
        
        // Action for Cattle Registration button
        registerCattleButton.setOnAction(e -> {
            CattleRegistrationForm cattleRegistrationForm = new CattleRegistrationForm(primaryStage, farmerManager);
            cattleRegistrationForm.show();
        });

        // Add all components to the dashboard box
        dashboardBox.getChildren().addAll(titleLabel, registerCattleButton);
        
        // Set scene size and show
        Scene dashboardScene = new Scene(dashboardBox, 800, 600);
        primaryStage.setScene(dashboardScene);
        primaryStage.setTitle("Farmer Dashboard");
        primaryStage.show();
    }
}
