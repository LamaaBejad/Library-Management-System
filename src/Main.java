import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        Book[] books = new Book[10];
        int count = 0;
        while (choice != 4) {
            System.out.println("=== Library System ===");
            System.out.println("1) Add book");
            System.out.println("2) Show books");
            System.out.println("3) Search ");
            System.out.println("4) Exit");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                if (count < books.length) {
                    System.out.print("Title: ");
                    books[count] =new Book (sc.nextLine());
                    count++;
                    System.out.println(" Book added ");
                } else {
                    System.out.println(" Library is full ");
                }
            } else if (choice == 2) {
                showBooks(books, count);
            } else if (choice == 3) {
                System.out.println(" Search title: ");
                String keyword = sc.nextLine();
                searchBook(books, count, keyword);
            } else if (choice !=4 ) {
                System.out.println("Invalid choice");
            }
        }
        System.out.println("Goodbye!");
    }

    static void showBooks(Book[] books, int count) {
        if (count == 0) {
            System.out.println("No books yet");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ") " + books[i].getTitle() );
            }
        }
    }

    static void searchBook(Book[] books, int count, String keyword) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(keyword)) {
                System.out.println("Found: " + books[i].getTitle() + " (#" + (i + 1) + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found");
        }
    }
}