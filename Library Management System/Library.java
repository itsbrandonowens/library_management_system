
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {

    private List<Book> books;
    private List<Member> members;

    // Constructor
    Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // Methods
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(String ISBN) {
        Optional<Book> bookToRemove = books.stream().filter(book-> book.getISBN().equals(ISBN)).findFirst(); 
        if(bookToRemove.isPresent()){
            books.remove(bookToRemove.get());
            System.out.println("Book removed: " + bookToRemove.get().getTitle());
        } else {
            System.out.println("Book with ISBN: " + ISBN + " is not found");
        }
        /*
        The result of findFirst is assigned to booksToRemove. Optional is used as it can contain a book, but it may also be empty 
        if the bookToRemove is present (isPresent() is a method of Optional and returns true if there is a non-null value there) then remove the book
        if not then print the book cant be found 
        */
    }

    public Book searchBookByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
        /*
         * stream() converts the books list into a stream to allow filtering.
         * filter() filters the elements based on a condition - this uses a lambda
         * expression to take the
         * users input and compares it to a books title(equalsIgnoreCase makes it so the
         * case of the input doesnt matter)
         * findFirst() returns the first Optional<Book> and terminates.
         * if a book is not found OrElse() returns null
         */
    }

    public Book searchBookByISBN(String ISBN) {
        return books.stream()
                .filter(book -> book.getISBN().equals(ISBN))
                .findFirst()
                .orElse(null);
    }

    public void listBooks() {
        System.out.println("List of Books: ");
        books.forEach(book -> System.out.println(book));
    } // uses forEach() to output all books in the book list

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added: " + member.getName());
    }

    public void removeMember(String memberID) {
      Optional<Member> memberToRemove = members.stream().filter(member->member.getMemberID().equals(memberID)).findFirst();
        if(memberToRemove.isPresent()){
            members.remove(memberToRemove.get());
            System.out.println("Member removed: " + memberToRemove.get().getName());
        } else { 
            System.out.println("Member with MemberID: " + memberID + " is not found");
        }
    }

    public Member searchMemberByID(String memberID){
        return members.stream().filter(member->member.getMemberID().equals(memberID)).findFirst().orElse(null);
    }

    public void listMembers(){
        System.out.println("List of Members: ");
        members.forEach(member -> System.out.println(member));
    }

    public void borrowBook(String memberID, String ISBN){
        Member member = searchMemberByID(memberID);
        Book book = searchBookByISBN(ISBN);

        if (member!= null && book!=null){
            member.borrowBook(book);
        } else{
            System.out.println("Either the member, or the book was not found");
        }
    }

    public void returnBook(String memberID, String ISBN) {
        Member member = searchMemberByID(memberID);
        Book book = searchBookByISBN(ISBN);

        if (member!= null && book!=null){
            member.returnBook(book);
        } else{
            System.out.println("Either the member, or the book was not found");
        }
    }
   
}
