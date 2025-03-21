package trip;
import exception.MissingCompulsoryParameter;
import exception.TravelDiaryException;

import java.util.List;
import java.util.ArrayList;

public class TripManager {
    private final List<Trip> trips = new ArrayList<>();
    private Trip selectedTrip = null;

    public void addTrip(String name, String description, String location) throws MissingCompulsoryParameter {
        trips.add(new Trip(name, description, location));
        System.out.println("Trip added successfully.");
    }

    public void setSelectedTrip(Trip selectedTrip) {
        this.selectedTrip = selectedTrip;
    }

    public void deleteTrip(int index) {
        if (index < 0 || index >= trips.size()) {
            System.out.println("Invalid trip index.");
            return;
        }
        trips.remove(index);
        System.out.println("Trip deleted successfully.");
    }

    public void viewTrips() {
        if (trips.isEmpty()) {
            System.out.println("No trips available.");
        } else {
            for (int i = 0; i < trips.size(); i++) {
                System.out.println(i + ": " + trips.get(i)); // Display index with trip details
            }
        }
    }

    public void selectTrip(int index) throws TravelDiaryException {
        if (index < 0 || index >= trips.size()) {
            System.out.println("Invalid trip index.");
            throw new TravelDiaryException();
            //return;
        }
        selectedTrip = trips.get(index);
        System.out.println("Selected trip: " + selectedTrip.name);
    }

    public Trip getSelectedTrip() {
        return this.selectedTrip;
    }
}
