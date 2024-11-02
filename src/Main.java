import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private FarmerManager farmerManager = new FarmerManager(); // Assume you have a FarmerManager class

    @Override
    public void start(Stage primaryStage) {
        WelcomePage welcomePage = new WelcomePage(primaryStage, farmerManager); // Ensure you have a WelcomePage class
        welcomePage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
