package Library;


public class Member {
    protected final String name;
    protected final int memberId;
    protected Book[] booksBorrowed = new Book[5];
    protected int count = 0;

    public Member(String name, int memberId){
        this.name = name;
        this.memberId = memberId;
    }

    public boolean borrow(Book book){
        if(book == null || book.isCheckedOut || count > 4) return false;
        booksBorrowed[count++] = book;
        book.checkOut();
        return true;
    }

    public boolean returnBook(Book book){
        for(int i = 0; i < 5; i++){
            if(booksBorrowed[i] == book){
             book.returnBook();
             booksBorrowed[i] = null;
             count--;
             return true;
             }
        }
        return false;
    }
    public Book[] getBorrowedBooks() {
        Book[] booksFixed = new Book[count];
            for (int i = 0; i < count; i++) {
            booksFixed[i] = booksBorrowed[i];
        }
        return booksFixed;
    }

}
