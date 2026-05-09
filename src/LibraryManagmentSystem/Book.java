package LibraryManagmentSystem;

public class Book {
    @Required
    @MaxLength(10)
    private final String title;

    @Required
    @MaxLength(10)
    private final String author;

    private final Genre genre;
    private final String description;
    private final Integer pageCount;
    private final Double rating;


    public Book(String title, String author, Genre genre,
                     String description, Integer pageCount, Double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.pageCount = pageCount;
        this.rating = rating;
    }
}
