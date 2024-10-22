import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {

    static Library library = new Library();

    public static void main(String[] args) {
        // Initialize library data
        library.initLibraryData();

        // Create the frame
        JFrame frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create buttons
        JButton showBooksButton = new JButton("Show Books");
        JButton showMembersButton = new JButton("Show Members");
        JButton addMemberButton = new JButton("Add Member");
        JButton borrowBookButton = new JButton("Borrow Book");
        JButton returnBookButton = new JButton("Return Book");

        // Panel to hold buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        // Add buttons to panel
        panel.add(showBooksButton);
        panel.add(showMembersButton);
        panel.add(addMemberButton);
        panel.add(borrowBookButton);
        panel.add(returnBookButton);

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);

        // Show books button event
        showBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                library.showBooks();
            }
        });

        // Show members button event
        showMembersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                library.showMembers();
            }
        });

        // Add member button event
        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = JOptionPane.showInputDialog("Enter Member ID:");
                String memberName = JOptionPane.showInputDialog("Enter Member Name:");
                Member newMember = new Member();
                newMember.id = memberId;
                newMember.name = memberName;
                library.addMember(newMember);
                JOptionPane.showMessageDialog(null, "Member Added Successfully!");
            }
        });

        // Borrow book button event
        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = JOptionPane.showInputDialog("Enter Member ID:");
                String bookId = JOptionPane.showInputDialog("Enter Book ID:");
                library.giveBook(memberId, bookId);
                JOptionPane.showMessageDialog(null, "Book Borrowed Successfully!");
            }
        });

        // Return book button event
        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = JOptionPane.showInputDialog("Enter Member ID:");
                String bookId = JOptionPane.showInputDialog("Enter Book ID:");
                library.receiveBook(memberId, bookId);
                JOptionPane.showMessageDialog(null, "Book Returned Successfully!");
            }
        });
    }
}

