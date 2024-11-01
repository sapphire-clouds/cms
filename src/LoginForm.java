import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginForm {
    private Stage primaryStage;
    private FarmerManager farmerManager;

    public LoginForm(Stage primaryStage, FarmerManager farmerManager) {
        this.primaryStage = primaryStage;
        this.farmerManager = farmerManager;
    }

    public void show() {
        VBox loginBox = new VBox(20);
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setPadding(new Insets(30));
        loginBox.setStyle(
            "-fx-background-color: #260101; " +
            "-fx-background-radius: 15;"
        );

        Label titleLabel = new Label("Login to Your Account");
        titleLabel.setFont(new Font("Arial", 24));
        titleLabel.setTextFill(Color.WHITE);

        // Set fixed width and height for fields and buttons
        double fieldWidth = 350; // Preferred width
        double fieldHeight = 50; // Preferred height
        double buttonWidth = 200; // Preferred width for the button

        // Create the TextField for Username
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;");
        usernameField.setPrefSize(fieldWidth, fieldHeight);
        usernameField.setMinSize(fieldWidth, fieldHeight);
        usernameField.setMaxSize(fieldWidth, fieldHeight);

        // Create the PasswordField for Password
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;");
        passwordField.setPrefSize(fieldWidth, fieldHeight);
        passwordField.setMinSize(fieldWidth, fieldHeight);
        passwordField.setMaxSize(fieldWidth, fieldHeight);

        // Create the Login Button
        Button loginButton = new Button("Login");
        loginButton.setPrefSize(buttonWidth, fieldHeight);
        loginButton.setMinSize(buttonWidth, fieldHeight);
        loginButton.setMaxSize(buttonWidth, fieldHeight);
        loginButton.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Create the TextArea for Login Status
        TextArea loginStatus = new TextArea();
        loginStatus.setEditable(false);
        loginStatus.setWrapText(true);
        loginStatus.setPrefSize(fieldWidth, 60);
        loginStatus.setMinSize(fieldWidth, 60);
        loginStatus.setMaxSize(fieldWidth, 60);
        loginStatus.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;");

        // Button action for login
        loginButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            if (username.isEmpty() || password.isEmpty()) {
                loginStatus.setText("Please fill in both fields to login.");
            } else {
                if (farmerManager.loginFarmer(username, password)) {
                    loginStatus.setText("Login successful. Welcome, " + username + "!");
                    // Here you would typically load the next page after successful login.
                } else {
                    loginStatus.setText("Invalid username or password. Please try again.");
                }
            }
        });

        // Add all components to the login box
        loginBox.getChildren().addAll(titleLabel, usernameField, passwordField, loginButton, loginStatus);

        // Set a fixed scene size
        Scene loginScene = new Scene(loginBox, 800, 600);
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }
}
