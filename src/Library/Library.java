package Library;

public class Library {
    protected final Book[] libraryBooks = new Book[100];
    protected final Member[] allMembers = new Member[20];
    protected int bookCount = 0;
    protected int countForMembers = 0;

    public void addBook(Book book){
        libraryBooks[bookCount++] = book;
    }

    public void registerMember(Member member){
        allMembers[countForMembers++] = member;
    }

    public String findBookByTitle(String title){
        for (int i = 0; i < 100; i ++){
            if(libraryBooks[i].getTitle().equalsIgnoreCase(title)){
                return libraryBooks[i].toString();
            }
        }
        return null;
    }
public int getTotalCheckedOut() {
    int count = 0;

    for (int i = 0; i < bookCount; i++) {
        if (libraryBooks[i].isCheckedOut()) {
            count++;
        }
    }

    return count;
}
}
