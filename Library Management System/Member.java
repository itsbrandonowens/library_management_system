import java.util.List;
import java.util.ArrayList;

public class Member {
    String name;
    String memberID;
    private List<Book> borrowedBooks;

    // Constructor
    Member(String name, String memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new ArrayList<>(); // Initialize the list of borrowed books
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String newMemberID) {
        this.memberID = newMemberID;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Methods
    public void borrowBook(Book book) {
        if(book.getIsAvailable()){ // Check if the book is available
            borrowedBooks.add(book); // if it is, add it to the borrowedBooks list
            book.setIsAvailable(false); // set the availability of the book to false 
            System.out.println(name + " borrowed the book titled: " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is not available."); // if book is not available, print this out 
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)){ // if the user has the book in their respective array, remove it from the users borrowedBooks array
            book.setIsAvailable(true); // set the book to being available
            System.out.println(name + " returned the book titled: " + book.getTitle());
        } else {
            System.out.println(name + " did not borrow the book titled: " + book.getTitle()); // if not then print that the user did not borrow the book
        }
    }

    // Override the toString method
    @Override
    public String toString() {
        return "Member{" +
                "Name='" + name + '\'' +
                ", MemberID='" + memberID + '\'' +
                ", BorrowedBooks=" + borrowedBooks +
                '}';
    }
}
