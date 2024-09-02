// Handles the console based UI to interact with the library, such as adding books, registering members, borrowing and returning books

//Additional Features
//Implement a due date system with a simple date library, where books must be returned within a specific period.
//Add exception handling for cases like borrowing a book that is already borrowed, or trying to return a book that was not borrowed.
//Store and load data from a file so that the library system's state persists between runs.

import java.util.Scanner;

public class LibrarySystem {
    private Library library;
    private Scanner scanner;

    public LibrarySystem() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n--- Library System Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register Member");
            System.out.println("4. Remove Member");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. List All Books");
            System.out.println("8. List All Members");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    registerMember();
                    break;
                case 4:
                    removeMember();
                    break;
                case 5:
                    borrowBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    library.listBooks();
                    break;
                case 8:
                    library.listMembers();
                    break;
                case 9:
                    System.out.println("Exiting the system...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }
    }

    private void addBook(){
        System.out.println("Enter book title: ");
        String title = scanner.nextLine();
        System.out.println("Enter author name: ");
        String author = scanner.nextLine();
        System.out.println("Enter ISBN number: ");
        String ISBN = scanner.nextLine(); // takes the users input for title, author and ISBN

        Book book = new Book (title, author,ISBN); // creates a book object using the users inputs
        library.addBook(book); // adds the book object to the library class
    }

    private void removeBook(){
        System.out.println("Enter ISBN number of book you want to remove: ");
        String ISBN = scanner.nextLine();
        library.removeBook(ISBN);
    }

    private void registerMember(){
        System.out.println("Enter member name: ");
        String name = scanner.nextLine();
        System.out.println("Enter member ID: ");
        String memberID = scanner.nextLine();

        Member member = new Member(name, memberID);
        library.addMember(member);
    }

    private void removeMember(){
        System.out.println("Enter the member ID of the user you want to remove: ");
        String memberID = scanner.nextLine();
        library.removeMember(memberID);
    }

    private void borrowBook(){
        System.out.println("Enter your memberID: ");
        String memberID = scanner.nextLine();
        System.out.println("Enter the books ISBN that you want to borrow: ");
        String ISBN = scanner.nextLine();
        library.borrowBook(memberID, ISBN);
    }

    private void returnBook(){
        System.out.println("Enter your memberID: ");
        String memberID = scanner.nextLine();
        System.out.println("Enter the books ISBN that you want to return: ");
        String ISBN = scanner.nextLine();
        library.returnBook(memberID, ISBN);
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.start();
    }
}
