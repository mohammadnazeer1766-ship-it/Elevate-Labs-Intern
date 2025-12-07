import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.PriorityQueue;

public class TaskManager extends JFrame {
    private PriorityQueue<Task> taskQueue = new PriorityQueue<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> taskList = new JList<>(listModel);

    public TaskManager() {
        setTitle("Smart Task Scheduler");
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JButton addBtn = new JButton("Add Task");
        JButton delBtn = new JButton("Delete");
        JButton saveBtn = new JButton("Save");
        JButton loadBtn = new JButton("Load");
        JPanel topPanel = new JPanel();
        topPanel.add(addBtn);
        topPanel.add(delBtn);
        topPanel.add(saveBtn);
        topPanel.add(loadBtn);
        add(topPanel, BorderLayout.NORTH);

        add(new JScrollPane(taskList), BorderLayout.CENTER);
        addBtn.addActionListener(e -> addTask());
        delBtn.addActionListener(e -> deleteTask());
        saveBtn.addActionListener(e -> FileHandler.save(taskQueue));
        loadBtn.addActionListener(e -> loadTasks());

        setVisible(true);
    }

    private void addTask() {
        String title = JOptionPane.showInputDialog("Enter Task Title:");
        String[] options = {"1-High", "2-Medium", "3-Low"};
        int priority = JOptionPane.showOptionDialog(null, "Select Priority", "Priority",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) + 1;

        String date = JOptionPane.showInputDialog("Enter Deadline (YYYY-MM-DD):");
        Task task = new Task(title, priority, LocalDate.parse(date));

        taskQueue.add(task);
        refreshList();
    }

    private void deleteTask() 
    {
        if (taskQueue.isEmpty()) return;
        taskQueue.poll(); 
        refreshList();
    }

    private void refreshList() 
    {
        listModel.clear();
        taskQueue.forEach(t -> listModel.addElement(t.toString()));
    }

    private void loadTasks()
     {
        taskQueue = FileHandler.load();
        refreshList();
    }

    public static void main(String[] args)
     {
        new TaskManager();
        Reminder.startReminderCheck();
    }
}

