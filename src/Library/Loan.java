package Library;

import java.time.LocalDate;

public class Loan {
    protected Book book;
    protected Member member;
    protected LocalDate date;

    private Loan(Book book, Member member, LocalDate date) {
        this.book = book;
        this.member = member;
        this.date = date;
    }

    public static Loan create(Member member, Book book) {
        if (member == null || book == null) return null;
        if (book.isCheckedOut()) return null;
        return new Loan(book, member, LocalDate.now());
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book +
                ", member=" + member +
                ", date=" + date +
                '}';
    }
}