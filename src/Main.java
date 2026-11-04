import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice = 0;

        while (choice != 8) {
            System.out.println("=== Library System ===");
            System.out.println("1) Add book");
            System.out.println("2) Show books");
            System.out.println("3) Search");
            System.out.println("4) Add member");
            System.out.println("5) Show members");
            System.out.println("6) Borrow book");
            System.out.println("7) Return book");
            System.out.println("8) Exit");

            choice = readInt(sc);

            if (choice == 1) {
                System.out.print("Title: ");
                library.addBook(sc.nextLine());
            } else if (choice == 2) {
                library.showBooks();
            } else if (choice == 3) {
                System.out.print("Search title: ");
                library.searchBook(sc.nextLine());
            } else if (choice == 4) {
                System.out.print("Member id: ");
                int id = readInt(sc);
                System.out.print("Member name: ");
                String name = sc.nextLine();
                library.addMember(id, name);
            } else if (choice == 5) {
                library.showMembers();
            } else if (choice == 6) {
                System.out.print("Member id: ");
                int memberId = readInt(sc);
                System.out.print("Book title: ");
                String title = sc.nextLine();
                library.borrowBook(memberId, title);
            } else if (choice == 7) {
                System.out.print("Book title: ");
                library.returnBook(sc.nextLine());
            } else if (choice != 8) {
                System.out.println("Invalid choice");
            }
        }
        System.out.println("Goodbye!");
    }

    static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
            }
        }
    }
}