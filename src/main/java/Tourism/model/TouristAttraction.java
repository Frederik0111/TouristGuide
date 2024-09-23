package Tourism.model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private List<TouristAttraction> attractions =
            new ArrayList<>(List.of(
                    new TouristAttraction("Tokyo Tower", "Old red and white radio tower", "Tokyo", List.of("Building")),
                    new TouristAttraction("Shibuya Crossing", "World's busiest street crossing", "Tokyo", List.of("Area"))
            ));

    public List<TouristAttraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<TouristAttraction> attractions) {
        this.attractions = attractions;
    }
}

