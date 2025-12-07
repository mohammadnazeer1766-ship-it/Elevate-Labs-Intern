import javax.swing.JOptionPane;
import java.io.*;
import java.time.LocalDate;
import java.util.PriorityQueue;

public class FileHandler {

    public static void save(PriorityQueue<Task> queue) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("tasks.txt"))) {
            for (Task t : queue) {
                pw.println(t.getTitle() + "," + t.getPriority() + "," + t.getDeadline());
            }
            JOptionPane.showMessageDialog(null, "Saved Successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Saving File!");
        }
    }

    public static PriorityQueue<Task> load() {
        PriorityQueue<Task> queue = new PriorityQueue<>();
        try (BufferedReader br = new BufferedReader(new FileReader("tasks.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                queue.add(new Task(arr[0], Integer.parseInt(arr[1]), LocalDate.parse(arr[2])));
            }
            JOptionPane.showMessageDialog(null, "Loaded Successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No saved tasks found.");
        }
        return queue;
    }
}
