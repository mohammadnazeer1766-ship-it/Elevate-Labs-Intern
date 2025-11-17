public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(new Book(1, "Java Programming"));
        library.addBook(new Book(2, "OOP Concepts"));

        System.out.println("Books in Library:");
        library.viewBooks();

        library.issueBook(1);
        library.issueBook(1); // trying again

        library.returnBook(1);
        library.returnBook(1); // trying again
    }
}
