import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
       Library library = new Library() ;
        while (choice != 4) {
            System.out.println("=== Library System ===");
            System.out.println("1) Add book");
            System.out.println("2) Show books");
            System.out.println("3) Search ");
            System.out.println("4) Exit");

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
            } else if (choice !=4 ) {
                System.out.println("Invalid choice");
            }
        }
        System.out.println("Goodbye!");
    }

    }
