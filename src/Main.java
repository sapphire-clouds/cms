import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private FarmerManager farmerManager = new FarmerManager();

    @Override
    public void start(Stage primaryStage) {
        WelcomePage welcomePage = new WelcomePage(primaryStage, farmerManager);
        welcomePage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
