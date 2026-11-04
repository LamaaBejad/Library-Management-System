import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();
    private final HashMap<Integer, Member> members = new HashMap<>();

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
        if (members.containsKey(id)) {
            System.out.println("Member id already exists");
        } else {
            members.put(id, new Member(id, name));
            System.out.println("Member added");
        }
    }

    public void showMembers() {
        if (members.isEmpty()) {
            System.out.println("No members yet");
        } else {
            for (Member m : members.values()) {
                System.out.println(m.getId() + " - " + m.getName());
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
        return members.get(id);
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