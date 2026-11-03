
public class Library {
    private Book[] books = new Book[10];
    private int count = 0;

    public void addBook(String title) {
        if (count < books.length ) {
            books[count] = new Book(title);
            count++;
            System.out.println("Book added");
        } else {
            System.out.println("Library is full");
        }
    }
    public void showBooks() {
        if (count == 0 ) {
            System.out.println("No books yet");
        } else {
            for (int i =0; i < count; i++) {
                System.out.println((i+1) + ") " + books[i].getTitle() );
            }
        }
    }
    public void searchBook(String keyword) {
        boolean found = false;
        for(int i = 0; i<count; i++){
            if (books[i].getTitle().equalsIgnoreCase(keyword) ){
                System.out.println("Found " + books[i].getTitle() + " (#" + (i + 1) + ")");
                found = true;
            }
        }
        if(! found) {
            System.out.println("Not found");
        }
    }
}
