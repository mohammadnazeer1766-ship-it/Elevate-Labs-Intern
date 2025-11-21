import javax.swing.*;
import java.awt.*;

public class TodoApp {

    public static void main(String[] args) {

        // Create main frame
        JFrame frame = new JFrame("To-Do List");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // List model + JList
        DefaultListModel<String> tasks = new DefaultListModel<>();
        JList<String> taskList = new JList<>(tasks);

        // Text field and buttons
        JTextField taskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Selected");

        // Top panel (text + add button)
        JPanel topPanel = new JPanel();
        topPanel.add(taskField);
        topPanel.add(addButton);

        // Add button action
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                tasks.addElement(task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a task!");
            }
        });

        // Delete button action
        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                tasks.remove(index);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a task to delete!");
            }
        });

        // Add components to frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
