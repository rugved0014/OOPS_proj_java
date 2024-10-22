import javax.swing.*;
import java.util.ArrayList;

class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    public void initLibraryData() {
        Book book1 = new Book();
        book1.id = "1";
        book1.title = "Pemrograman Java";

        Book book2 = new Book();
        book2.id = "2";
        book2.title = "Pemrograman OOP";

        Book book3 = new Book();
        book3.id = "3";
        book3.title = "Pemrograman Android";

        Member member1 = new Member();
        member1.id = "1";
        member1.name = "Aka";

        Member member2 = new Member();
        member2.id = "2";
        member2.name = "Budi";

        Member member3 = new Member();
        member3.id = "3";
        member3.name = "Tono";

        books.add(book1);
        books.add(book2);
        books.add(book3);

        members.add(member1);
        members.add(member2);
        members.add(member3);
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

