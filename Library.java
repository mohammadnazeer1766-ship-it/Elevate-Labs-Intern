import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public void viewBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void issueBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId && !b.isIssued()) {
                b.issue();
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book cannot be issued!");
    }

    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId && b.isIssued()) {
                b.returnBook();
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book cannot be returned!");
    }
}
