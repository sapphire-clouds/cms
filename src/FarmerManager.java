import java.util.ArrayList;
import java.util.List;

public class FarmerManager {
    private List<Farmer> farmers;

    public FarmerManager() {
        farmers = new ArrayList<>();
    }

    public boolean registerFarmer(String name, String farmLocation, String username, String password) {
        for (Farmer farmer : farmers) {
            if (farmer.getUsername().equals(username)) {
                return false; // Username already exists
            }
        }
        farmers.add(new Farmer(name, farmLocation, username, password));
        return true; // Registration successful
    }

    public boolean loginFarmer(String username, String password) {
        for (Farmer farmer : farmers) {
            if (farmer.getUsername().equals(username) && farmer.getPassword().equals(password)) {
                return true; // Login successful
            }
        }
        return false; // Invalid login
    }
}
