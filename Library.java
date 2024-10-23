import javax.swing.*;
import java.util.ArrayList;

class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    public void initLibraryData() {
        Book book1 = new Book();
        book1.id = "1";
        book1.title = "Introduction to Algorithms";

        Book book2 = new Book();
        book2.id = "2";
        book2.title = "Design Patterns:Elements of OOPS";

        Book book3 = new Book();
        book3.id = "3";
        book3.title = "Clean Code: A Handbook of agile software";
        
        Book book4 = new Book();
book4.id = "4";
book4.title = "Cracking the Code Interview";

Book book5 = new Book();
book5.id = "5";
book5.title = "Eloquent Javascript";

Book book6 = new Book();
book6.id = "6";
book6.title = "Effective JAVA";

Book book7 = new Book();
book7.id = "7";
book7.title = "Let us C";

Book book8 = new Book();
book8.id = "8";
book8.title = "The Pragmatic Programmer";

Book book9 = new Book();
book9.id = "9";
book9.title = "HTML & CSS: Design and Build Websites";

Book book10 = new Book();
book10.id = "10";
book10.title = "Guide to DSA";

Book book11 = new Book();
book11.id = "11";
book11.title = "Clean Code";

Book book12 = new Book();
book12.id = "12";
book12.title = "You Don't Know JS";

Book book13 = new Book();
book13.id = "13";
book13.title = "Introduction to Algorithms";

Book book14 = new Book();
book14.id = "14";
book14.title = "Refactoring";

Book book15 = new Book();
book15.id = "15";
book15.title = "Design Patterns: Elements of Reusable Object-Oriented Software";




        Member member1 = new Member();
member1.id = "1";
member1.name = "Anita";

Member member2 = new Member();
member2.id = "2";
member2.name = "Ravi";

Member member3 = new Member();
member3.id = "3";
member3.name = "Kiran";

Member member4 = new Member();
member4.id = "4";
member4.name = "Snehal";

Member member5 = new Member();
member5.id = "5";
member5.name = "Vivek";

Member member6 = new Member();
member6.id = "6";
member6.name = "Priya";




books.add(book1);
books.add(book2);
books.add(book3);
books.add(book4);
books.add(book5);
books.add(book6);
books.add(book7);
books.add(book8);
books.add(book9);
books.add(book10);
books.add(book11);
books.add(book12);
books.add(book13);
books.add(book14);
books.add(book15);

members.add(member1);
members.add(member2);
members.add(member3);
members.add(member4);
members.add(member5);
members.add(member6);

    }

    public void showBooks() {
        StringBuilder bookList = new StringBuilder("Books:\n");
        for (Book book : books) {
            bookList.append(book.id).append(" ").append(book.title).append("\n");
        }
        JOptionPane.showMessageDialog(null, bookList.toString());
    }

    public void showMembers() {
        StringBuilder memberList = new StringBuilder("Members:\n");
        for (Member member : members) {
            memberList.append(member.id).append(" ").append(member.name).append("\n");
        }
        JOptionPane.showMessageDialog(null, memberList.toString());
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void giveBook(String memberId, String bookId) {
        // Find member and book by ID
        for (Member member : members) {
            if (member.id.equals(memberId)) {
                for (Book book : books) {
                    if (book.id.equals(bookId)) {
                        member.receiveBook(book);
                        return;
                    }
                }
            }
        }
    }

    public void receiveBook(String memberId, String bookId) {
        for (Member member : members) {
            if (member.id.equals(memberId)) {
                for (Book book : member.borrowedBooks) {
                    if (book.id.equals(bookId)) {
                        member.giveBook(book);
                        return;
                    }
                }
            }
        }
    }
}

