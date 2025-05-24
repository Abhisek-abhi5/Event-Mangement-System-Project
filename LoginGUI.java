import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginGUI extends JFrame {
    JTextField userField;
    JPasswordField passField;

    public LoginGUI() {
        setTitle("EventEase Login");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Username:"));
        userField = new JTextField();
        add(userField);

        add(new JLabel("Password:"));
        passField = new JPasswordField();
        add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> login());
        add(loginBtn);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void login() {
        String user = userField.getText();
        String pass = new String(passField.getPassword());

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?")) {
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");

                if (role.equals("Admin")) {
                    new Admin(id, user).showDashboard();
                } else {
                    JOptionPane.showMessageDialog(this, "Unknown role.");
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}