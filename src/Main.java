import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * The Main class for the book management system.
 * This class demonstrates loading book data from a file and searching for books by ISBN and author.
 */
public class Main {
    /**
     * The main method to run the book management system.
     *
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Main main = new Main();
        String filePath = "BooksDataFile.txt";
        TreeMap<String, Book> booksMap = new TreeMap<>();
        List<String> isbns = new ArrayList<>();

        main.loadBooks(filePath, booksMap, isbns);

        System.out.println("Number of books loaded: " + booksMap.size());

        String searchIsbn = "0451524934";
        main.searchBookByISBN(searchIsbn, booksMap);

        String author = "Suzanne Collins";
        main.searchBooksByAuthor(author, booksMap, isbns);
    }
    /**
     * Loads book data from a specified file into a TreeMap and a list of ISBNs.
     *
     * @param filePath The path to the file containing book data.
     * @param booksMap The TreeMap to store book data, with ISBNs as keys.
     * @param isbns    The list to store the ISBNs of the books.
     */
    private void loadBooks(String filePath, TreeMap<String, Book> booksMap, List<String> isbns) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header line
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("~");
                String isbn = data[2];
                String authors = data[3];
                int publicationYear = Integer.parseInt(data[4]);
                String originalTitle = data[5];
                String title = data[6];
                double averageRating = Double.parseDouble(data[7]);

                Book book = new Book(isbn, authors, publicationYear, originalTitle, title, averageRating);
                booksMap.put(isbn, book);
                isbns.add(isbn);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
    /**
     * Searches for a book by its ISBN in the TreeMap and prints its details if found.
     *
     * @param isbn     The ISBN of the book to search for.
     * @param booksMap The TreeMap containing the book data.
     */
    private void searchBookByISBN(String isbn, TreeMap<String, Book> booksMap) {
        Book book = booksMap.get(isbn);
        if (book != null) {
            System.out.println("Book found by ISBN of " + isbn + " :");
            printBookDetails(book);
        } else {
            System.out.println("No book found with ISBN : " + isbn);
        }
    }

    /**
     * Searches for books by an author in the TreeMap and prints the details of all matching books.
     *
     * @param author   The author to search for.
     * @param booksMap The TreeMap containing the book data.
     * @param isbns    The list of ISBNs to iterate over for searching.
     */
    private void searchBooksByAuthor(String author, TreeMap<String, Book> booksMap, List<String> isbns) {
        boolean found = false;
        for (String isbn : isbns) {
            Book book = booksMap.get(isbn);
            if (book != null && book.getAuthors().contains(author)) {
                if (!found) {
                    System.out.println("<><><<><><><><><><><><><><>");
                    System.out.println();
                    System.out.println("Books found by author " + author + ":");
                    found = true;
                }
                printBookDetails(book);
            }
        }
        if (!found) {
            System.out.println("No books found by author: " + author);
        }
    }
    /**
     * Prints the details of a given book.
     *
     * @param book The book whose details are to be printed.
     */
    private void printBookDetails(Book book) {
        System.out.println("----------------------------");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Authors: " + book.getAuthors());
        System.out.println("Publication Year: " + book.getPublicationYear());
        // Include other details as necessary
    }
}
