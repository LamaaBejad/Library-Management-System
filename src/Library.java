import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();
    private final Member[] members = new Member[10];
    private int memberCount = 0;

    public void addBook(String title) {
        books.add(new Book(title));
        System.out.println("Book added");
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books yet");
        } else {
            for (int i = 0; i < books.size(); i++) {
                Book b = books.get(i);
                String status = b.isAvailable() ? "Available" : "Borrowed";
                System.out.println((i + 1) + ") " + b.getTitle() + " - " + status);
            }
        }
    }

    public void searchBook(String keyword) {
        Book book = findBook(keyword);
        if (book == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Found: " + book.getTitle());
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
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
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
