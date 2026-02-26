package Library;

public class Book {
    protected final String title;
    protected final String author;
    protected final int pages;
    protected boolean isCheckedOut;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isCheckedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public void checkOut() {
        if (!isCheckedOut) {
            isCheckedOut = true;
        }
    }

    public void returnBook() {
        isCheckedOut = false;
    }

    @Override
    public String toString() {
        return String.format(
                "Title: %s | Author: %s | Pages: %d | Status: %s",
                title,
                author,
                pages,
                isCheckedOut ? "Checked Out" : "Available"
        );
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }
}
