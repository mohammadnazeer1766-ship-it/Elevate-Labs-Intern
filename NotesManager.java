import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class NotesManager {

    static String fileName = "notes.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== NOTES MANAGER =====");
            System.out.println("1. Write Notes");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    writeNotes();
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);
    }

    // --- WRITE NOTES ---
    public static void writeNotes() {
        try {
            FileWriter writer = new FileWriter(fileName, true); // append = true
            System.out.println("Enter your note (type 'END' to finish):");

            while (true) {
                String note = sc.nextLine();
                if (note.equalsIgnoreCase("END"))
                    break;

                writer.write(note + "\n");
            }

            writer.close();
            System.out.println("Notes saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // --- READ NOTES ---
    public static void readNotes() {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);

            System.out.println("\n----- Your Notes -----");
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            reader.close();}
       catch (IOException e) {
            System.out.println("No notes found or error reading file.");
       }
    }
}