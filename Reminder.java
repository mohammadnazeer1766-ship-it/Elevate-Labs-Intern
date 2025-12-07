import javax.swing.*;
import java.time.LocalDate;
import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;

public class Reminder {
    public static void startReminderCheck() {
        Timer timer = new Timer(true);

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    PriorityQueue<Task> tasks = FileHandler.load();
                    tasks.forEach(task -> {
                        if (task.getDeadline().equals(LocalDate.now())) {
                            JOptionPane.showMessageDialog(null,
                                    "⚠ Reminder: Today is the deadline for: " + task.getTitle());
                        }
                    });
                } catch (Exception ignored) {}
            }
        }, 0, 60000); 
    }
}

