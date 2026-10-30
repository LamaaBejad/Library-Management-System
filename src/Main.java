import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        String[] books = new String[10];
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
                    books[count] = sc.nextLine();
                    count++;
                    System.out.println(" Book added ");
                } else
                    System.out.println(" Library is full ");
            } else if (choice == 2) {
                if (count == 0) {
                    System.out.println("No books yet");
                } else {
                    for (int i = 0; i < count; i++) {
                        System.out.println((i + 1) + ") " + books[i]);
                    }
                }
            } else if (choice == 3) {
                System.out.println(" Search title: ");
                String Keyword = sc.nextLine();
                boolean found = false;

                for (int i = 0; i < count; i++) {
                    if (books[i].equalsIgnoreCase(Keyword)) {
                        System.out.println("Found: " + books[i] + " (#" + (i + 1) + ")");
                        found = true;

                    }
                }
                if (!found) {
                    System.out.println("Not found");
                }
            }
        }
        System.out.println("Goodbye!");
}
}