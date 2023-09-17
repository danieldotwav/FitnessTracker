import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Year;
import javax.swing.JOptionPane;

class FitnessTracker {
    String activity;
    int duration;
    LocalDate date;

    FitnessTracker() {
        setFitnessTracker("Running", 0, LocalDate.of(Year.now().getValue(), 1, 1));
    }
    FitnessTracker(String n_activity, int n_duration, LocalDate n_date) {
        setFitnessTracker(n_activity, n_duration, n_date);
    }

    void setFitnessTracker(String n_activity, int n_duration, LocalDate n_date) {
        activity = n_activity;
        duration = n_duration;
        date = n_date;
    }
    void setActivity(String n_activity) { setFitnessTracker(n_activity, duration, date); }
    void setDuration(int n_duration) { setFitnessTracker(activity, n_duration, date); }
    void setDate(LocalDate n_date) { setFitnessTracker(activity, duration, n_date); }
    String getActivity() { return activity; }
    int getDuration() { return duration; }
    LocalDate getDate() { return date; }

    String Print() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, YYYY");
        String formattedDate = date.format(formatter);
        return "Activity: " + activity + "\nDuration: " + duration + " min\nDate: " + formattedDate;
    }
}

public class Main {
    public static void main(String[] args) {
        int numTrackers = 3;
        FitnessTracker[] trackers = new FitnessTracker[numTrackers];

        String activity = JOptionPane.showInputDialog(null, "Enter Activity Name: ");
        String durationStr = JOptionPane.showInputDialog(null, "Enter Exercise Duration (Minutes): ");
        String dateStr = JOptionPane.showInputDialog(null, "Enter Date (MM-DD-YYYY): ");

        int duration = Integer.parseInt(durationStr);
        LocalDate date = parseDate(dateStr);

        trackers[0] = new FitnessTracker(activity, duration, date);
        JOptionPane.showMessageDialog(null, trackers[0].Print());

        activity = JOptionPane.showInputDialog(null, "Enter Activity Name: ");
        durationStr = JOptionPane.showInputDialog(null, "Enter Exercise Duration (Minutes): ");
        dateStr = JOptionPane.showInputDialog(null, "Enter Date (MM-DD-YYYY): ");

        duration = Integer.parseInt(durationStr);
        date = parseDate(dateStr);

        trackers[1] = new FitnessTracker();
        trackers[1].setFitnessTracker(activity, duration, date);
        JOptionPane.showMessageDialog(null, trackers[1].Print());

        trackers[2] = new FitnessTracker();
        JOptionPane.showMessageDialog(null, trackers[2].Print());
    }
    // Helper Function to format and parse date from user string
    static LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return LocalDate.parse(dateStr, formatter);
    }
}