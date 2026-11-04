import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
       Library library = new Library() ;
        while (choice != 7 ) {
            System.out.println("=== Library System ===");
            System.out.println("1) Add book");
            System.out.println("2) Show books");
            System.out.println("3) Search");
            System.out.println("4) Add member");
            System.out.println("5) Show members");
            System.out.println("6) broow book");
            System.out.println("7) Exit");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Title: ");
                library.addBook(sc.nextLine() );
            } else if (choice == 2) {
                library.showBooks();
            } else if (choice == 3) {
                System.out.println(" Search title: ");
                library.searchBook(sc.nextLine() );
            } else if (choice == 4 ) {
                System.out.println("Member id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Member name: ");
                String name = sc.nextLine();
                library.addMember(id, name);
            } else if (choice == 5 ) {
                library.showMembers();
            } else if (choice == 6 ) {
                System.out.print("Member id: ");
                int memberId = sc.nextInt();
                sc.nextLine();
                System.out.print("Book title: ");
                String title = sc.nextLine();
                library.borrowBook(memberId, title);
            } else if (choice != 7) {
                System.out.println("Invalid choice");
            }
            }
        System.out.println("Goodbye!");
    }

    }
