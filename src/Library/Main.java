package Library;

public class Main {
    public static void main(String[] args){
    Library lib = new Library();

    Book book1 = new Book("1984", "Orwell", 328);
    Book book2 = new Book("Dune", "Herbert", 688);
    lib.addBook(book1);
    lib.addBook(book2);
    Member alice = new Member("Alice", 1);
    lib.registerMember(alice);

    Loan loan1 = Loan.create(alice, book1);
    System.out.println(loan1.toString());

    alice.borrow(book1);
    System.out.println(book1.isCheckedOut()); // true
    System.out.println(lib.getTotalCheckedOut()); // 1

    alice.borrow(book1); // already checked out, should fail
    System.out.println(alice.getBorrowedBooks().length); // still 1

    alice.returnBook(book1);
    System.out.println(book1.isCheckedOut()); // false
    System.out.println(lib.getTotalCheckedOut()); // 0
    }
}