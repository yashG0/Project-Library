import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book{
    private int id;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.id = bookId;
        this.title = title;
        this.author = author;
    }

    public int bookId(){
        return id;
    }
    public String bookTitle(){
        return title;
    }
    public String bookAuthor(){
        return author;
    }

    @Override
    public String toString(){
        return "Book{" +
                "BookId = " + id +
                ", title = '" + title +'\'' +
                ", author = '" + author + '\''+
                '}';
    }
}

class Library{
    private List<Book> books;

    public Library(){
        this.books = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.bookId() == bookId) {
                return book;
            }
        }
        return null;
    }
    public void removeBook(int bookId) {
        Book bookToRemove = findBookById(bookId);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed: " + bookToRemove);
        } else {
            System.out.println("Book not found with ID: " + bookId);
        }
    }

}


public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Remove Book");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();

                    Book newBook = new Book(bookId, title, author);
                    library.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.println("List of Books:");
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter book ID to remove: ");
                    int bookToRemove = scanner.nextInt();
                    library.removeBook(bookToRemove);
                    break;
                case 4:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
