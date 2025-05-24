public class Admin extends User {
    public Admin(int id, String username) {
        super(id, username, "Admin");
    }

    @Override
    public void showDashboard() {
        new AdminDashboard(this).setVisible(true);
    }
}