/**
 * Represents a book with various attributes like ISBN, authors, publication year, etc.
 */
public class Book {
    private String isbn;
    private String authors;
    private final int publicationYear;
    private final String originalTitle;
    private String title;
    private final double averageRating;

    /**
     * Constructor to create a new Book instance.
     *
     * @param isbn            The ISBN of the book.
     * @param authors         The authors of the book.
     * @param publicationYear The publication year of the book.
     * @param originalTitle   The original title of the book.
     * @param title           The title of the book.
     * @param averageRating   The average rating of the book.
     */
    public Book(String isbn, String authors, int publicationYear, String originalTitle, String title, double averageRating) {
        this.isbn = isbn;
        this.authors = authors;
        this.publicationYear = publicationYear;
        this.originalTitle = originalTitle;
        this.title = title;
        this.averageRating = averageRating;
    }

    // Getters for the used properties

    public String getIsbn() {
        return isbn;
    }

    public String getAuthors() {
        return authors;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getTitle() {
        return title;
    }

    // Setters for properties that might change

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns a string representation of the book.
     *
     * @return A string representation of the book.
     */
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", authors='" + authors + '\'' +
                ", publicationYear=" + publicationYear +
                ", originalTitle='" + originalTitle + '\'' +
                ", title='" + title + '\'' +
                ", averageRating=" + averageRating +
                '}';
    }
}
