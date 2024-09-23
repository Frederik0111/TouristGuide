package Tourism.repository;

import java.util.ArrayList;

public class TouristRepository {
    public static ArrayList<String> attractions = new ArrayList<>();

    static {
        // Initialize the list with some default attractions
        attractions.add("Tokyo Tower");
        attractions.add("Shibuya Crossing");
    }
}
