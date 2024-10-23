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
        frame.setSize(500, 400);

        // Create buttons for member and book-related actions
        JButton showBooksButton = new JButton("Show Books");
        JButton showMembersButton = new JButton("Show Members");
        JButton addMemberButton = new JButton("Add Member");

        // Create buttons for borrowing and returning books
        JButton borrowBookButton = new JButton("Borrow Book");
        JButton returnBookButton = new JButton("Return Book");

        // Styling buttons for aesthetics
        showBooksButton.setBackground(Color.LIGHT_GRAY);
        showMembersButton.setBackground(Color.LIGHT_GRAY);
        addMemberButton.setBackground(Color.LIGHT_GRAY);

        borrowBookButton.setBackground(Color.CYAN);
        returnBookButton.setBackground(Color.CYAN);

        // Create a panel for the show and add member buttons
        JPanel memberPanel = new JPanel();
        memberPanel.setLayout(new GridLayout(3, 1, 10, 10));
        memberPanel.setBorder(BorderFactory.createTitledBorder("Library Options"));
        memberPanel.add(showBooksButton);
        memberPanel.add(showMembersButton);
        memberPanel.add(addMemberButton);

        // Create a panel for the borrow and return buttons at the bottom
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        actionPanel.add(borrowBookButton);
        actionPanel.add(returnBookButton);

        // Create the main panel to hold the memberPanel and actionPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.add(memberPanel, BorderLayout.CENTER);
        mainPanel.add(actionPanel, BorderLayout.SOUTH);

        // Add main panel to the frame
        frame.add(mainPanel);
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

