import javax.swing.*;

public class AdminDashboard extends JFrame {
    private Admin admin;

    public AdminDashboard(Admin admin) {
        this.admin = admin;
        setTitle("Admin Dashboard - EventEase");
        setSize(500, 400);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("Welcome, " + admin.username);
        add(welcomeLabel);

        JButton manageEventsBtn = new JButton("Manage Events");
        JButton viewBookingsBtn = new JButton("View Bookings");
        JButton generateReportsBtn = new JButton("Generate Reports");

        add(manageEventsBtn);
        add(viewBookingsBtn);
        add(generateReportsBtn);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}