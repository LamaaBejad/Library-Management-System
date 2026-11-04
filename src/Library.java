
public class Library {

    private final Book[] books = new Book[10];
    private int count = 0;
    private final  Member[] members = new Member[10];
    private int memberCount = 0;

    public void addBook(String title) {
        if (count < books.length) {
            books[count] = new Book(title);
            count++;
            System.out.println("Book added");
        } else {
            System.out.println("Library is full");
        }
    }

    public void showBooks() {
        if (count == 0) {
            System.out.println("No books yet");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ") " + books[i].getTitle());
            }
        }
    }

    public void searchBook(String keyword) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(keyword)) {
                System.out.println("Found " + books[i].getTitle() + " (#" + (i + 1) + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found");
        }
    }

    public void addMember(int id, String name) {
        if (memberCount < members.length) {
            members[memberCount] = new Member(id, name);
            memberCount++;
            System.out.println("Member added");
        } else {
            System.out.println("Member list is full");
        }
    }

    public void showMembers() {
        if (memberCount == 0) {
            System.out.println("No members yet");
        } else {
            for (int i = 0; i < memberCount; i++) {
                System.out.println(members[i].getId() + " - " + members[i].getName());
            }
        }
    }
    private Book findBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    private Member findMember(int id) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId() == id) {
                return members[i];
            }
        }
        return null;
    }
    public void borrowBook(int memberId, String title) {
        Member member = findMember(memberId);
        Book book = findBook(title);

        if (member == null) {
            System.out.println("Member not found");
        } else if (book == null) {
            System.out.println("Book not found");
        } else if (!book.isAvailable()) {
            System.out.println("Book is already borrowed");
        } else {
            book.setAvailable(false);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        }
    }
    public void returnBook(String title) {
        Book book = findBook(title);

        if (book == null) {
            System.out.println("Book not found");
        } else if (book.isAvailable()) {
            System.out.println("Book was not borrowed");
        } else {
            book.setAvailable(true);
            System.out.println(book.getTitle() + " returned");
        }
    }
}
